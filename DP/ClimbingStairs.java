import java.util.Arrays;

public class ClimbingStairs{

    public int climbStairs(int n) {

        int[] memo = new int[n+1];
        Arrays.fill(memo, -1); // fill all the cells
        memo[0] = 1; // 0th step is always 1
        memo[1] = 1; //1st step is always 1
        
        return Climb(memo, n);
        }


        public static int Climb(int[] memo, int n){


            if(n == 0 || n == 1) return memo[n];

            if(memo[n] != -1) return memo[n];


            memo[n] = Climb(memo, n-1) + Climb(memo, n-2);
            // The recursive call because we either take 1st step back or 2 step back

            return memo[n]; // return the final answer
        }
        

}

/*
 * We are actually supposed to calculate number of ways to get to 0th floor from the nth floor
 * At 0th floor, it is 1 way
 * At 1st floor, it is 1 way
 * 
 * At 2nd floor, it is 2 ways
 * we can either go 2 steps back, get to 0
 * we also go 2 to 1 and then 1 to 0
 * 
 * We can see the base case for this dynamic programming problem
 * We can use a 1d array to store all the function call values
 * From any floor, we will either take 1 step or 2 steps
 * We will use recursion and memorization to solve this problem
 * 
 * The extension of this problem is the jump game problem
 * 
 * 
 */


 /* 
 * 
 * You are climbing a staircase. It takes n steps to reach the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

 

Example 1:

Input: n = 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps
Example 2:

Input: n = 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step
 

Constraints:

1 <= n <= 45
 */