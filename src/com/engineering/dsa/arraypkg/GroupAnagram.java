package com.engineering.dsa.arraypkg;

import java.util.*;


public class GroupAnagram {
    private static List<List<String>> groupAnagram(String[] strArray) {
        Map<String, List<String>> map = new HashMap<>();
        for(int i =0; i < strArray.length; i++) {
            char[] charArray = strArray[i].toCharArray();
            Arrays.sort(charArray);
            String key = new String(charArray);
            if(!map.containsKey(key)) {
                List<String> list = new ArrayList<>();
                list.add(strArray[i]);
                map.put(key, list);
            }else {
               map.get(key).add(strArray[i]);
            }
        }
        return new ArrayList<>(map.values());
    }

    private static List<List<String>> groupAnagramWhenInputIsList(List <String> strArray) {
        Map<String, List<String>> map = new HashMap<>();
        for(int i =0; i < strArray.size(); i++) {
            String word = strArray.get(i);
            char[] charArray = word.toCharArray();
            Arrays.sort(charArray);
            String key = new String(charArray);
            if(!map.containsKey(key)) {
                List<String> list = new ArrayList<>();
                list.add(word);
                map.put(key, list);
            }else {
                map.get(key).add(word);
            }
        }
        return new ArrayList<>(map.values());
    }



    static void main() {
        String[] strArray = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> lists = groupAnagram(strArray);
        System.out.println("Anagram are : " + lists);

        List<String> strList = Arrays.asList(strArray);
        System.out.println("Anagram are in list : " + groupAnagramWhenInputIsList(strList));

       }
}
