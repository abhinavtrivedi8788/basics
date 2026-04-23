package com.engineering.dsa.arraypkg;

public class SecondLargestWithoutSorting {
    static int [] array = new int [] {0,1,4,6,9,22,8,44,99,2,7,7,6};
    static int [] dummy = new int [] {4,3,8,1,1,2,44,99,2,7,7,6}; //for my understanding of  edge cases

    public static int secondlargetsElement(int [] array) {
        int largest = array[0]; // took first element as largest and then compare with rest of the elements
        int secondLargest = Integer.MIN_VALUE; // took second largest as -1 because if there is no second largest element then it will return -1

        for(int i =1; i <array.length ; i++ ){
            if(array[i] > largest){
                secondLargest = largest;
                largest = array[i];
            }else if(array[i] < largest && array[i] >secondLargest){
                // important condition to check if the current element is less than largest and greater than second largest
                // then only update second largest as there could be  duplicate numbers .
                secondLargest = array[i];
            }
        }
        return secondLargest;
    }

    public static int secondSmallestElement(int [] array) {
        int smallest = array[0]; //1
        int secondSmallest = Integer.MAX_VALUE; //2

        for(int i =1;i<array.length ;i++ ){
            if(array[i] < smallest){
                secondSmallest = smallest;
                smallest = array[i];
            } else if (array[i] != smallest && array[i] < secondSmallest) {
                secondSmallest = array[i];
            }
        }
        return secondSmallest;
    }

    static void main() {
        System.out.println("Second Largest Element in array : "+secondlargetsElement(array));
        System.out.println("Second smallest  Element in array : "+secondSmallestElement(dummy));
    }


}
