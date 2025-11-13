package scheduling_algorithms.priority_scheduling_preemptive;

import java.util.*;

class Process {
    int pid; // Process ID
    int arrivalTime;
    int burstTime;
    int remainingTime;
    int priority; // Lower value means we could assign higher priority to the processes
    int completionTime;
    int waitingTime;
    int turnaroundTime;

    // We then construct the parameters of the process.
    Process(int pid, int arrivalTime, int burstTime, int priority) {
        this.pid = pid;
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
        this.remainingTime = burstTime;
        this.priority = priority;
    }
}

public class PreemptivePriorityScheduling {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of processes: ");
        int n = sc.nextInt();
        Process[] processes = new Process[n];

        // We collect the process details via input
        for (int i = 0; i < n; i++) {
            System.out.println("Process " + (i + 1) + ":");
            System.out.print("Arrival Time: ");
            int at = sc.nextInt();
            System.out.print("Burst Time: ");
            int bt = sc.nextInt();
            System.out.print("Priority (lower number will be assigned a higher priority): ");
            int pr = sc.nextInt();
            processes[i] = new Process(i + 1, at, bt, pr);
        }

        int currentTime = 0;
        int completed = 0;
        int prev = -1;
        boolean[] isCompleted = new boolean[n];

        while (completed != n) {
            int idx = -1;
            int highestPriority = Integer.MAX_VALUE;

            // We try finding the process with the highes priority at the current time
            for (int i = 0; i < n; i++) {
                if (processes[i].arrivalTime <= currentTime && !isCompleted[i]) {
                    if (processes[i].priority < highestPriority) {
                        highestPriority = processes[i].priority;
                        idx = i;
                    } else if (processes[i].priority == highestPriority) {
                        // We choose the process with the highest arrival time
                        if (processes[i].arrivalTime < processes[idx].arrivalTime) {
                            idx = i;
                        }
                    }
                }
            }

            if (idx != -1) {
                processes[idx].remainingTime--;
                currentTime++;

                // We check if the process finishes
                if (processes[idx].remainingTime == 0) {
                    processes[idx].completionTime = currentTime;
                    processes[idx].turnaroundTime = processes[idx].completionTime - processes[idx].arrivalTime;
                    processes[idx].waitingTime = processes[idx].turnaroundTime - processes[idx].burstTime;
                    isCompleted[idx] = true;
                    completed++;
                }
            } else {
                currentTime++; // No process is ready, increment time
            }
        }

        // We then display results
        System.out.println("\nProcess\tArrival\tBurst\tPriority\tWaiting\tTurnaround");
        int totalWT = 0, totalTAT = 0;
        for (Process p : processes) {
            System.out.println(p.pid + "\t\t" + p.arrivalTime + "\t\t" + p.burstTime + "\t\t" + p.priority + "\t\t"
                    + p.waitingTime + "\t\t" + p.turnaroundTime);
            totalWT += p.waitingTime;
            totalTAT += p.turnaroundTime;
        }

        System.out.printf("\nAverage Waiting Time: %.2f", (float) totalWT / n);
        System.out.printf("\nAverage Turnaround Time: %.2f\n", (float) totalTAT / n);

        sc.close();
    }
}
