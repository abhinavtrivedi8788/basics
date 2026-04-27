package com.engineering.strings;

import java.util.Stack;

public class StringBalanceCheck {

    private static Stack<Character> stack = new Stack<Character>();

    /**
     * @param inputString
     * @return
     */
    private static Boolean isBalanced(String inputString) {
        char[] charArray = inputString.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == '{' || charArray[i] == '[' || charArray[i] == '(') {
                stack.push(charArray[i]);
            } else {
                if (charArray[i] == ')') {
                    if ((stack.isEmpty() || stack.pop() != '('))
                        return Boolean.FALSE;
                } else if (charArray[i] == ']') {
                    if ((stack.isEmpty() || stack.pop() != '['))
                        return Boolean.FALSE;
                } else if (charArray[i] == '}') {
                    if ((stack.isEmpty() || stack.pop() != '{'))
                        return Boolean.FALSE;
                }
            }
        }
        return Boolean.TRUE;
    }

     static void main(String[] args) {

        String grammar = "{[()]}[]{{()}}"; System.out.println("Returned Value is " +
                StringBalanceCheck.isBalanced(grammar));

    }
}
