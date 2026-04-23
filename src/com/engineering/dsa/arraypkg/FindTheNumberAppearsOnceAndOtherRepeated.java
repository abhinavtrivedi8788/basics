package com.engineering.dsa.arraypkg;

import java.util.HashMap;
import java.util.Map;

public class FindTheNumberAppearsOnceAndOtherRepeated {

    private static int findTheNumberAppearsOnceAndOtherRepeatedBruteForce(int[] array) {
        for(int i = 0; i < array.length; i++){
            int counter = 0;
            int number = array[i];
            for(int j = i + 1; j < array.length; j++){
                if(array[j] == number){
                    counter++;
                    break;
                }
            }
            if(counter == 0) {
                return number;
            }
        }
        return -1;
    }

    private static int findTheNumberAppearsOnceAndOtherRepeatedHashing(int[] array) {
       Map<Integer, Integer> map = new HashMap<>();
        for(int i : array){ //map.put(i, map.getOrDefault(i, 0) + 1);
            Integer count = map.get(i);
            if (count == null) {
                map.put(i, 1);
            } else {
                map.put(i, count + 1);
            }
        }
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(entry.getValue() == 1){
                return (entry.getKey());
            }
        }
        return -1;
    }

    private static int findTheNumberAppearsOnceAndOtherRepeatedOptimal(int[] array) {
         int result = 0;
         for(int i : array){
             result ^= i;
         }
         return result;
     }

    static void main() {
        int [] array = new int[] {1,2,3,4,5,6,7,8,9,1,2,3,4,5,6,7,8};

        System.out.println("Number Appears Once Using Brute Force : "+findTheNumberAppearsOnceAndOtherRepeatedBruteForce(array));
        System.out.println("Number Appears Once Using Better Solution : "+findTheNumberAppearsOnceAndOtherRepeatedHashing(array));

        int numberAppearsOnce = findTheNumberAppearsOnceAndOtherRepeatedOptimal(array);
        System.out.println("Number Appears Once : "+numberAppearsOnce);
    }
}
