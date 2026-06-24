package com.engineering.dsa.pattern;

public class TriangleStar {

    /**
     *
     * *
     * **
     * ***
     * ****
     * *****
     */
    private static void printRightAngleTriangleStar(int number){
        for(int i=0;i<number;i++){
            for(int j=0;j<i+1;j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    private static void printRightAngleTriangleNumbers(int number){
        for(int i=0;i<number;i++){
            for(int j=0;j<i+1;j++){
                System.out.print(i+1 + " ");
            }
            System.out.println();
        }
    }

    private static void printRightAngleTriangleChar(int number){
        char ch = 'A';
        for(int i=0;i<number;i++){
            for(int j=0;j<i+1;j++){
                System.out.print(ch + " ");
            }
            ch++;
            System.out.println();
        }
    }

    private static void printRightAngleTriangleNumberIncrementingInLine(int number){
        for(int i=0;i<number;i++){
            for(int j=1;j<i+1;j++){
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    private static void printRightAngleTriangleNumberIncrementingInLineReverse(int number){
        for(int i=0;i<number;i++){
            for(int j=i+1;j>0;j--){
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    private static void floydsTrianglePattern(int number){
        System.out.println("Floyds Triangle Pattern");
        int value=1;
        for(int i=0;i<number;i++){
            for(int j=0;j<i+1;j++){
                System.out.print(value+ " ");
                value++;
            }
            System.out.println();
        }
    }

    private static void floydsTrianglePatternForChar(int number){
        System.out.println("Floyds Triangle Pattern for Character");
        char value='A';
        for(int i=0;i<number;i++){
            for(int j=0;j<i+1;j++){
                System.out.print(value+ " ");
                value++;
            }
            System.out.println();
        }
    }

    private static void invertedPyramid(int number){
        System.out.println("Inverted Pyramid Pattern");
        for(int i=0;i<number;i++){
            for(int j=0;j<i;j++){
                System.out.print(" ");
            }

            for(int j=number-i;j>0;j--){
                System.out.print(i+1 +" ");
            }
            System.out.println();
        }

    }

    private static void invertedTriangleNumber(int number){
        System.out.println("Inverted Triangle Pattern Numbers ");
        for(int i=0;i<number;i++){
            //spaces
            for(int j=0;j<i;j++){
                System.out.print(" ");
            }

            // numbers
            for(int j=0;j<number-i;j++){
                System.out.print(i+1);
            }
            System.out.println();
        }

    }

    private static void invertedTriangleChar(int number) {
        System.out.println("Inverted Triangle Pattern char ");
        Character value='A';
        for (int i = 0; i < number; i++) {
            //spaces
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }

            // characters
            for (int j = 0; j < number - i; j++) {
                System.out.print(value );

            }
            value++;
            System.out.println();
        }

    }

    private static void pyramid(int number){
        System.out.println("Pyramid Triangle Pattern");

        for(int i=0;i<number;i++){

            //spaces
            for(int j=0;j<number-i-1;j++){
                System.out.print(" ");
            }

            // number 1
            for(int j=1;j<=i+1;j++){
                System.out.print(j);
            }
            //number 2
            for(int j=i ; j>0; j--){
                System.out.print(j);
            }
            System.out.println();
        }
    }

    private static void pyramidStar(int number){
        System.out.println("Pyramid Star Pattern");

        for(int i=0;i<number;i++){

            //spaces
            for(int j=0;j<number-i-1;j++){
                System.out.print(" ");
            }

            // stars
            for(int j=0;j<2*i+1;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    private static void hollowDiamond(int number){
        System.out.println("Hollow Diamond  Pattern");

    }



    static void main() {
        printRightAngleTriangleStar(5);
        printRightAngleTriangleNumbers(5);
        printRightAngleTriangleChar(5);
        printRightAngleTriangleNumberIncrementingInLine(5);
        printRightAngleTriangleNumberIncrementingInLineReverse(5);
        floydsTrianglePattern(5);
        floydsTrianglePatternForChar(5);
        invertedPyramid(5);
        invertedTriangleNumber(5);
        invertedTriangleChar(5);
        pyramid(5);
        pyramidStar(5);
    }
}
