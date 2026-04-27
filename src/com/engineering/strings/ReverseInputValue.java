package com.engineering.strings;

public class ReverseInputValue {

    private static String reverseInputvalue(String stringToBeReversed) {
        char [] arrayToBeReversed =stringToBeReversed.toCharArray();
        int left = 0 ;
        int right = arrayToBeReversed.length-1;
        while(left<right) {
            if(!Character.isAlphabetic(arrayToBeReversed[left])) {
                left++;
            }
            if(!Character.isAlphabetic(arrayToBeReversed[right])) {
                right--;
            }else {
                char capturedData= arrayToBeReversed[left];
                arrayToBeReversed[left]= arrayToBeReversed[right];
                arrayToBeReversed[right]= capturedData;
                left++;
                right--;
            }
        }
        return String.valueOf(arrayToBeReversed) ;
    }

    static void main(String[] args) {
        String input = "ABC@D#H*jk%k%fY";
        System.out.println(ReverseInputValue.reverseInputvalue(input));
    }
}
