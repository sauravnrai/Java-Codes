



public class PartitionEqualSum {

    public boolean canPartition(int[] nums) {

        int sum = 0;

        for(int item: nums){
            sum = sum + item;
        }
        
        
// If the sum is odd, we can never get the equal partition, so we return false
        if(sum % 2 != 0) return false;

        int target = sum / 2;
// If the sum is even, then we may get an equal partiton and we just need to check for 1 partition because another partition will occur for sure
// So we are dividing the sum by 2 to get a target for one partiion

// We will use a dp array to track if it is possible to get to the partition and size will be target + 1
        boolean[] dp = new boolean[target + 1];
        // We will store all the values till the target + 1 and check if the partition is possible
      
      dp[0] = true;
      // achieve a partition of sum 0 is always true
     
     // We will run two loop to check if the target is possible to achieve as a partition
        for(int item: nums){
            for(int i=target; i >= item; i--){
                if( dp[i - item] ) dp[i] = true;
                // if the target is achievable if we include the current num, then it is possible and we return true
            }
        }
        


        return dp[target];
    }
    
}

/*
Solution to the problem
 * 
 * The problem is to find if we can divide the array into two parts where sum is same
 * We first need to understand that partition is only possible if the sum is even
 * For odd sum, it is not possible
 * 
 * Now, after we determine sum is even. if we find only one partition then we can say problem is solved
 * In order to do so, we need to identify those elements that can get this sum
 * So, we use DP to solve this problem
 * We first need to check for every element with the target and this target is sum / 2
 * 
 * Partition is possible for every element in the array
 * But there are certain conditions that needs to be met and this is the heart of the problem
 * 
 * In the proposed solution, we will use a dp array with length target + 1
 * We will have index from 0 to target
 * For 0, target always exist as true
 * 
 We will run two loops, the outer loop will take each element in the array
 Another loop will check if target - element is possible but target will be reduced after every iteration
 and target - element will only run till element itself as we can run into index out of bound
 We will only update the dp array if we find that partition
 
 This is the loop
 // We will run two loop to check if the target is possible to achieve as a partition
        for(int item: nums){
            for(int i=target; i >= item; i--){
                if( dp[i - item] ) dp[i] = true;
                // if the target is achievable if we include the current num, then it is possible and we return true
            }
        }

    The partition till that target sum will be true based on the previous element
    for example [1, 2, 3, 6]

    Dp[7] = true for all index 0 to 6 and these indices are target sums

    for Dp[0] it will be true

    for element = 1, target is 6 and it will run till 1
         for target 6, dp[6] will check dp[6 - 1] which is false, so no updation
         for target 5, dp[5] will check dp[5 - 1] which is false, so no updation
         for target 4, dp[4] will check dp[4 - 1] which is false, so no updation
         for target 3, dp[3] will check dp[3 - 1] which is false, so no updation
         for target 2, dp[2] will check dp[2 - 1] which is false, so no updation
         for target 1, dp[1] will check dp[1 - 1] i.e dp[0] which is true, dp[1] or dp[target - element] is updated to true
         for target 0, 0 is less than current element and it is skipped, 1 - 0 gives negative index, so it is skipped

         The process repeats for all elements and we always start from target = 6

         dp[0] = true
         dp[1] = true
         dp[2] = true thanks to dp[1]
         dp[3] = true thanks to dp[2]
         dp[4] = true thanks to dp[3]
         dp[5] = true thanks to dp[4]
         dp[6] = true thanks to dp[5]
         
         But this entire array gets updated because of outer loop that runs on nums array [1, 2, 3, 6]
         In the end, we return dp[6]
    
 * 
 * 
 * 
 * 
 * 
 */



/*
 * Given an integer array nums, return true if you can partition the array into two subsets such that the sum of the elements in both subsets is equal or false otherwise.

 

Example 1:

Input: nums = [1,5,11,5]
Output: true
Explanation: The array can be partitioned as [1, 5, 5] and [11].
Example 2:

Input: nums = [1,2,3,5]
Output: false
Explanation: The array cannot be partitioned into equal sum subsets.
 

Constraints:

1 <= nums.length <= 200
1 <= nums[i] <= 100
 */