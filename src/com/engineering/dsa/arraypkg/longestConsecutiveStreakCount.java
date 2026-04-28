package com.engineering.dsa.arraypkg;

import java.util.HashSet;
import java.util.Set;

public class longestConsecutiveStreakCount {


    private static int findLongestConsecutiveStreakCount(int[] array) {
        Set<Integer> numSet = new HashSet<>();
        for (int num : array) {
            numSet.add(num);
        }

        int longestStreak = 0;
        for (int num : numSet) {
            // Only start counting from the beginning of a sequence
            if (!numSet.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                while (numSet.contains(currentNum + 1)) {
                    currentNum++;
                    currentStreak++;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }

    static void main() {
        int [] array = new int[] {0,3,7,2,5,8,4,6,0,1,10};
        int longestConsecutiveStreakCount = findLongestConsecutiveStreakCount(array);
        System.out.println("Longest Consecutive Streak Count : "+longestConsecutiveStreakCount);
    }
}
