package Sorting;


/**
 * Main Class to run the sorting algorithms
 * Need to run with '-Xint'  to make sure we don't use optimizations
 */
public class Runner {
    PrettyPrinter printer = new PrettyPrinter();


    /**
     * Main method that allows us to run multiple tests in a single execution
     * The sizes[] and ranges[] arrays must have the same number of elements
     */
    public  void run(){
        int[] sizes = {1000000, 1000000,5000000, 5000000, 10000000, 10000000};
        int[] ranges = {2, 1000000, 2, 5000000, 2, 10000000};

        if(sizes.length != ranges.length){
            System.err.println("Sizes and Ranges must contain the same number of elements");
            System.exit(1);
        }
        for(int i = 0; i < sizes.length; i++){
            runTests(sizes[i], ranges[i]);
        }

        // Print out the results
       // System.out.println(printer.toString());
        System.out.println("Completed Sorting Tests");
    }

    /**
     * Runs all of the test for the given size and range
     */
    private void runTests(int size, int range){
        ListBuilder mainList1 = new ListBuilder(size, range);
        ListBuilder mainList2 = new ListBuilder(size, range);
        ListBuilder mainList3 = new ListBuilder(size, range);

        new Timer(mainList1).timeMe( "Random Run 1", printer);
        new Timer(mainList1).timeMe( "Random Run 2", printer);
        new Timer(mainList1).timeMe( "Random Run 3", printer);

        mainList1.randomizePercentage(10);
        mainList2.randomizePercentage(10);
        mainList3.randomizePercentage(10);
        new Timer(mainList1).timeMe( "10% Random 1", printer);
        new Timer(mainList1).timeMe( "10% Random 2", printer);
        new Timer(mainList1).timeMe( "10% Random 3", printer);

        mainList1.randomizePercentage(50);
        mainList2.randomizePercentage(50);
        mainList3.randomizePercentage(50);
        new Timer(mainList1).timeMe( "50% Random 1", printer);
        new Timer(mainList1).timeMe( "50% Random 2", printer);
        new Timer(mainList1).timeMe( "50% Random 3", printer);

        mainList1.sortList();
        mainList2.sortList();
        mainList3.sortList();
        new Timer(mainList1).timeMe( "Sorted 1    ", printer);
        new Timer(mainList1).timeMe( "Sorted 2    ", printer);
        new Timer(mainList1).timeMe( "Sorted 3    ", printer);

        mainList1.reverse();
        mainList2.reverse();
        mainList3.reverse();
        new Timer(mainList1).timeMe( "Reversed 1  ", printer);
        new Timer(mainList1).timeMe( "Reversed 2  ", printer);
        new Timer(mainList1).timeMe( "Reversed 3  ", printer);
    }

    public static void main(String[] args) {
        Runner sortAll = new Runner();
        sortAll.run();

    }
}

