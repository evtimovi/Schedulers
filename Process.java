/**
 * Process object Represents a process to be processed by the CPU
 * @author Renan Dincer and Ivan Evtimov
 */

public class Process {
    public int pid;
    public int burstTime;
    public int arrivalTime;
    public int priority;
    public int waitTime;
    public int responseTime;
    public int timeRemaining;

    public Process(int pid, int burstTime, int arrivalTime, int priority) {
        this.pid = pid;
        this.burstTime = burstTime;
        this.arrivalTime = arrivalTime;
        this.priority = priority;
        this.waitTime = 0;
        this.responseTime = 0;
        this.timeRemaining = 0;
    }

}
