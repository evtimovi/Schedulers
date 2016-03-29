/**
 * Scheduler that implements the non-preemptive with aging algorithm
 * @author Renan Dincer and Ivan Evtimov
 */
import java.util.PriorityQueue;
public class NonprepriorScheduler extends Scheduler {

    public NonprepriorScheduler()
    {
 		current = null;
		rq = new PriorityQueue<Process>(new PriorityComparator());
    }

    public boolean contextSwitchable()
    {
        if (current == null){
			return true;
		}
		return false;
    }

    public void updateRQ()
    {	
		PriorityQueue<Process> temprq =  new PriorityQueue<Process>(new PriorityComparator());
 
		for (Process proc : rq){
			proc.waitForCPU();
			proc.increasePriority();
		}
		// update the priority queue
		temprq.addAll(rq);
		rq = temprq;
    }
}
