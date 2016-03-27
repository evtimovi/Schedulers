/**
 * Scheduler that implements our proprietory super secret custom scheduling algorithm
 * @author Renan Dincer and Ivan Evtimov
 */

public class CustomScheduler extends Scheduler {
    private PriorityComparator comp;

    public CustomScheduler()
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
