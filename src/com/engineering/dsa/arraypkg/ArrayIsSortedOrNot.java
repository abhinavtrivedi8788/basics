package com.engineering.dsa.arraypkg;

public class ArrayIsSortedOrNot {
    static int[] notSorted = new int[]{4, 3, 8, 1, 1, 2, 44, 99, 2, 7, 7, 6};
    static int[] sorted = new int[]{2, 3, 5, 5, 6, 6, 10, 77, 91, 99, 100};

    public static boolean isSorted(int[] array) {
        for (int i = 1; i < array.length; i++) {
            if (array[i] >= array[i - 1]) {

            } else {
                return false;
            }
        }
        return true;
    }

    static void main() {
        System.out.println("Is the array sorted : " + isSorted(notSorted));
        System.out.println("Is the array sorted : " + isSorted(sorted));
    }
}
