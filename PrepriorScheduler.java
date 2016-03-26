/**
 * Scheduler that implements the priority preemptive with aging algorithm
 * @author Renan Dincer and Ivan Evtimov
 */

public class PrepriorScheduler extends Scheduler {
    private PriorityComparator comp;

    public PrepriorScheduler()
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
