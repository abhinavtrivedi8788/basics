package com.engineering.dsa.arraypkg;

import java.time.Duration;

public class LongestSubArrayWithSumK {

    private static int longestSubArrayWithSumK_BruteForce(int[] arr, int k) {
        if (arr == null || arr.length == 0) return 0;
        int maxLength = 0;
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];
                if (sum == k) {
                    return Math.max(maxLength, j - i + 1); // current length of sub array is j - i + 1
                }
            }
        }
        return maxLength;
    }

    // Using Two Pointer approach - my approach
    private static int longestSubArrayWithSumK_Optimal(int[] arr, int k) {
        if (arr == null || arr.length == 0) return 0;
        int maxLength=0;
        int sum =0;
        int leftPointer=0;
        int rightPointer=0;

        while(rightPointer<arr.length){
            sum+=arr[rightPointer];
            while(sum > k){
                sum -= arr[leftPointer];
                leftPointer++;
            }
            if(sum == k){
                maxLength = Math.max(maxLength, rightPointer-leftPointer+1);
            }
            rightPointer++;
        }
        return maxLength;
    }


    private static int byStriver(int[] arr, int k) {
        if (arr == null || arr.length == 0) return 0;
        int leftPointer=0;
        int rightPointer=0;
        int maxLength=0;
        int sum =arr[0];
        while(rightPointer<arr.length){
            while(leftPointer <= rightPointer && sum > k){
                sum -= arr[leftPointer];
                leftPointer++;
            }
            if(sum == k){
                maxLength = Math.max(maxLength, rightPointer-leftPointer+1);
            }
            rightPointer++;
            if(rightPointer < arr.length){
                sum += arr[rightPointer];
            }
        }
        return maxLength;
    }


    static void main() {
        int[] arr = {1, 2, 3, 7, 5, 6, 9};
        int k = 13;
        System.out.println("Longest Sub Array with sum K - BRUTE FORCE : " + longestSubArrayWithSumK_BruteForce(arr, k));
        System.out.println("Longest Sub Array with sum K - OPTIMAL : " + longestSubArrayWithSumK_Optimal(arr, k));
        System.out.println("Longest Sub Array with sum K - DUMMY : " + byStriver(arr, k));


    }




}
