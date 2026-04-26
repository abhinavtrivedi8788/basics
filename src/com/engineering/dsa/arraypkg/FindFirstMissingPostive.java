package com.engineering.dsa.arraypkg;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FindFirstMissingPostive {

    private static int findFirstMissingPositiveNumber_BruteForce(int[] array) {
       Set<Integer> set = new HashSet<>();
        for(int i = 0; i < array.length; i++){
            set.add(array[i]);
        }
        System.out.println("Set : "+set.stream().map(String::valueOf).toList());
        for(int i = 1; i < array.length; i++){
            if(!set.contains(i)){
                return i;
            }
        }
        return -1;
    }


    private static int findFirstMissingPositiveNumber_UsingSorting(int[] array) {
        Arrays.sort(array);
        int expected=1;
        System.out.println("Sorted Array : "+Arrays.stream(array).boxed().toList());
        for(int i = 0; i < array.length; i++){
            if(array[i] <=0 || ( i > 0 && array[i] == array[i-1])){
                continue;
            }
            if(array[i] == expected){
                expected++;
            }else {
                break;
            }
        }
        return expected;
    }

    static void main() {
        int[] array1 = {3,4,-1,1};
        int[] array2 = {7,8,9,11,12,1,2};
        System.out.println("First Missing Positive Number is : "+findFirstMissingPositiveNumber_BruteForce(array1));
        System.out.println("First Missing Positive Number is : "+findFirstMissingPositiveNumber_BruteForce(array2));
        System.out.println("First Missing Positive Number is : "+findFirstMissingPositiveNumber_UsingSorting(array2));
    }

}
