/**
 * Scheduler that implements the ROUND ROBIN!! algorithm
 * @author Renan Dincer and Ivan Evtimov
 */
import java.util.PriorityQueue;
public class RRScheduler extends Scheduler {

    private static final int QUANTUM = 1;
    private PriorityComparator comp;
    private int quantumRemaining;//how much time the current process has remaining out of its quantum

    public RRScheduler()
    {
		current = null;
		rq = new PriorityQueue<Process>(new BullshitComparator());
		quantumRemaining = QUANTUM;
    }

    public boolean contextSwitchable()
    {
        if (current == null){
			return true;
		}
		if (quantumRemaining == 0){
			quantumRemaining = QUANTUM;
			return true;
		} else {
			return false;
		}
    }

    public void updateCurrent(int time){
		if (current != null){
			current.cpuTime(time);
			quantumRemaining--;
		}
	}


	public void preempt(){
		Process newp = rq.poll();
		if (current != null){
			rq.offer(current);
		}
		current = newp;
	}	
}
