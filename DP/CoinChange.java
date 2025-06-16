import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class CoinChange {

    public int coinChange(int[] coins, int amount) {

        // Base case
        if(amount == 0) return 0;

        int[] sums = new int[amount  + 1];
        // indices will be used as hold the amount, since index starts from 0, we are using amount + 1

        Arrays.fill(sums, Integer.MAX_VALUE);
        // initially all amount will be -1 since we don't have any idea to have best ans

        sums[0] = 0;
        // for sum 0, it will always be 0 coins


      // We will find coins for all the amount value using every coin
        for(int i = 1; i<sums.length; i++){
            for(int j=0; j<coins.length; j++){
                
    // Most important conditon to understand the code
    // We are not interested in negative sums and sums that can't be reached through any coins
                if(i - coins[j] >= 0 && sums[i - coins[j]] != Integer.MAX_VALUE){
                sums[i] = Math.min( sums[i], 1 + sums[i - coins[j] ]);

                }
// We are supposed to return the minimum number of coins to genearate the coins for that amount
            }
        }
        
        return sums[amount] == Integer.MAX_VALUE ? -1: sums[amount]; 
    // returns the number of coins to get the amount if a value exist or returns -1
    }

}


/*
 * Solution for the problem
 * 
 * We will have a dp array by name sums[amount + 1] of size amount + 1
 * We are taking amount + 1 because indices start at 0, it will be better to check from 0 to amount
 * Initially fill all arrays with a random value 
 * Since we are finding min coins, we will use Integer.MAX_INTEGER
 * We will run two loops, one for the amount and another for the coins
 * At the center of each loop, we will find minimum coins using Math.min() function
 * 
 * But an amount - coins shouldn't be negative as it will give array index out of bounds exception
 * And that amount should be known, then we can proceed to find the number of coins
 * This is the important condition of this problem
 * 
 * In the end, will will either return -1 or number of coins 
 * 
 */

/* Intution for solving the problem

 * This problem can be solved using a dp array of amount
 * We can use two loops, one for the amount array and one for the coins array
 * If amount array is of size n, and coin array is of size m then overall complexity will be Big-O of n x m
 * 
 * For every amount, we will see the minimum amount of coins to fetch the amount
 * This is also a min-max problem, so focus is on minimum
 * 
 * We can try out all the combinations, but that will be expontential 
 * We can use recursion too, but question will be which one to choose and which coin to skip, and then compute the least amount
 * We can also use a iterative approach 
 * 
 * */


 /*
  * You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

You may assume that you have an infinite number of each kind of coin.

 

Example 1:

Input: coins = [1,2,5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1
Example 2:

Input: coins = [2], amount = 3
Output: -1
Example 3:

Input: coins = [1], amount = 0
Output: 0
 

Constraints:

1 <= coins.length <= 12
1 <= coins[i] <= 231 - 1
0 <= amount <= 104


  */