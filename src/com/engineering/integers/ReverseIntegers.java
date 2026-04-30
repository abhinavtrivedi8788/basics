package com.engineering.integers;

public class ReverseIntegers {


    private static int reverseInteger(int number) {
        int reversedNumber = 0;
        while(number != 0){
            int lastDigit = number % 10;
            number = number / 10;
            if(reversedNumber > Integer.MAX_VALUE / 10 || reversedNumber < Integer.MIN_VALUE / 10) return 0;
            reversedNumber = reversedNumber * 10 + lastDigit;

        }
        return reversedNumber;
    }

    static void main() {
        int number = 12345;
        int reversedNumber = reverseInteger(number);
        System.out.println("Reversed Number : "+reversedNumber);

        //what if number is out of int scope like greater than -> 2147483647 & -2147483648 then we have to add condition to return '0'
        int dummyNumber = 2147483647; // java: integer number too large -2147483647
        int dummyReversedNumber = reverseInteger(dummyNumber);
        System.out.println("Reversed Number : "+dummyReversedNumber);

    }


}
