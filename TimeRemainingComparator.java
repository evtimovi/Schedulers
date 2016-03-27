/**
 * Compares two processes based on their time remaining
 * @author Renan Dincer and Ivan Evtimov
 */
import java.util.Comparator;
public class TimeRemainingComparator implements Comparator<Process>{
    public int compare(Process o1, Process o2){
        return o1.timeRemaining() - o2.timeRemaining();
    }

    public boolean equals(Object obj){
        return false;
    }
}

