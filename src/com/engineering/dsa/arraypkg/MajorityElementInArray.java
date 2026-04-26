package com.engineering.dsa.arraypkg;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//Given an array nums of size n, return the majority element.
//The majority element is the element that appears more than ⌊n / 2⌋ times.
//You may assume that the majority element always exists in the array.
public class MajorityElementInArray {

    // This is the most basic approach to solve this problem using HashMap
    // Time Complexity : O(n) and Space Complexity : O(n)
    private static int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int threshold = nums.length/2;
        for(int number : nums){
            if(map.containsKey(number)){
                map.put(number, map.get(number)+1);
            }else{
                map.put(number, 1);
            }
        }
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(entry.getValue() > threshold){
                return entry.getKey();
            }
        }
        return 0;
    }

    // Time Complexity  - O(n log n). Dominated by the sorting step. The index lookup is O(1).
    // Space Complexity - O(1) to O(n). Depends on the sorting algorithm.In-place sorts like heapsort use O(1) extra space.
    // Other sorts like mergesort use O(n) space.
    private static int majorityUsingSort(int [] nums){
        Arrays.sort(nums);
        return nums[nums.length/2];
    }

    // Boyer-Moore Voting Algorithm
    // Time Complexity: O(n). A single pass through the array with O(1) work per element.
    // Space Complexity: O(1). Just two variables: candidate and count. No extra data structures at all.
    public static int majorityUsingVotingAlgorithm(int [] nums){
        int candidate=0;
        int counter = 0;
        for(int num : nums){
            if(counter == 0){
                candidate=num;
                counter++;
            }else if(num==candidate){
                counter++;
            }else{
                counter--;
            }
        }
        return candidate;
    }


    static void main() {
        int[] numbers = {2,2,1,1,1,2,2};
        System.out.println(majorityElement(numbers));
        System.out.println(majorityUsingSort(numbers));
        System.out.println(majorityUsingVotingAlgorithm(numbers));
    }
}
