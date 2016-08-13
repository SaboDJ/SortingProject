package Sorting;

import java.util.ArrayList;

/**
 * Created by Gaming on 8/12/2016.
 */
public class Runner {
    PrettyPrinter printer;
    ListBuilder mainList;
    int size = 1000000;
    int range = 1000000;

    public Runner(){
        this.mainList = new ListBuilder(size, range);
        this.printer = new PrettyPrinter();
    }

    public void run(){
        Timer.timeMe(mainList, "Completely Random", printer, range);
        this.mainList.randomizePercentage(10);
        Timer.timeMe(mainList, "10% Random", printer, range);
        System.out.println(printer.toString());
    }

    public static void main(String[] args) {
        Runner sortAll = new Runner();
        sortAll.run();

    }
}

