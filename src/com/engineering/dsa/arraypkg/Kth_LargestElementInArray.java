package com.engineering.dsa.arraypkg;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class Kth_LargestElementInArray {


    // Brute Force - Time: O(n log n) , Space: depends on sort
    private static int kLargestElementInArray_Bruteforce(int[] array, int k) {
        Arrays.sort(array);
        return array[array.length - k];
    }


    // Build heap: O(n) ,Extract k: O(k log n) ,Total: O(n + k log n)
    private static int kLargestElementInArray_MAX_HEAP(int[] array, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder()); // reverse the PR
        for (int n : array) {
            maxHeap.add(n);
        }
        for (int i = 1; i < k; i++) { // strat from 1
            maxHeap.poll();
        }
        return maxHeap.peek();
    }

    // O(n log k), Keep only top k elements → discard useless data early
    private static int kLargestElementInArray_MIN_HEAP(int[] array, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int n : array) {
            minHeap.add(n);
            if (minHeap.size() > k) {
                System.out.println("POLL --- " +minHeap.poll());
            }
        }
        return minHeap.peek();
    }

    static void main() {
        int[] array = new int[]{0, 1, 4, 6, 9, 22, 8, 44, 99, 2, 7, 7, 6};
        System.out.println("Kth Largest Element in array - BRUTE FORCE : "+ kLargestElementInArray_Bruteforce(array, 4));
        System.out.println("Kth Largest Element in array - MAX HEAP    : "+ kLargestElementInArray_MAX_HEAP(array, 4));
        System.out.println("Kth Largest Element in array - MIN HEAP    : " + kLargestElementInArray_MIN_HEAP(array, 4));
    }

}
