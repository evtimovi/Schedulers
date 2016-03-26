/**
 * Scheduler that implements the shortest remaining time first algorithm
 * @author Renan Dincer and Ivan Evtimov
 */

public class SRTFScheduler extends Scheduler {
    private TimeRemainingComparator comp;

    public SRTFScheduler()
    {

    }

    public boolean contextSwitchable()
    {
        return true;   
    }
}
