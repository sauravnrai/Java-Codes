

public class Stocks1 {

    public static void main(String[] args) {

        int[] prices = {7,6,4,3,1};

        System.out.println(sellStocks(prices));
        
    }

    public static int sellStocks(int[] prices){

        int len = prices.length;

        int Max_profit = 0;
        int stock = prices[0]; 
    
        for(int i=1; i<len; i++){

            if((prices[i] - stock) > Max_profit){
                Max_profit = prices[i] - stock;
            }

            stock = Math.min(stock, prices[i]);

        }



        return Max_profit;
    }
    
}

/* Solution for the problem
 * 
 * We need to be greedy to make the maximum profit for these stocks
 * 
 * We have different buying prices for each day and selling price for each day
 * 
 * If we buy the stock at cheapeast and sell it at its highest, then we would make a profit
 * 
 * We will always try to check for the minimum price to buy and maximum price to sell
 * 
 * Every day, we will check to sell and see what could be the profit
 * 
 * similarly, everyday, we could check the buying price and try to update it based on current value
 * 
 * 
 * 
 */




/*
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.

You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

 

Example 1:

Input: prices = [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
Example 2:

Input: prices = [7,6,4,3,1]
Output: 0
Explanation: In this case, no transactions are done and the max profit = 0.
 

Constraints:

1 <= prices.length <= 105
0 <= prices[i] <= 104
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */