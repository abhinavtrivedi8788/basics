package com.engineering.dsa.arraypkg;

public class MaxConsecutiveOnes {

    private static int findMaxConsecutiveOnes(int[] array) {
        int maxCount = 0;
        int count = 0;
        for(int i : array){
            if(i == 1){
                count++;
            }else{
                maxCount = Math.max(maxCount, count);
                count = 0;
            }
        }
        return Math.max(maxCount, count);
    }


    static void main() {
        int [] array = new int[] {1,1,1,0,1,1,1,1,0,0,1,1,1,1,1,1};
        int maxConsecutiveOnes = findMaxConsecutiveOnes(array);
        System.out.println("Max Consecutive Ones : "+maxConsecutiveOnes);
    }


}
