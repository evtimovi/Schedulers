/**
 * Abstract class for all schedulers, different schedulers implement different algorithms.
 * @author Renan Dincer and Ivan Evtimov
 */

import java.util.PriorityQueue;

public abstract class Scheduler {
    public Process current;
    private PriorityQueue<Process> rq; //ReadyQueue

    public Process run(int time){
        return null;
    }

    /*
     * Puts the processes that come from the system outside of our control (future queue) into the ready queue to be called in the beginning of each timestep.
     */
    public void arrive(Process[] newarrivals){}

    public Process preempt(){
        return null;
    }

    public void updateRQ(){}
    public void updateCurrent(){}
    public abstract boolean contextSwitchable();

}

