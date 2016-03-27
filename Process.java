/**
 * Process object Represents a process to be processed by the CPU
 * @author Renan Dincer and Ivan Evtimov
 */

import java.lang.Integer;

public class Process {
    private int pid;
    private int burstTime;
    private int arrivalTime;
    private int priority;
    private int origPriority;
    private int waitTime;
    private int responseTime;
    private int timeRemaining;
    private boolean ran; // indicates if the process ran at least once

    public  Process(int pid, int burstTime, int arrivalTime, int priority) {
        this.pid = pid;
        this.burstTime = burstTime;
        this.arrivalTime = arrivalTime;
        this.priority = priority;
        this.origPriority = priority;
        this.waitTime = 0;
        this.responseTime = Integer.MAX_VALUE;
        this.timeRemaining = burstTime;
        this.ran = false;
    }


    public  int pid(){ return pid; }
    public  int burstTime() { return burstTime; }
    public  int arrivalTime() { return arrivalTime; };
    public  int priority() { return priority; }
    public  int waitTime() { return waitTime; }
    public  int responseTime() { return responseTime; }
    public  int timeRemaining() { return timeRemaining; }
    public  int origPriority() { return origPriority; }


    //simulates the process running in the CPU and updates stats accordingly
    //currTime is the time step in which the process runs in the CPU
    public void cpuTime(int currTime){
        //keep track of response time
       if(!ran){
           responseTime = currTime - arrivalTime;
           ran = true;
       }
    
       timeRemaining--;
    }


    //process spending wait time in ready queue
    public void waitForCPU()
    {
        waitTime++;        
    }

    //increase priority for ageing
    public void increasePriority()
    {
        priority++;
    }
}
