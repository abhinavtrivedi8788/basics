package com.engineering.strings;

public class StringPermutation {
    /**
     * permutation function
     * @param str string to calculate permutation for
     * @param l starting index
     * @param r end index
     */
    private void permute(String str, int startingIndex , int endIndex)
    {
        if (startingIndex == endIndex)
            System.out.println(str);
        else {
            for (int i = startingIndex; i <= endIndex; i++) {
                str = swap(str, startingIndex, i);
                permute(str, startingIndex + 1, endIndex);
                str = swap(str, startingIndex, i);
            }
        }
    }

    /**
     * Swap Characters at position
     * @param a string value
     * @param i position 1
     * @param j position 2
     * @return swapped string
     */
    public String swap(String stringInput, int i, int j)
    {
        char temp;
        char[] charArray = stringInput.toCharArray();
        temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }

    static void main(String[] args)
    {
        String str = "ABC";
        int n = str.length();
        System.out.println("Length of the String is  : "+str.length() );
        StringPermutation permutation = new StringPermutation();
        permutation.permute(str, 0, n - 1);
    }


}
