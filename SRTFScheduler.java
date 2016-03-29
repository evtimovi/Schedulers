/**
 * Scheduler that implements the shortest remaining time first algorithm
 * @author Renan Dincer and Ivan Evtimov
 */
import java.util.PriorityQueue;
public class SRTFScheduler extends Scheduler {

    public SRTFScheduler()
    {
		current = null;
		rq = new PriorityQueue<Process>(new TimeRemainingComparator());		
    }

    public boolean contextSwitchable()
    {
		if (current == null){
			return true;
		}
		Process temp = rq.peek();
		if (temp == null || current.timeRemaining() < temp.timeRemaining()){
			return false;
		} else {
			return true;
		}
    }
}
