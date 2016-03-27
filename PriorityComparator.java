/**
 * Compares two processes based on their prioritty
 * @author Renan Dincer and Ivan Evtimov
 */
import java.util.Comparator;
public class PriorityComparator implements Comparator<Process>{
    public int compare(Process o1, Process o2){
        return o1.priority() - o2.priority();
    }

    public boolean equals(Object obj){
        return false;
    }
}

