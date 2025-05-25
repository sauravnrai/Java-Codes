

public class MaxSubArray {

    public static void main(String[] args) {
        
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};

        System.out.println(maxSum(nums));
    }

  public static int maxSum(int[] arr){

        int len = arr.length;

        int current_sum = arr[0];
        int overall_sum = arr[0];

        for(int i=1; i<len; i++){

            if(current_sum + arr[i] <= arr[i]){
                current_sum = arr[i];
            }else{
                current_sum += arr[i];
            }

            if(current_sum > overall_sum){
                overall_sum = current_sum;
            }

        }
    
        return overall_sum;
    }
    
}


/*
 *
 * Leetcode 53
 * 
 *  
 * Given an integer array nums, find the subarray with the largest sum, and return its sum.

 

Example 1:

Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: The subarray [4,-1,2,1] has the largest sum 6.
Example 2:

Input: nums = [1]
Output: 1
Explanation: The subarray [1] has the largest sum 1.
Example 3:

Input: nums = [5,4,-1,7,8]
Output: 23
Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.
 
 * 
 * How to solve?
 * 
 * We will start from the initial index of the array maintaining two variables current and overall sum. 
 * 
 * The current solution is also known as Kadane's algorothm
 * 
 * We will keep adding the elements to the current sum variable since maximum subarray may contain 0
 * 
 * A subarray would either continue or start from a new index based on a specific condition. That condition is the current element
 * If the (current sum + new element) is negative and current element is greater than (current sum + current element) then start new subarray current sum from that element
 * Otherwise, add the new element in the current sum
 * 
 * And to get the final maximum sum, we always check if overall sum is less than current sum, then we can update overall sum
 * 
 * 
 * Example 
 * 
 * For Array [10, -8, -2, 5, 2]
 * 
 * Initially current sum and overall sum is 0
 * 
 * index = 0 has 10 then current sum is 10 and overall sum is 10 
 * 
 * index = 1 has -8, then current sum + new element is 2 and overall sum is 2
 * index = 2 has -2 then current sum + new element is 0 and overall sum is 0
 * index = 3 has 5 but we start from 5 since current sum is 0, current sum is 5 and overall sum is 0
 * index = 4 has 2 then current sum + new element is 7 and overall sum is 10
 * 
 * 10 is maximum subarray
 * 
 * 
 * For Array [-3, -2, -2, -3]
 * 
 * We start with both current and overall sum is -3
 * 
 * At index 1, current + new element is -5, and new element is -2, so current sum becomes -2 along with overall sum 
 * 
 * At index 2, current + new element is -4, and new element is -2, so current sum becomes -2 from index 2 and no change to overall sum
 * 
 * At index 3, current + new element is -5, and new element is -3, so current sum becomes -3 from index 3 and no change to overall sum
 * 
 * -2 is maximum subarray
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */