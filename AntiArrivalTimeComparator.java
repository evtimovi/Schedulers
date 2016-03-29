/**
 * Compares two processes based on their arrival time (but the other way around)
 * @author Renan Dincer and Ivan Evtimov
 */

import java.util.Comparator;

public class AntiArrivalTimeComparator implements Comparator<Process>{
    public int compare(Process o1, Process o2){
        return o2.arrivalTime() - o1.arrivalTime();
    }

    public boolean equals(Object obj){
        return false;
    }
}

