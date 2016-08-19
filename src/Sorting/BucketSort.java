package Sorting;

import java.util.*;

//public class BucketSort{
//
//    public static void sort(int[] a, int maxVal) {
//        int [] bucket=new int[maxVal+1];
//
//        for (int i=0; i<bucket.length; i++) {
//            bucket[i]=0;
//        }
//
//        for (int i=0; i<a.length; i++) {
//            bucket[a[i]]++;
//        }
//
//        int outPos=0;
//        for (int i=0; i<bucket.length; i++) {
//            for (int j=0; j<bucket[i]; j++) {
//                a[outPos++]=i;
//            }
//        }
//    }
//
//    public static int maxValue(int[] list){
//        int max = 0;
//        for(int i = 0; i < list.length; i++){
//            if(list[i] > max){
//                max = list[i];
//            }
//        }
//        return max;
//    }
//
//
//    public static void main(String[] args) {
//        int maxVal=5;
//        int [] data= {5,3,0,2,4,1,0,5,2,3,1,4};
//
//        System.out.println("Before: " + Arrays.toString(data));
//        sort(data,maxVal);
//        System.out.println("After:  " + Arrays.toString(data));
//    }
//}

public class BucketSort{

//    public static void sort(int[] a, int maxVal) {
//        int[] bucket = new int[maxVal + 1];
//        for (int i = 0; i < bucket.length; i++) {
//            bucket[i] = 0;
//        }
//        for (int i = 0; i < a.length; i++) {
//            bucket[a[i]]++;
//        }
//        int outPos = 0;
//        for (int i = 0; i < bucket.length; i++) {
//            for (int j = 0; j < bucket[i]; j++) {
//                a[outPos++] = i;
//            }
//        }
//    }

//    public static int maxValue(int[] list){
//        int max = 0;
//        for(int i = 0; i < list.length; i++){
//            if(list[i] > max){
//                max = list[i];
//            }
//        }
//        return max;
//    }

    public static void sort(int[] list, int bucketSize) {
        if (list.length == 0) {
            return;
        }

        // Determine minimum and maximum values
        Integer minValue = list[0];
        Integer maxValue = list[0];
        for (int i = 1; i < list.length; i++) {
            if (list[i] < minValue) {
                minValue = list[i];
            } else if (list[i] > maxValue) {
                maxValue = list[i];
            }
        }

        // Initialize buckets
        int bucketCount =(maxValue - minValue) / bucketSize;
        bucketCount++;
        List<ArrayList<Integer>> buckets = new ArrayList<ArrayList<Integer>>(bucketCount);
        for (int i = 0; i < bucketCount; i++) {
            buckets.add(new ArrayList<Integer>());
        }

        // Distribute input array values into buckets
        for (int i = 0; i < list.length; i++) {
            buckets.get((list[i] - minValue)/bucketSize).add(list[i]);
        }

        // Sort buckets and place back into input array
        int currentIndex = 0;
        for (int i = 0; i < buckets.size(); i++) {
            //ArrayList<Integer> bucketArray = new ArrayList<Integer>();
           // bucketArray = (ArrayList<Integer>) buckets.set(i, bucketArray);
            InsertionSort.sort(buckets.get(i));
            for (int j = 0; j < buckets.get(i).size(); j++) {
                list[currentIndex++] = buckets.get(i).get(j);
            }
        }

    }
}




