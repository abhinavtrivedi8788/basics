package com.engineering.strings;

import java.util.Arrays;

public class Anagram {

    //Time Complexity: 𝑂( 𝑁 log 𝑁) due to sorting
    //Space Complexity: 𝑂( 𝑁) due to sorting
    private static String isAnagramBruteForce(String str1, String str2) {
        if(str1.length() != str2.length()) return "Not Anagram";
        char[] charArray = str1.toCharArray();
        char[] charArray2 = str2.toCharArray();
        Arrays.sort(charArray);
        Arrays.sort(charArray2);
        return Arrays.equals(charArray, charArray2) ? "YES it is Anagram" : "NO it is not Anagram";
    }


    static void main() {
        String str1 = "listen";
        String str2 = "silent";
        System.out.println("Is Anagram : " + isAnagramBruteForce(str1, str2));
    }
}
