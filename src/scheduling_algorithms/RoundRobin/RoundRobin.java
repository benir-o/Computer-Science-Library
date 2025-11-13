package scheduling_algorithms.RoundRobin;

import java.util.*;

class Process {
    int pid; // Process ID
    int burstTime; // Burst Time
    int remainingTime; // Remaining Burst Time
    int waitingTime; // Waiting Time
    int turnaroundTime; // Turnaround Time
    int arrivalTime; // Arrival Time

    Process(int pid, int burstTime, int arrivalTime) {
        this.pid = pid;
        this.burstTime = burstTime;
        this.remainingTime = burstTime;
        this.arrivalTime = arrivalTime;
    }
}

public class RoundRobin {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of processes: ");
        int n = sc.nextInt();

        Process[] processes = new Process[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\nProcess " + (i + 1) + ":");
            System.out.print("Enter arrival time: ");
            int arrivalTime = sc.nextInt();
            System.out.print("Enter burst time: ");
            int burstTime = sc.nextInt();

            processes[i] = new Process(i + 1, burstTime, arrivalTime);
        }

        System.out.print("\nEnter time quantum: ");
        int quantum = sc.nextInt();

        roundRobinScheduling(processes, n, quantum);
        sc.close();
    }

    static void roundRobinScheduling(Process[] processes, int n, int quantum) {
        int currentTime = 0;
        int completed = 0;
        // We can set processes to a linked list
        Queue<Process> queue = new LinkedList<>();

        // We utilize sort and the lambda expressions to return arrivalTimes in an
        // orderly manner
        Arrays.sort(processes, Comparator.comparingInt(p -> p.arrivalTime));
        queue.add(processes[0]);

        while (!queue.isEmpty()) {
            Process current = queue.poll();

            // We then calculate time slice
            int executeTime = Math.min(quantum, current.remainingTime);
            current.remainingTime -= executeTime;
            currentTime += executeTime;

            // We then add newly arrived processes to the queue
            for (Process p : processes) {
                if (p.arrivalTime <= currentTime && p.remainingTime > 0 && !queue.contains(p)) {
                    queue.add(p);
                }
            }

            // We then check if process finished
            if (current.remainingTime == 0) {
                completed++;
                current.turnaroundTime = currentTime - current.arrivalTime;
                current.waitingTime = current.turnaroundTime - current.burstTime;
            } else {
                queue.add(current);
            }

            // We stop if all processes are done
            if (completed == n)
                break;
        }

        printResults(processes);
    }

    static void printResults(Process[] processes) {
        System.out.println("\nPID\tArrival\tBurst\tWaiting\tTurnaround");
        double totalWT = 0, totalTAT = 0;

        for (Process p : processes) {
            System.out.printf("%d\t%d\t%d\t%d\t%d\n",
                    p.pid, p.arrivalTime, p.burstTime, p.waitingTime, p.turnaroundTime);
            totalWT += p.waitingTime;
            totalTAT += p.turnaroundTime;
        }

        System.out.printf("\nAverage Waiting Time: %.2f", totalWT / processes.length);
        System.out.printf("\nAverage Turnaround Time: %.2f\n", totalTAT / processes.length);
    }
}
