/**
 * Abstract class for all schedulers, different schedulers implement different algorithms.
 * @author Renan Dincer and Ivan Evtimov
 */

import java.util.PriorityQueue;

public abstract class Scheduler {
    public Process current;
    protected PriorityQueue<Process> rq; //ReadyQueue

    public Process run(int time){
        Process done = null;
        
        //if current is done forever
        if(current != null && current.timeRemaining() == 0){
            done = current;
            current = rq.poll();
        }
        else if(contextSwitchable() || current == null){
            preempt();
            done =  null;
        }
        
        if(current == null){
            //the cpu is idle
            //System.out.println("Time " + time + ", the processor is idle");
        } else {
            System.out.println("Time: " + time + ", process " + current.pid() + " running");
        }
        updateCurrent(time);
        updateRQ();

        return done;
    }

    /*
     * Puts the processes that come from the system outside of our control (future queue) into the ready queue to be called in the beginning of each timestep.
     */
    public void arrive(Process newArrival){
        rq.offer(newArrival);
    }
    
    // This function is also known as "doContextSwitch" as it is kicking people out, putting them onto the queue and letting them in from the queue.
    public void preempt(){
        if(current != null){
            rq.offer(current);
        }
        current = rq.poll();
    }

    public void updateRQ(){
        for(Process proc : rq){
            proc.waitForCPU();
        }
    }
    public void updateCurrent(int time){
        if(current != null){
            current.cpuTime(time);
        }
    }

    // returns true if the process needs to be kicked out BECAUSE OF PREEMPTION ONLY
    public abstract boolean contextSwitchable();

}

