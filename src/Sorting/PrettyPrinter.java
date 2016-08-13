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
        tmp.add("");
        tmp.add("Size");
        tmp.add("Range");
        for(Timer.Sorts sort: Timer.Sorts.values()){
            tmp.add(sort);
        }
        addRow(tmp);
    }

    public void addRow(ArrayList<Object> row){
        matrix.add(row);
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
