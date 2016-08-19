package Sorting;


import java.util.ArrayList;

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
        class TestCase {
            public int size;
            public int range;
            TestCase(int size, int range){
                this.size = size;
                this.range = range;
            }
        }
        ArrayList<TestCase> tests = new ArrayList<TestCase>();
        // You can add tests cases here the first number is the array size
        // and the second is the number range
        tests.add(new TestCase(1000000, 1000000));
        tests.add(new TestCase(1000000, 5000000));
        tests.add(new TestCase(5000000, 1000000));
        tests.add(new TestCase(5000000, 5000000));
        tests.add(new TestCase(10000000, 10000000));

        // Runs all of the test cases
        for(TestCase aCase : tests){
            runTests(aCase.size, aCase.range);
        }

        System.out.println("Completed Sorting Tests, calculating medians");
        // Print out all of the medians
        printer.printMedians();
        System.out.println("****Program Completed****");

    }

    /**
     * Runs all of the test for the given size and range
     */
    private void runTests(int size, int range){
        ListBuilder mainList1 = new ListBuilder(size, range);
        ListBuilder mainList2 = new ListBuilder(size, range);
        ListBuilder mainList3 = new ListBuilder(size, range);

        new Timer(mainList1).timeMe( "Random Run  ", printer);
        new Timer(mainList1).timeMe( "Random Run 2", printer);
        new Timer(mainList1).timeMe( "Random Run 3", printer);

        mainList1.randomizePercentage(10);
        mainList2.randomizePercentage(10);
        mainList3.randomizePercentage(10);
        new Timer(mainList1).timeMe( "10% Random  ", printer);
        new Timer(mainList1).timeMe( "10% Random 2", printer);
        new Timer(mainList1).timeMe( "10% Random 3", printer);

        mainList1.randomizePercentage(50);
        mainList2.randomizePercentage(50);
        mainList3.randomizePercentage(50);
        new Timer(mainList1).timeMe( "50% Random  ", printer);
        new Timer(mainList1).timeMe( "50% Random 2", printer);
        new Timer(mainList1).timeMe( "50% Random 3", printer);

        mainList1.sortList();
        mainList2.sortList();
        mainList3.sortList();
        new Timer(mainList1).timeMe( "Sorted      ", printer);
        new Timer(mainList1).timeMe( "Sorted 2    ", printer);
        new Timer(mainList1).timeMe( "Sorted 3    ", printer);

        mainList1.reverse();
        mainList2.reverse();
        mainList3.reverse();
        new Timer(mainList1).timeMe( "Reversed    ", printer);
        new Timer(mainList1).timeMe( "Reversed 2  ", printer);
        new Timer(mainList1).timeMe( "Reversed 3  ", printer);

    }

    public static void main(String[] args) {
        Runner sortAll = new Runner();
        sortAll.run();

    }
}

