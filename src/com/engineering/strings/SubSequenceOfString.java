package com.engineering.strings;

public class SubSequenceOfString {

    private static boolean isSubSequence(String str1, String str2) {
        int i =0;
        int j=0;
        while(i<str1.length() && j<str2.length()){
            if(str1.charAt(i)==str2.charAt(j)){
                i++;
            }
            j++;
        }
        return i==str1.length();
    }

    static void main() {
            String str1 = "abc";
            String str2 = "ahbgdc";
            System.out.println("Is SubSequence : " + isSubSequence(str1, str2));
    }


}
