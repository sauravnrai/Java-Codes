public class JumpGame {

    public boolean canJump(int[] nums) {

        int size = nums.length;
      int  current = nums.length - 2; // starts from last 2nd position
       int finish = nums.length - 1; // last posiiton

       // loop to hop between indices and check if jump is poosible
        for(; current >= 0; current --){

            if(current + nums[current] >= finish) finish = current;
        }
        
        return finish == 0;
        // return the answer
    }
    
}



/*
 * The brute-force takes n power n and dp takes n-sqaure time complexity 
 * but greedy takes only O(n) time complexity
 * 
 * In order to reach the last index, we need at least 1 on all the element
 * so, we can reach the final index in O(n)
 * But this may not be true for all instances
 * So, we can use a two pointer approach to solve this problem
 * The two pointer approach will be used to check from current index and last finish index
 * 
 * Initially, finish index will be last index
 * But if we find there is a way to reach that finish index from a current index, then current index becomes finish index
 * current index will be reduced on each iteration but finish index will only be udpated if it is reachable
 * The condiiton to use will be current index + value at that index greater than or equal to finish index
 * If we reach the 0th index then we solved the problem
 * 
 * So, we will get an answer is O(n)
 * 
 * 
 * 
 * 
 */



/*
 * 
 * You are given an integer array nums. You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.

Return true if you can reach the last index, or false otherwise.

 

Example 1:

Input: nums = [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
Example 2:

Input: nums = [3,2,1,0,4]
Output: false
Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.
 

Constraints:

1 <= nums.length <= 104
0 <= nums[i] <= 105
 * 
 * 
 * 
 * 
 */