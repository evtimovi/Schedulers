/**
 * Scheduler that implements the non-preemptive with aging algorithm
 * @author Renan Dincer and Ivan Evtimov
 */

public class NonprepriorScheduler extends Scheduler {
    private PriorityComparator comp;

    public NonprepriorScheduler()
    {

    }

    public boolean contextSwitchable()
    {
        return true;   
    }

    public void updateRQ()
    {

    }
}
