/**
 * Scheduler that implements the shortest job first scheduling algo.
 * @author Renan Dincer and Ivan Evtimov
 */

public class SJFScheduler extends Scheduler {
    private BurstTimeComparator comp;

    public SJFScheduler()
    {

    }

    public boolean contextSwitchable()
    {
        return true;   
    }
}
