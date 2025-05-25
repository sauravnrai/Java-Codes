
public class HouseRobber2 {

    public int rob(int[] nums) {
       
      // The problem becomes a bit complex because of last and 1st house being neighbours
        // This condition makes it complex but we can break this circle condition
       
        //But we skip the last house, it will become a traditional house robber problem from index 0 to 2nd last index
        //But if we skip the first housee, it will also become a traditional house robber problem from index 1 to last index
        // If we skip either last or first, we can get the solution but in the end we have to check which skip is giving more money

        if(nums.length == 1) return nums[0];

        if(nums.length == 2) return Math.max(nums[0], nums[1]);
         
         int size = nums.length - 1;
        int[] skippedFirst = new int[size];
        int[] skippedLast = new int[size];
       
       // skipped first array is array after skipped first element of nums
       for(int i=0; i < nums.length - 1; i++){
         skippedFirst[i] = nums[i + 1]; // +1 to index of nums array because we are trying to store values of nums from index 1 to last index
       }

       // skipped last array is array after skipping last element of nums
        for(int i=0; i<nums.length - 1; i++){
            skippedLast[i] = nums[i]; // this will store all elements from 0 excluding last element
        }

    int Max1 = Profit(skippedFirst);
    int Max2 = Profit(skippedLast);

    return Math.max(Max1, Max2);


    }

    public static int Profit(int[] nums){

        int[] max_profit = new int[nums.length];
        // DP array to store max profit of each house

        for(int i=0; i<nums.length; i++){
           
           // The first house
            if(i==0){
                max_profit[i] = nums[i];
            }else if(i==1){
                max_profit[i] = Math.max(max_profit[i-1], nums[i]);
            }else{
      // From the 2nd house, we either add that house and don't
            // Since all the house have non-negative values, we can always look for last 2nd house and recent house profit
            max_profit[i] = Math.max(nums[i] + max_profit[i-2], max_profit[i-1]);
    // We either choose to rob a house or not, but we will always store the max profit till that house
    // So we always check is it even worth to steal the new house or just leave it
                 }

        }

       

      return Math.max(max_profit[nums.length - 2], max_profit[nums.length - 1]);
      // checks for the maximum profit between last two houses and sends the final result        

    }
        
    
}

/*
 * To solve this problem, we have reduce this to house robber 1.
 * If there are n houses
 * We calculate house 1 to house n-1 profit using traditional house robber
 * we also calculate house 2 to house n profit using traditional house robber
 * We find the maximum between these two and return the value as the solution
 * 
 */



/*
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed.
 *  All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. 
 * Meanwhile, adjacent houses have a security system connected, and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.

 

Example 1:

Input: nums = [2,3,2]
Output: 3
Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2), because they are adjacent houses.
Example 2:

Input: nums = [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
Total amount you can rob = 1 + 3 = 4.
Example 3:

Input: nums = [1,2,3]
Output: 3
 

Constraints:

1 <= nums.length <= 100
0 <= nums[i] <= 1000
 * 
 * 
 * 
 * 
 */