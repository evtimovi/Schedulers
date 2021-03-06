/**
 * The class that controls everything
 * @author Renan Dincer and Ivan Evtimov
 */

import java.io.*;
import java.util.*;

public class Controller{
        
    private static PriorityQueue<Process> fq;//future queue - processes that have not arrived yet
    private static Scheduler scheduler;
    private static ArrayList<Process> doneQ = new ArrayList<Process>(); //all processes that are done
    private static double awt = 0;
    private static double awwt = 0;
    private static double art = 0;
    private static double awrt = 0;

    public static void readFile(String file) throws IOException{
        fq = new PriorityQueue<Process>(10, new ArrivalTimeComparator());
        BufferedReader bufferedReader = new BufferedReader(new FileReader (file) );
        while (bufferedReader.ready()){
            String line = bufferedReader.readLine();
            Scanner scanner = new Scanner(line).useDelimiter(",");
            int pid = scanner.nextInt();
            int burstTime = scanner.nextInt();
            int arrivalTime = scanner.nextInt();
            int priority = scanner.nextInt();
            scanner.close();
            Process process = new Process(pid, burstTime, arrivalTime, priority);
            fq.add(process);
        }
        bufferedReader.close();

    }

    public static void timestep(int time){
        while (fq.size() > 0 && fq.peek().arrivalTime() == time){
            scheduler.arrive( fq.poll() );
        }

        Process done = scheduler.run(time);
        if (done != null){
            doneQ.add(done);
        }
    }

    public static void printStats(){
        calculateStats();
        System.out.print("Average waiting time is:");
        System.out.println(awt);
        System.out.print("Average weighted waiting time is:");
        System.out.println(awwt);
        System.out.print("Average response time is:");
        System.out.println(art);
        System.out.print("Average weighted response time is:");
        System.out.println(awrt);

    }

    private static void calculateStats()
    {
        awt = 0;
        awwt = 0;
        art = 0;
        awrt = 0;

        double n = (double) doneQ.size(); 
        double sumPriority = 0;

        for( Process proc : doneQ )
        {
            awt += proc.waitTime() / n; //unweighted average
            sumPriority += (double) proc.origPriority();
            awwt += proc.waitTime() * proc.origPriority(); // will be divided by sumPriority at the end
            art += proc.responseTime() / n; //average response time 
            awrt += proc.responseTime() * proc.origPriority(); //average weighted response time (technically, just the weighted sum for now)
        }

        awwt /= sumPriority;
        awrt /= sumPriority;
    }

    public static void main(String[] args){
        String file = args[1];
        String schedulerType = args[0];
        try{
            readFile(file);
        } catch (IOException e){
            System.out.println ("IO Exception occured when reading the input file. Exiting...");
            System.out.println(e);
            System.exit(1);
        }
        
        int numProcesses = fq.size();

        // now initializing the scheduler
        switch (schedulerType){
            case "fcfs":
                scheduler = new FCFSScheduler();
                break;
            case "sjf":
                scheduler = new SJFScheduler();
                break;
            case "srtf":
                scheduler = new SRTFScheduler();
                break;
            case "nonpreprior":
                scheduler = new NonprepriorScheduler();
                break;
            case "preprior":
                scheduler = new PrepriorScheduler();
                break;
            case "rr":
                scheduler = new RRScheduler();
                break;
            default:
                scheduler = new CustomScheduler();
        }

        // most hardcore for loop we've written
        for (int time = 0; numProcesses != doneQ.size(); time++){
            timestep(time);
        }

        printStats();
    }
}
