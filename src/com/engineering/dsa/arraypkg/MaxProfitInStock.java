package com.engineering.dsa.arraypkg;

public class MaxProfitInStock {

    private static int maxProfit(int [] prices){
        int maxProfit =0;
        int minPrice = Integer.MAX_VALUE;

        for(int price : prices ){
            if(price < minPrice){
                minPrice = price ;
            }
            int profit = price - minPrice;
            if(	profit > maxProfit){
                maxProfit = profit ;
            }
        }
        return maxProfit ;
    }

    static void main() {
        int prices [] = {7,10,1,3,6,9,2};
        System.out.println(maxProfit(prices));
    }
}
