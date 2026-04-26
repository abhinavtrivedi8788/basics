package com.engineering.dsa.arraypkg;

public class ArrayElementMultiplication {

    private static int findIfMultiplicationOfElementsIsPositiveNegativeOrZero(int[] array) {
        int counter =0;
        for(int number : array){
            if(number == 0) return 0;
            if(number < 0) {
                counter++;
            }
        }
        if(counter % 2 == 0){
            return 1;
        }else {
            return -1;
        }
    }



    static void main() {
        int [] array1 = {25,-5,-6,-2,5};
        int [] array2 = {25,5,-6,-2,5};
        int [] array3 = {25,5,6,-2,0};
        System.out.println("Product of all elements in array 1 is : "+findIfMultiplicationOfElementsIsPositiveNegativeOrZero(array1));
        System.out.println("Product of all elements in array 2 is :  "+findIfMultiplicationOfElementsIsPositiveNegativeOrZero(array2));
        System.out.println("Product of all elements in array 3 is :  "+findIfMultiplicationOfElementsIsPositiveNegativeOrZero(array3));
    }

}
