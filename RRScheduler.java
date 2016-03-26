/**
 * Scheduler that implements the ROUND ROBIN!! algorithm
 * @author Renan Dincer and Ivan Evtimov
 */

public class RRScheduler extends Scheduler {

    private static int final QUANTUM = 5;
    private PriorityComparator comp;
    private quantumRemaining;//how much time the current process has remaining out of its quantum

    public RRScheduler()
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
