package Sorting;
import java.util.ArrayList;

/**
 * Prints the data in rows and columns
 */
public class PrettyPrinter {
    ArrayList<ArrayList> matrix = new ArrayList<>();


    /**
     * Constructor
     */
    PrettyPrinter(){
        this.matrix = new ArrayList<>();
        setup();
    }

    /**
     * Sets up the header row for printing
     */
    private void setup(){
        ArrayList tmp = new ArrayList();
        tmp.add("            ");
        tmp.add("Size");
        tmp.add("Range");
        for(Timer.Sorts sort: Timer.Sorts.values()){
            tmp.add(sort);
        }
        addRow(tmp);
    }

    public void addRow(ArrayList<Object> row){
        matrix.add(row);
        for(Object item : row){
            System.out.print(item + "\t");
        }
        System.out.print("\n");

    }

    /**
     * All of the tests should be run in sets of 3, this will print out the averages of the rows
     * May update this to take the median instead
     */
    public void printAverages(){
        ArrayList<ArrayList> avewrages = new ArrayList<>();

        // Add the title row
        avewrages.add(matrix.get(0));

        // need to start at row 1 and increment by 3'
        for(int i = 1; i < matrix.size(); i +=3){
            // the current row we are going to add
            ArrayList row = new ArrayList();
            // the tile of the sort test
            row.add(matrix.get(i).get(0));
            // get averages from the next three rows
            for(int j = 1; j < matrix.get(i).size(); j++){
                // The three rows we are averaging
                double a = (double) matrix.get(i).get(j);
                double b = (double) matrix.get(i+1).get(j);
                double c = (double) matrix.get(i+2).get(j);

                // Find the median
                double max = Math.max(a, b);
                max = Math.max(max, c);
                double min = Math.min(a, b);
                min = Math.min(min, c);
                double median = (a + b + c) - max - min;
                // add the median to the new row
                row.add( (median ));
            }
            // add the row
            avewrages.add(row);

        }
    }

    public String toString(){
        StringBuffer output = new StringBuffer();
        for(ArrayList row : matrix){
            for(Object item : row){
                output.append(item.toString() + "\t");
            }
            output.append("\n");
        }

        return output.toString();
    }
}
