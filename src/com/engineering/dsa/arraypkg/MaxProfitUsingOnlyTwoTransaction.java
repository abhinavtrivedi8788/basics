package com.engineering.dsa.arraypkg;

public class MaxProfitUsingOnlyTwoTransaction {

    public static int maxProfit(int[] prices) {
        int buy1 = Integer.MAX_VALUE;
        int buy2 = Integer.MAX_VALUE;
        int sell1 = 0;
        int sell2 = 0;

        for (int price : prices) {
            buy1 = Math.min(buy1, price);              // lowest price to buy first
            sell1 = Math.max(sell1, price - buy1);     // max profit after first sell

            buy2 = Math.min(buy2, price - sell1);      // effective second buy
            sell2 = Math.max(sell2, price - buy2);     // max profit after second sell
        }

        return sell2;
    }

    static void main() {
        int[] prices = {7,10,1,3,6,9,2};
        System.out.println("Max Profit with at most two transactions: " + maxProfit(prices));
    }
}
