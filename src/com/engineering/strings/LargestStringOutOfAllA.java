package com.engineering.strings;

public class LargestStringOutOfAllA {
    public static String largestString(int n) {
        StringBuilder sb = new StringBuilder();
        int bit = 0;
        while (n > 0) {
            if ((n & 1) == 1) {
                sb.append((char) ('a' + bit));
            }
            bit++;
            n >>= 1;
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {

        System.out.println(largestString(11)); // dba
        System.out.println(largestString(7));  // cba
        System.out.println(largestString(13)); // dca
        System.out.println(largestString(16)); // e
        System.out.println(largestString(67108876));
    }
}