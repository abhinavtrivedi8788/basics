package com.engineering.dsa.arraypkg;

import java.security.cert.CollectionCertStoreParameters;
import java.util.Arrays;
import java.util.stream.Collectors;

public class LargetsElement {

     static int [] array1 = new int [] {1,4,6,9,22,8,44,99,2,6};
     static int [] array2 = new int [] {1,4,6,9,22,8,44,6,2,99};

    static void main() {

       //brute force -

        array1= Arrays.stream(array1).sorted().toArray();
        System.out.println("Sorted Array : "+ Arrays.toString(array1));
        System.out.println("Largest Element in the Array 1 is : "+ array1[array1.length-1]);

        // Optimal - Solution

        int largets = array2[0];
        for(int i = 0; i< array2.length ; i++){
            if(array2[i]>largets){
                largets = array2[i];
            }
        }
        System.out.println("Largest Element in the Array 2 is : "+ largets);

    }
}
