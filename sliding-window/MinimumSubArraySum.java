
public class MinimumSubArraySum {

     public int minSubArrayLen(int target, int[] nums) {


        int sum = 0;
        int window = Integer.MAX_VALUE; // Initially window is MAXED OUT because no window is formed
        int left = 0;
        int right;
       
       for(right = 0; right < nums.length; right++){
        
        sum = sum + nums[right]; // keep adding the elements by expanding the window until the target becomes equal or greater than equal

        // If the windows sum becomes equal or greater than the window
        // We will shrink the window by moving left when sum is greater than target or sum
        while(sum >= target){
           
           // If sum and target are greater or same, then we will record the window size
            window = Math.min(window, right - left + 1);

            sum = sum - nums[left];
            // since window is shrinking, we will reduce the sum from left end as long as sum is greater or equal to target
            // This way window moves to its position

            left++;
        // Increment left pointer such that window moves

           
        }
        
        

       }


        return  window == Integer.MAX_VALUE? 0 : window;
        // return the final window size that contains target or 0 if it does not
        
    }
}



/*
 * If we do a brute-force approach, we will find all the elements that will do a sum upto target
 * We would run a loop within a loop and get a solution in n-square time
 * But, we can find the solution using sliding window
 * 
 * But here window size varies, it could be from 1 to length of the array
 * So, this is a dynamic window
 * 
 * We will have two pointers left and right
 * Both pointer will start from index 0
 * We will move the right pointer and add sum
 * When the sum gets greater or equal to target, we will record the window size
 * We then shrink the window by incrementing left pointer and decreasing the sum by element at left pointer index until sum is not greater or equal to target
 * By the end of the loop, we will get our minimum window size
 * 
 * It may appear that time complexity is n-square since we are running two loops
 * But it is O(n) since we don't use every index to every index
 * We will only use the inner loop when sum is equal or greater than the target
 * 
 * 
 */


/*
 * 
 * 
 * Given an array of positive integers nums and a positive integer target, return the minimal length of a subarray whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.

 

Example 1:

Input: target = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: The subarray [4,3] has the minimal length under the problem constraint.
Example 2:

Input: target = 4, nums = [1,4,4]
Output: 1
Example 3:

Input: target = 11, nums = [1,1,1,1,1,1,1,1]
Output: 0
 

Constraints:

1 <= target <= 109
1 <= nums.length <= 105
1 <= nums[i] <= 104
 
 */