package Sorting;

import java.util.ArrayList;
import java.util.List;

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
        Timer.timeMe(mainList, "Run 1", printer, range);
        Timer.timeMe(mainList, "Run 2", printer, range);
        Timer.timeMe(mainList, "Run 3", printer, range);

        mainList.sortList();

     //   this.mainList.randomizePercentage(10);
        Timer.timeMe(mainList, "Sorted 1", printer, range);
        Timer.timeMe(mainList, "Sorted 2", printer, range);
        Timer.timeMe(mainList, "Sorted 3", printer, range);
        System.out.println(printer.toString());
    }

    public static void main(String[] args) {
        Runner sortAll = new Runner();
        sortAll.run();

    }
}

