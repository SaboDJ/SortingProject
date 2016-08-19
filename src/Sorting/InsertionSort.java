package Sorting;

/**
 * @author: Jenny Zhen
 * @name: InsertionSort.java
 * @date: 03.15.12
 */

import java.util.ArrayList; //import Java's ArrayList class

public class InsertionSort {
    private static ArrayList<Integer> integers_list; //list of integers to sort

    /**
     *  Sort the array list integers_list.
     *  @param integers_list The array list to convert.
     */
    public static void sort(ArrayList<Integer> integers_list) {
        int key = 0; //value to compare
        int j = 0; //index of other value

        //loop through list
        for(int i = 0; i < integers_list.size(); i++){
            key = integers_list.get(i); //get value at index
            j = i - 1; //get index to previous value
            //compare value at the jth index to key
            while(j >= 0 && integers_list.get(j) > key){
                integers_list.set(j+1, integers_list.get(j));
                j--; //move to previous index
            }
            integers_list.set(j+1, key); //set with new value
        }
    }

    /**
     * Convert the array list a into a string that represents the arraylist.
     * @param integers_list The array list to convert.
     * @return A String representing integers_list.
     */
    public static String StringFromArrayList(ArrayList<Integer> integers_list) {
        return integers_list.toString(); //convert to string
    }
}
