/**
 * Scheduler that implments the first come first served algorithm
 * @author Renan Dincer and Ivan Evtimov
 */

public class FCFSScheduler extends Scheduler {
    private ArrivalTimeComparator comp;

    public FCFSScheduler()
    {

    }

    public boolean contextSwitchable()
    {
        return true;   
    }
}
