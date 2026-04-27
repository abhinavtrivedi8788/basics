package com.engineering.strings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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

    private static String isAnagramHashing(String str1, String str2) {
        if(str1.length() != str2.length()) return "Not Anagram";
        Map<Character, Integer> charCounterMap = new HashMap<>();
        for(int i = 0; i < str1.length(); i++) {
            if(!charCounterMap.containsKey(str1.charAt(i))) {
                charCounterMap.put(str1.charAt(i), 1);
            }else{
                charCounterMap.put(str1.charAt(i), charCounterMap.get(str1.charAt(i)) + 1);
            }
        }

        for(char ch :str2.toCharArray()) {
            if(!charCounterMap.containsKey(ch)) {
                return "Not Anagram";
            }else{
                charCounterMap.put(ch, charCounterMap.get(ch) -1);
                if(charCounterMap.get(ch) == 0) {
                    charCounterMap.remove(ch);
                }
            }
        }
        return charCounterMap.isEmpty() ? "YES it is Anagram" : "NO it is not Anagram";
    }

    static void main() {
        String str1 = "listen";
        String str2 = "silent";
        String str3 = "SHIV";
        String str4 = "HARI";
        System.out.println("Is Anagram : " + isAnagramBruteForce(str1, str2));
        System.out.println("Is Anagram : " + isAnagramHashing(str3, str4));
    }
}
