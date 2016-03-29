/**
 * Scheduler that implements the priority preemptive with aging algorithm
 * @author Renan Dincer and Ivan Evtimov
 */
import java.util.PriorityQueue;
public class PrepriorScheduler extends Scheduler {

    public PrepriorScheduler()
    {
		current = null;
		rq = new PriorityQueue<Process>(new PriorityComparator());
    }

	public boolean contextSwitchable()
    {
		if (current == null){
			return true;
		}
		Process temp = rq.peek();
		if (temp == null || current.priority() < temp.priority()){
			return false;
		} else {
			return true;
		}
    }

 	public void updateRQ(){	
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
