import java.util.Arrays;

public class LIS {

     public int lengthOfLIS(int[] nums) {

        int[] dp =  new int[nums.length];
        int max_size = 1;
        Arrays.fill(dp, 1);

        for(int i=1; i<nums.length; i++){
            for(int j=0; j<i; j++){

                if(nums[i] > nums[j] && dp[j] + 1 > dp[i]){
                    dp[i] = dp[j] + 1;
                }

            }

            max_size = Math.max(max_size, dp[i]);
        }


        return max_size;
        
    }
    
}

/*
Intution for the solution

The subsequence meaning is to choose elements that may not be adjacent to each other
The problem stats to find the maximum longest subsequence that is strictly increasing

For example [3, 4, -1, 0, 6, 2, 3] LIS is -1, 0, 2, 3 and length is 4

You can see a element can either be added or skipped based on the current sequence
The sequence can occur start at any index and end at any index but condition of strictly increasing should be met
This is where we may use a recursive approach
But this approach will be expoentential time complexity i.e 2 power n because every element is either added or skipped

If we choose an iteration apporach, we will run two loop
We can check from one index to every other index, and update the length
The solution will be big-O of n-square appraoch

We don't have to have such a solution, so we turn to dynamic programming
In Dp, at every index, we will check what is the maximum sequence is possible from the start of the array

At index 0, it is 3
At index 1, it is 3, 4
At index 2, it is 3, 4
At index 3, it is either 3, 4 or -1, 0
At index 4, it is either 3, 4, 6 or -1, 0, 6
At index 5, it -1, 0, 2
At index 6, it is -1, 0, 2, 3

So there is no fixed sequence but at the end of the array, we are getting the LIS length as 4
The detailed working of the above solution is given below

 */
 


 /*
  * Proposed Solution

  The proposed solution will take n-square approach but we will use a dp array
  Yes, DP approach will be used and it will be n-square apporach
  We are calling it DP because we are relying on past computations to get the future or current result

We will take the dp array of size of the array provided and fill it will 1
At every element, LIS will be 1 by default because element to itself is always in sequence
We will have an max_size variable to keep track of the LIS length

We will run two for loop, first from i to array length, and second from j to i
For every index of i, we will see from the left, what is the maximum or longest subsequence

But there is an important condition, we will only take those values that are less than current i 
and thier (lower values) inclusion will be greater than the current sequence
This is the most important point to solve this problem

Let us use an example [3, 4, -1, 0, 6, 2, 3]
initially, dp is [1, 1, 1, 1, 1, 1, 1]

We will start i from 1 and j from 0

At i = 1, we see 3 is less than 4 and dp[j] + 1 > dp[i] therefore if we include 3, LIS till index 1 will be 2
so dp[1] is updates

At i = 2, we see current value as -1 
j = 0, 3 > -1 so condition fails
j = 1, 4 > -1 so condition fails
j = 2 loop breaks so dp[2] remains same

At i = 3, we see current value as 0
j = 0, fails
j = 1, fails
j = 2, we have -1 and -1 is less than 0 and dp[2] + 1 > dp[3] because 1 + 1 > 1, so dp[3] is 2

At i = 4, we see current value as 6

j = 0; 3 < 6, dp[0] + 1 > dp[4], so dp[4] updated to 2

LIS is 3, 6
j = 1, 4 < 6, dp[1] + 1 > dp[4] which is 2 + 1 > 2, so dp[4] updates to 3
LIS is 3, 4, 6

At j = 2, -1 < 6 but dp[2] + 1 > dp[4] fails. 
So LIS is still 3, 4, 6

At j = 3, 0 < 6 but dp[3] + 1 > dp[4] fails.
So LIS is still 3, 4, 6

We continue till the end of the array and final LIS is -1, 0, 2, 3 with length as 4


  */


/*
 * 
 * Given an integer array nums, return the length of the longest strictly increasing subsequence.

 

Example 1:

Input: nums = [10,9,2,5,3,7,101,18]
Output: 4
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
Example 2:

Input: nums = [0,1,0,3,2,3]
Output: 4
Example 3:

Input: nums = [7,7,7,7,7,7,7]
Output: 1
 

Constraints:

1 <= nums.length <= 2500
-104 <= nums[i] <= 104
 * 
 * 
 * 
 * 
 */