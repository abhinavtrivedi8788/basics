package com.engineering.dsa.arraypkg;

public class FindMissingNumber {

    private static int findMissingNumberUsingBruteForce(int[] array) {
        if(array.length == 0) return 0;
        for(int i = 1; i < array.length; i++){
            boolean missing = false;
            for(int j = 0; j < array.length; j++){
                if(array[j] == i) {
                    missing = true;
                    break;
                }
            }
            if(!missing){
                return i;
            }
        }
        return -1;
    }

    // TC - O(n) , SP - O(1)
    private static int findMissingNumberUsingOptimalSolution(int[] array) {
        if(array.length == 0) return 0;
        int n = array.length + 1;
        int sumOfN = (n * (n + 1)) / 2;
        int sumOfArray = 0;
        for(int i : array){
            sumOfArray += i;
        }
        return sumOfN - sumOfArray;
    }

    // TC - O(n) , SP - O(1)
    private static int findMissingNumberUsingXOR(int[] array) {
        int xor = 0;
        for (int i = 1; i <= array.length + 1; i++) {
            xor ^= i;
        }
        for (int num : array) {
            xor ^= num;
        }
        return xor;
    }

    static void main() {
        int [] array = new int[] {1,2,3,4,6,7}; // 8,2,4,5,3,7,1
        int missingNumberUsingBruteForce = findMissingNumberUsingBruteForce(array);
        System.out.println("Missing Number Using Brute Force : "+missingNumberUsingBruteForce);

        int missingNumberUsingOptimalSolution = findMissingNumberUsingOptimalSolution(array);
        System.out.println("Missing Number Using Optimal Solution : "+ missingNumberUsingOptimalSolution);

        int missingNumberUsingXOR = findMissingNumberUsingXOR(array);
        System.out.println("Missing Number Using XOR : "+ missingNumberUsingXOR);
    }




}
