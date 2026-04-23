package com.engineering.map;

import java.util.*;

class Marks {
    private String subject;
    private int mark;

    public Marks(String subject, int mark) {
        this.subject = subject;
        this.mark = mark;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    // Hashcode & Equals is not overidden because we are not using Marks object as key in map
    // but if we want to use it as key then we need to override hashcode and equals method.

    @Override
    public String toString() {
        return "Marks{" +
                "subject='" + subject + '\'' +
                ", mark=" + mark +
                '}';
    }
}

public class JavaMapRelatedOperations {

    private static void SortBycalueUsingStreams(Map<String, Marks> hashMap) {
        Map<String, Marks> sortedMap = hashMap.entrySet()
                .stream()
                .sorted(Comparator.comparingInt(e -> e.getValue().getMark()))
                .collect(
                        LinkedHashMap::new,
                        (map, entry) -> map.put(entry.getKey(), entry.getValue()),
                        LinkedHashMap::putAll
                );

        System.out.println("HashMap after sorting on basis of values using Streams : " + sortedMap);
    }

    private static void sortByValueLogic(Map<String, Marks> hashMap) {
        List<Map.Entry<String ,Marks>> marksList = new ArrayList<>(hashMap.entrySet());

        Collections.sort(marksList, new Comparator<Map.Entry<String, Marks>>() {
            @Override
            public int compare(Map.Entry<String, Marks> o1, Map.Entry<String, Marks> o2) {
                return Integer.compare(o1.getValue().getMark(), o2.getValue().getMark());
               // return o1.getValue().getSubject().compareTo(o2.getValue().getSubject());
            }
        });

        /* marksList.sort((o1, o2) -> Integer.compare(o1.getValue().getMark(), o2.getValue().getMark()));*/
        Map<String,Marks> linkedHashMap = new LinkedHashMap<>();
        for(Map.Entry<String, Marks> entry : marksList){
            linkedHashMap.put(entry.getKey(), entry.getValue());
        }

        System.out.println("HashMap after sorting on basis of values : " + linkedHashMap);

        for(Map.Entry<String, Marks> entry : linkedHashMap.entrySet()){
            System.out.println(entry.getKey() + " : " + entry.getValue().getMark());
        }
    }

    static void main() {
        Marks m1 = new Marks("Maths", 98);
        Marks m2 = new Marks("Physics", 95);
        Marks m3 = new Marks("Chemistry", 92);

        Map<String, Marks> hashMap = new HashMap<>();
        hashMap.put(m1.getSubject(), m1);
        hashMap.put(m2.getSubject(), m2);
        hashMap.put(m3.getSubject(), m3);

        // need to sort the map on basis of values.
        sortByValueLogic(hashMap);
        SortBycalueUsingStreams(hashMap);
    }
}
