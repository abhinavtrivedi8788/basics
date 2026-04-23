package com.engineering.dsa.arraypkg;

import java.util.HashMap;
import java.util.Map;

public class TwoSumTarget {


   //Brute-Force
    private static int [] findSumToJustifyTarget(int[] array, int target) {
        for(int i = 0; i < array.length; i++){
            for(int j = i+1; j < array.length; j++){
                if(array[i] + array[j] == target){
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{};
    }

    // Optimal - Solution
    private static int [] findSumToJustifyTargetUsingMap(int[] array, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < array.length; i++){
            int remainder = target - array[i];
            if(map.containsKey(remainder)){
                return new int [] {map.get(remainder), i};
            }
            map.put(array[i], i);
        }
        return new int [] {};
    }


    static void main() {
        int [] array = new int[] {2,4,6,6,7,1,8};
        int target = 13;
        for (int index : findSumToJustifyTarget(array, target)) {
            System.out.println(index);
        }

        for (int index : findSumToJustifyTargetUsingMap(array, target)) {
            System.out.println(index);
        }
    }
}
