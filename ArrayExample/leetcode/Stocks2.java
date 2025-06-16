

public class Stocks2 {

    public int maxProfit(int[] prices) {

        int max = 0;
        
        int stock = prices[0];

        for(int i=1; i<prices.length; i++){

            if(prices[i] > stock){
                max = max + prices[i] - stock; // find the profit of the stock difference
                stock = prices[i]; // purchase new stock as it has bigger price
            }else{
                 stock = prices[i]; // since new stock is lower in prices, we hold it instead of previous stock
            }

        }
     

     return max;   
    }

    
}

/*
 * In the previous version, we were buying the smallest purchase stock and selling it against highest day
 * This was only possible for 1 buy and 1 sell and our goal was to get maximum profit
 * But, now, we can hold multiple stocks and decide when to sell it
 * At any juncture, we can hold only 1 stock
 * 
 * Problem is we can't get greedy now, because if we immediately decide to sell a stock, then might miss out on maximum profit
 * For example [1, 2, 3, 4, 5]
 * If we buy stock at 1, then decide to sell on 2, we will get only 1 as profit but we could have got 4 if we sold it on 5
 * But we will get same profit if
 * Buy 1 and sell at 2, profit 1
 * Buy 2 and sell at 3, profit 1
 * Buy 3 and sell at 4, profit 1
 * Buy 4 and sell at 5. profit 1
 * Total profit was 4
 * Since we can buy and sell the stock on same day
 * 
 * Similarly, for [7,1,5,3,6,4] if we buy at 1 and sell it on 6, we will get profit of 5 but
 * if we buy at 1, sell it on 5
 * if we buy at 3 and sell it on 6
 * We will get 4 + 3 = 7 profit
 * 
 * We are adjusting our stock based on the incoming stock price and selling it to based on it
 * 
 * If current stock price is lesser than incoming one, find difference and add it to a max variable
 * We will take the incoming stock price as our new stock
 * 
 * If the current stock price is greater than the incoming one, then incoming one is taken
 * 
 * And at the end, we return the max profit
 * We will either hold the stock for max 1 day
 * 
 * *** Alternate Solution *** 
 * There could be an alternative approach for this solution like sliding window and prefix array
 * to find maximum profit till a specific index and add it
 */


/*
 * 
 * You are given an integer array prices where prices[i] is the price of a given stock on the ith day.

On each day, you may decide to buy and/or sell the stock. You can only hold at most one share of the stock at any time. However, you can buy it then immediately sell it on the same day.

Find and return the maximum profit you can achieve.

 

Example 1:

Input: prices = [7,1,5,3,6,4]
Output: 7
Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
Total profit is 4 + 3 = 7.
Example 2:

Input: prices = [1,2,3,4,5]
Output: 4
Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
Total profit is 4.
Example 3:

Input: prices = [7,6,4,3,1]
Output: 0
Explanation: There is no way to make a positive profit, so we never buy the stock to achieve the maximum profit of 0.
 

Constraints:

1 <= prices.length <= 3 * 104
0 <= prices[i] <= 104
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */