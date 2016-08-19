package Sorting;
import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Class for timing the different sorting algorithms
 */
public class Timer {

    enum Sorts {MERGE, BUCKET, QUICK, HEAP, JAVAARRAY }

    final ListBuilder mainList;

    /**
     * @param mainList the list to use
     */
    Timer(ListBuilder mainList){
        this.mainList = mainList;
    }

    /** Get user time in nanoseconds. */
    public  long getUserTime( ) {
        ThreadMXBean bean = ManagementFactory.getThreadMXBean( );
        return bean.isCurrentThreadCpuTimeSupported( ) ?
                bean.getCurrentThreadUserTime( ) : 0L;
      //  return  System.nanoTime();
    }

    /**
     * Returns the number of seconds run
     */
    private  Double getDiff(Long start, Long end){
        return Double.valueOf((end - start) )/ 1000000000;
    }

    public  void timeMe(String text, PrettyPrinter printer){

        // Setup the output to add to the pretty printer
        ArrayList results = new ArrayList();
        results.add(text);
        results.add(mainList.getSize());
        results.add(mainList.getRange());

        // Merge Sort
        int[] listM = mainList.getList();
        Long startM = getUserTime();
        MergeSort.mergeSort(listM);
        Long endM = getUserTime();
        results.add( getDiff(startM, endM));

        // Bucket Sort
        int[] listB = mainList.getList();
       // int max  = BucketSort.maxValue(listB);
        Long startB = getUserTime();
        BucketSort.sort(listB, 5);
        Long endB = getUserTime();
        results.add( getDiff(startB, endB));

        // QuickSort
        int[] listQ = mainList.getList();
        Long startQ = getUserTime();
        // QuickSort is having issues
        QuickSort.quickSort(listQ, 0, listQ.length-1);
        Long endQ = getUserTime();
        results.add( getDiff(startQ, endQ));

        //Heap Sort
        int[] listH = mainList.getList();
        Long startH = getUserTime();
        HeapSort.sort(listH);
        Long endH = getUserTime();
        results.add( getDiff(startH, endH));

        // Java Array Sort
        int[] listJ = mainList.getList();
        Long startJ = getUserTime();
        Arrays.sort(listJ);
        Long endJ = getUserTime();
        results.add( getDiff(startJ, endJ));


        printer.addRow(results);
    }


}
