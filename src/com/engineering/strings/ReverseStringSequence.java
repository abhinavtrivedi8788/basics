package com.engineering.strings;

public class ReverseStringSequence {

    private static String reverseString(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        String[] strArray = str.split("\\s+"); // this is to split the string if it has any blank spaces in between the words

        for(int i =strArray.length-1;i>=0;i--) {
            stringBuilder.append(strArray[i]).append(" ");
        }

        return stringBuilder.toString();
    }

    static void main() {
        String str = "The Sky    is Blue";
        System.out.println("Reversed String is : "+reverseString(str));
    }
}
