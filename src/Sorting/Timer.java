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
        Long start, end;

        // Setup the output to add to the pretty printer
        ArrayList results = new ArrayList();
        results.add(text);
        results.add(list.length);
        results.add(range);

        // QuickSort Test
        start = getUserTime();
        // QuickSort Call goes here
        end = getUserTime();
        results.add( getDiff(start, end));

        // Merge Sort Test
        start = getUserTime();
        // Merge Sort Call goes here
        end = getUserTime();
        results.add( getDiff(start, end));

        // Bucket Sort Test
        start = getUserTime();
        // Bucket Sort Call goes here
        end = getUserTime();
        results.add( getDiff(start, end));

        // Java Sort Test
        start = getUserTime();
        Arrays.sort(list);
        end = getUserTime();
        results.add( getDiff(start, end));

        printer.addRow(results);
    }


}
