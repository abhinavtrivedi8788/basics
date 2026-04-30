package com.engineering.dsa.arraypkg;

public class MaximumSumOfSubArray {


    private static int findMaximumSumOfSubArray(int[] array) {
        int currentSum = array[0];
        int maxSum = array[0];
        for(int i = 1; i < array.length; i++){
            currentSum  = Math.max(array[i], currentSum + array[i]);
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }

    static void main() {
        int [] array = new int[] {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println("Maximum Sum Of Sub Array : "+ findMaximumSumOfSubArray(array));
    }


}
