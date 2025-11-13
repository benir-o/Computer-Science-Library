package scheduling_algorithms.FCFS;

import java.util.*;

public class FCFS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of processes: ");
        int n = sc.nextInt();

        Process[] processes = new Process[n];
        for (int i = 0; i < n; i++) {
            processes[i] = new Process();
            processes[i].pid = i + 1;

            System.out.print("Enter arrival time for process " + (i + 1) + ": ");
            processes[i].arrival = sc.nextInt();

            System.out.print("Enter burst time for process " + (i + 1) + ": ");
            processes[i].burst = sc.nextInt();
        }

        // Sorting the Arrival Times for each Process using bubble sort
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (processes[j].arrival > processes[j + 1].arrival) {
                    Process temp = processes[j];
                    processes[j] = processes[j + 1];
                    processes[j + 1] = temp;
                }
            }
        }

        // Calculate Waiting and Turnaround Times
        int currentTime = 0;
        for (int i = 0; i < n; i++) {
            if (currentTime < processes[i].arrival)
                currentTime = processes[i].arrival; // CPU is idle until process arrives

            processes[i].waiting = currentTime - processes[i].arrival;
            currentTime += processes[i].burst;
            processes[i].turnaround = processes[i].waiting + processes[i].burst;
        }

        // Display results
        System.out.println("\nPID\tArrival\tBurst\tWaiting\tTurnaround");
        double totalWaiting = 0, totalTurnaround = 0;
        for (Process p : processes) {
            System.out.println(p.pid + "\t" + p.arrival + "\t" + p.burst + "\t" + p.waiting + "\t" + p.turnaround);
            totalWaiting += p.waiting;
            totalTurnaround += p.turnaround;
        }

        System.out.printf("\nAverage Waiting Time: %.2f", totalWaiting / n);
        System.out.printf("\nAverage Turnaround Time: %.2f\n", totalTurnaround / n);
        sc.close();
    }
}
