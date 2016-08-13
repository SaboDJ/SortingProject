package Sorting;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Manages the list to sort.
 */
public class ListBuilder {
    ArrayList<Integer> list;
    int size;
    int range;
    boolean sorted;
    double randPerc;

    /**
     * Constructor
     * @param size - the total size of the list
     * @param range - the range of values inside the list [0 - range]
     */
    public ListBuilder(int size, int range){
        this.size = size;
        this.range = range;
        this.sorted = false;
        this.randPerc = 0;

        list = new ArrayList();
        buildList();

    }

    /**
     * Builds a new list of random values
     */
    private void buildList(){
        Random rand = new Random();
        for(int i = 0; i < size; i++){
            list.add(rand.nextInt(range));
        }
    }

    /**
     * Randomizes a certain percentage of the array
     * @param percent the amount to randomize
     */
    public void randomizePercentage(double percent){
        // if its already randomized correctly exit
        if (randPerc == percent){
            return;
        }
        randPerc = percent;

        // Make sure the list is sorted first
        if(!sorted) {
            Collections.sort(list);
        }
        else {
            sorted = false;
        }

        Random rand = new Random();
        percent = percent * .01;

        // Replace a certain percentage of the list with new random values
        for(int i = 0; i < percent * size; i++){
            // the element we are replacing
            int elem = rand.nextInt(size);
            // remove the element at that position
            list.remove(elem);
            // Replace an element in the list with a random one
            list.add(elem, rand.nextInt(range));

        }
    }

    /**
     * Sorts the list
     */
    public void sortList(){
        // if its already sorted we return
        if(sorted){
            return;
        }
        sorted = true;
        Collections.sort(list);
    }

    /**
     * Returns a copy of the array
     */
    public ArrayList<Integer> getList(){
        ArrayList<Integer> newList = new ArrayList<>();
        newList.addAll(list);
        return newList;
    }


}
