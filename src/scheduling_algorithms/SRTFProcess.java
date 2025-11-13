package scheduling_algorithms;

import java.util.Scanner;

public class SRTFProcess {
    int pid; // Process ID
    int arrival; // Arrival Time
    int burst; // Burst Time
    int remaining; // Remaining Time
    int waiting; // Waiting Time
    int turnaround; // Turnaround Time
    int completion; // Completion Time

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of processes: ");
        int n = sc.nextInt();
        new SRTFProcess();

        SRTFProcess[] processes = new SRTFProcess[n];
        for (int i = 0; i < n; i++) {
            processes[i] = new SRTFProcess();
            processes[i].pid = i + 1;
            System.out.print("Enter arrival time for process " + (i + 1) + ": ");
            processes[i].arrival = sc.nextInt();
            System.out.print("Enter burst time for process " + (i + 1) + ": ");
            processes[i].burst = sc.nextInt();
            processes[i].remaining = processes[i].burst;
        }

        // Calculate times using SRTF
        int completed = 0, currentTime = 0, minRemaining = Integer.MAX_VALUE;
        int shortest = -1;
        boolean found;

        while (completed != n) {
            found = false;
            minRemaining = Integer.MAX_VALUE;

            // Find the process with minimum remaining time among the arrived ones
            for (int i = 0; i < n; i++) {
                if (processes[i].arrival <= currentTime && processes[i].remaining > 0) {
                    if (processes[i].remaining < minRemaining) {
                        minRemaining = processes[i].remaining;
                        shortest = i;
                        found = true;
                    }
                }
            }

            if (!found) { // No process has arrived yet
                currentTime++;
                continue;
            }

            // Execute the shortest process for 1 unit of time
            processes[shortest].remaining--;
            minRemaining = processes[shortest].remaining;
            if (minRemaining == 0)
                minRemaining = Integer.MAX_VALUE; // Reset for next search

            // If process is finished
            if (processes[shortest].remaining == 0) {
                completed++;
                found = false;

                int finishTime = currentTime + 1;
                processes[shortest].completion = finishTime;
                processes[shortest].turnaround = finishTime - processes[shortest].arrival;
                processes[shortest].waiting = processes[shortest].turnaround - processes[shortest].burst;

                if (processes[shortest].waiting < 0)
                    processes[shortest].waiting = 0;
            }

            currentTime++;
        }

        // Display results
        System.out.println("\nPID\tArrival\tBurst\tWaiting\tTurnaround\tCompletion");
        double totalWaiting = 0, totalTurnaround = 0;
        for (SRTFProcess p : processes) {
            System.out.println(p.pid + "\t" + p.arrival + "\t" + p.burst + "\t" + p.waiting + "\t" + p.turnaround
                    + "\t\t" + p.completion);
            totalWaiting += p.waiting;
            totalTurnaround += p.turnaround;
        }

        System.out.printf("\nAverage Waiting Time: %.2f", totalWaiting / n);
        System.out.printf("\nAverage Turnaround Time: %.2f\n", totalTurnaround / n);
        sc.close();
    }

}
