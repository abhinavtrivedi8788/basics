package com.engineering.strings;

import java.util.PriorityQueue;

public class DiverseStringWithNoThreeConsecutiveChar {

    public static String smallestDiverseString(int a, int b, int c) {
        int[] cnt = {a, b, c};
        char[] chars = {'a', 'b', 'c'};
        StringBuilder sb = new StringBuilder();
        int total = a + b + c;
        while (sb.length() < total) {
            boolean placed = false;
            for (int i = 0; i < 3; i++) {
                if (cnt[i] == 0)
                    continue;
                int len = sb.length();

                // Would create 3 consecutive same letters?
                if (len >= 2 &&
                        sb.charAt(len - 1) == chars[i] &&
                        sb.charAt(len - 2) == chars[i]) {
                    continue;
                }
                cnt[i]--;

                if (isPossible(cnt)) {
                    sb.append(chars[i]);
                    placed = true;
                    break;
                }

                cnt[i]++;
            }

            if (!placed)
                return ""; // no valid arrangement exists
        }

        return sb.toString();
    }

    private static boolean isPossible(int[] cnt) {
        int total = cnt[0] + cnt[1] + cnt[2];
        int max = Math.max(cnt[0],Math.max(cnt[1], cnt[2]));
        int others = total - max;
        return max <= 2 * (others + 1);
    }

    public static void main(String[] args) {

        System.out.println(
                smallestDiverseString(3, 2, 1));

        System.out.println(
                smallestDiverseString(4, 1, 1));
        System.out.println(
                smallestDiverseString(1, 4, 4));

        System.out.println(
                smallestDiverseString(2, 2, 2));
    }
}