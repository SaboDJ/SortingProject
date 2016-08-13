package Sorting;
import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

/**
 * Created by Gaming on 8/12/2016.
 */
public class Timer {

    enum Sorts {QUICK, MERGE, BUCKET, JAVA }

    Timer(PrettyPrinter printer){
    }


    /** Get user time in nanoseconds. */
    public static long getUserTime( ) {
        ThreadMXBean bean = ManagementFactory.getThreadMXBean( );
        return bean.isCurrentThreadCpuTimeSupported( ) ?
                bean.getCurrentThreadUserTime( ) : 0L;
    }

    /**
     * Returns the number of seconds run
     */
    private static Double getDiff(Long start, Long end){
        return Double.valueOf((end - start) )/ 1000000000;
    }

    public static void timeMe(ListBuilder mainList, String text, PrettyPrinter printer, int range){
       int[] list = mainList.getList();

        // Setup the output to add to the pretty printer
        ArrayList results = new ArrayList();
        results.add(text);
        results.add(list.length);
        results.add(range);


        for(Sorts sort : Sorts.values()) {
            Long start, end;
         switch(sort){
             case QUICK:
                 start = getUserTime();
       //          System.out.println("Time the QuickSort");
                 end = getUserTime();
       //          System.out.println(Sorts.QUICK.toString() + "\t" + getDiff(start, end));
                 results.add( getDiff(start, end));
                 break;

             case MERGE:
                 start = getUserTime();
        //         System.out.println("Time the Merge Sort");
                 end = getUserTime();
       //          System.out.println(Sorts.MERGE.toString() + "\t" + getDiff(start, end));
                 results.add( getDiff(start, end));
                 break;

             case BUCKET:
                 start = getUserTime();
        //         System.out.println("Time the Bucket Sort");
                 end = getUserTime();
       //          System.out.println(Sorts.BUCKET.toString() + "\t" + getDiff(start, end));
                 results.add( getDiff(start, end));
                 break;

             case JAVA:
                 start = getUserTime();
                 Arrays.sort(list);
                 end = getUserTime();
     //            System.out.printf("%s\t%.4f\n",Sorts.JAVA.toString(), getDiff(start, end));
                 results.add( getDiff(start, end));
                 break;


         }

     }
        printer.addRow(results);
    }


}
