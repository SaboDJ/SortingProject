package Sorting;
import java.util.Arrays;
import java.util.Random;

/**
 * Manages the list to sort.
 */
public class ListBuilder {
    int[] list;
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

        list = new int[size];
        buildList();

    }

    /**
     * Builds a new list of random values
     */
    private void buildList(){
        Random rand = new Random();
        for(int i = 0; i < size; i++){
            list[i] = rand.nextInt(range);
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
        sortList();

        Random rand = new Random();
        percent = percent * .01;

        // Replace a certain percentage of the list with new random values
        for(int i = 0; i < percent * size; i++){
            list[rand.nextInt(size)] = rand.nextInt(range);
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
        Arrays.sort(list);
    }

    /**
     * Reverse sorts the list
     */
    public void reverse(){
        sortList();
        int[] newList = new int[size];
        for(int i = 0; i < size; i++){
            newList[i] = list[size - 1 - i];
        }
        list = newList;
    }

    /**
     * Returns a copy of the array
     */
    public int[] getList(){
        int[] newList = new int[size];
        for(int i = 0; i < size; i++){
            newList[i] = list[i];
        }
        return newList;
    }


    /**
     * Returns the size of the Array
     */
    public int getSize(){return size;}

    /**
     * Returns the range of values in the Array
     */
    public int getRange(){return range;}


}
