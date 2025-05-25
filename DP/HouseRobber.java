
class HouseRobber{

    public int rob(int[] nums) {
       

        if(nums.length == 1) return nums[0];
        
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
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.

 

Example 1:

Input: nums = [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
Total amount you can rob = 1 + 3 = 4.
Example 2:

Input: nums = [2,7,9,3,1]
Output: 12
Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
Total amount you can rob = 2 + 9 + 1 = 12.
 

Constraints:

1 <= nums.length <= 100
0 <= nums[i] <= 400
 * 
 * 
 * 
 * 
 */