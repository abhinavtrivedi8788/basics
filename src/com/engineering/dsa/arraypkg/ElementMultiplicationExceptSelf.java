package com.engineering.dsa.arraypkg;

import java.util.Arrays;

public class ElementMultiplicationExceptSelf {

    private static int [] multiplicationofElements_BruteForce(int[] numbers) {
        int size = numbers.length;
        int [] result = new int[size];
        for(int i = 0; i < size; i++) {
            int product = 1;
            for(int j = 0; j < size; j++) {
                if(i!=j) {
                    product *= numbers[j];
                }
            }
            result[i] = product;
        }
        return result;
    }



    static void main() {
        int[] numbers ={1,2,3,4,5};
        System.out.println("Element Multiplication Except Self : "+ Arrays.stream(multiplicationofElements_BruteForce(numbers)).boxed().toList());
    }

}
