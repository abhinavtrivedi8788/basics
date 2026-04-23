package com.engineering.dsa.arraypkg;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class RemoveDuplicateFromSortedArray {

    static int[] sortedArray = new int[]{2, 3, 3, 4, 5, 5, 6, 6, 9, 9, 10, 77, 91, 99, 100};

    static int [] newNonDuplicateSortedArray;

    public static int[] removeDuplicates(int[] array) {
        int i =0;
        for(int j =1;j<array.length;j++){
            if(array[i] != array[j]){
                array[i+1] = array[j];
                i++;
            }
        }
        newNonDuplicateSortedArray = new int[i+1];
        // this is to make array of non-duplicate elements only because the original array
        // will have duplicate elements at the end after removing duplicates
        return array;
    }

    public static int[] removeDuplicateUsingBruteForce(int[] array) {
        Set<Integer> set = new LinkedHashSet<>();
        for (int i : array) {
            set.add(i);
        }
       return set.stream().mapToInt(Integer::intValue).toArray();
    }



    static void main() {
        int [] array = removeDuplicates(sortedArray);
        for(int j =0;j<newNonDuplicateSortedArray.length;j++){
            System.out.println("REMOVED Duplicate from sorted array: " + array[j]);
        }

        System.out.println("------------------");

        for(int j =0;j<removeDuplicateUsingBruteForce(sortedArray).length;j++){
            System.out.println("REMOVED USING BRUTE FORCE :"+ removeDuplicateUsingBruteForce(sortedArray)[j]);
        }
    }
}
