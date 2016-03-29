/**
 * Scheduler that implements our proprietory super secret custom scheduling algorithm
 * It is basically Last Come First Serve - Optimizing for response time.
 * @author Renan Dincer and Ivan Evtimov
 */

import java.util.PriorityQueue;
public class CustomScheduler extends Scheduler {

    public CustomScheduler()
    {
		current = null;
		rq = new PriorityQueue<Process>(new AntiArrivalTimeComparator());

    }

    public boolean contextSwitchable()
    {
		Process temp = rq.peek();
        if(current == null){
			return true;
		} else if (temp == null || current.arrivalTime() < temp.arrivalTime()){
			return true;
		} else {
			return false;
		}
    }

}
