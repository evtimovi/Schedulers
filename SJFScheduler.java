/**
 * Scheduler that implements the shortest job first scheduling algo.
 * @author Renan Dincer and Ivan Evtimov
 */
import java.util.PriorityQueue;

public class SJFScheduler extends Scheduler {

    public SJFScheduler()
    {
		current = null;
		rq = new PriorityQueue<Process>(new BurstTimeComparator());
    }

    public boolean contextSwitchable()
    {
		if (current == null){
			return true;
		}
        return false;   
    }
}
