package Sorting;


/**
 * Created by Gaming on 8/12/2016.
 */
public class Runner {
    PrettyPrinter printer;
    ListBuilder mainList;
    int size = 10000000;
    int range = 10000000;

    public Runner(){
        this.mainList = new ListBuilder(size, range);
        this.printer = new PrettyPrinter();
    }

    public void run(){
        Timer.timeMe(mainList, "Run 1", printer);
        Timer.timeMe(mainList, "Run 2", printer);
        Timer.timeMe(mainList, "Run 3", printer);

        mainList.sortList();
        Timer.timeMe(mainList, "Sorted 1", printer);
        Timer.timeMe(mainList, "Sorted 2", printer);
        Timer.timeMe(mainList, "Sorted 3", printer);

        mainList.randomizePercentage(10);
        Timer.timeMe(mainList, "10% Random 1", printer);
        Timer.timeMe(mainList, "10% Random 1", printer);
        Timer.timeMe(mainList, "10% Random 1", printer);

        mainList.reverse();
        Timer.timeMe(mainList, "Reversed 1", printer);
        Timer.timeMe(mainList, "Reversed 2", printer);
        Timer.timeMe(mainList, "Reversed 3", printer);

        System.out.println(printer.toString());
    }

    public static void main(String[] args) {
        Runner sortAll = new Runner();
        sortAll.run();

    }
}

