package Sorting;
import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Class for timing the different sorting algorithms
 */
public class Timer {

    enum Sorts {MERGE, BUCKET, QUICK, ONLOGN, JAVAARRAY }

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

    public static void timeMe(ListBuilder mainList, String text, PrettyPrinter printer){
        int[] list;
        Long start, end;

        // Setup the output to add to the pretty printer
        ArrayList results = new ArrayList();
        results.add(text);
        results.add(mainList.getSize());
        results.add(mainList.getRange());

        // Merge Sort
        list = mainList.getList();
        start = getUserTime();
        MergeSort.mergeSort(list);
        end = getUserTime();
        results.add( getDiff(start, end));

        // Bucket Sort
        list = mainList.getList();
        start = getUserTime();
        // Bucket Sort Call goes here
        end = getUserTime();
        results.add( getDiff(start, end));

        // QuickSort
        list = mainList.getList();
        start = getUserTime();
        // QuickSort Call goes here
        end = getUserTime();
        results.add( getDiff(start, end));

        // O(n log n) Sort
        list = mainList.getList();
        start = getUserTime();
        // Some O(n log n) Sort Call goes here
        end = getUserTime();
        results.add( getDiff(start, end));

        // Java Array Sort
        list = mainList.getList();
        start = getUserTime();
        Arrays.sort(list);
        end = getUserTime();
        results.add( getDiff(start, end));

        printer.addRow(results);
    }


}
