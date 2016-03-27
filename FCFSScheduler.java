/**
 * Scheduler that implments the first come first served algorithm
 * @author Renan Dincer and Ivan Evtimov
 */

import java.util.PriorityQueue;

public class FCFSScheduler extends Scheduler {

    public FCFSScheduler()
    {
       current = null;
       rq = new PriorityQueue<Process>(new ArrivalTimeComparator()); 
    }

    public boolean contextSwitchable()
    {
        if (current == null)
        {
            return true;
        }
        return false;   
    }
}
