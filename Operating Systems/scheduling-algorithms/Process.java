import java.util.*;

public class Process {
    public int processArivalTime;
    public int processBurstTime;
    public int waitingTime;// The time a process waits before execution
    public int turnAroundTime;// Total time the process takes in the system

    // Based on arrival time we want to rearrange the processes
    public Process(int arrivalTime, int burstTime) {
        this.processArivalTime = arrivalTime;
        this.processBurstTime = burstTime;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Number of Processes: ");
        int no_ofProcesses = sc.nextInt();
        FCFS CpuScheduler = new FCFS();// Class for first come first served method of execution

        int[] Arrivaltimes = new int[no_ofProcesses];
        int sum = 0;
        Process[] processes = new Process[no_ofProcesses];
        for (int i = 0; i < no_ofProcesses; i++) {
            System.out.print("Enter Arrival Time for Process PID_" + (i + 1) + ": ");
            int individualArrivalTime = sc.nextInt();
            System.out.print("Enter Burst Time for Process PID_" + (i + 1) + ": ");
            int individualBurstTime = sc.nextInt();
            Process thisProcess = new Process(individualArrivalTime, individualBurstTime);
            processes[i] = thisProcess;

            Arrivaltimes[i] = thisProcess.processArivalTime;
        }
        for (var x : Arrivaltimes) {
            System.out.print(x + " ");
        }
        for (var y : processes) {
            System.out.print(y + " ");
            sum = sum + y.processArivalTime;
        }
        System.out.println(sum);

    }
}