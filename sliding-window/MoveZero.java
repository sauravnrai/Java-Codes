

public class MoveZero {

     public void moveZeroes(int[] nums) {
     
     int left = 0;
 
 // moves all the non-zeroes to start of the array
     for(int right = 0; right<nums.length; right++){

        if(nums[right] != 0){
           nums[left] = nums[right];
           left++;
        }

     }

     //put 0's at the remaining places 
     while(left < nums.length){
        nums[left] = 0;
        left++;
     }

        
    }
    
}


/*
 * The main crux lies in without using any extra space so it will take swaps
 * We will use a two pointer apporach left and right
 * Left pointer will be used to place all the non-zero elements to the start in place
 * The right pointer will parse through entire array till the end
 * In a single parse, all non-zero will be at front
 * Using left, we are mark remaining places as 0
 * 
 * We just need to ignore 0's encounter in the first parse
 * We should also have to be mindful about the window i.e start and end
 * 
 * 
 * 
 */


/*
 * 
 * 
 * Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Note that you must do this in-place without making a copy of the array.

 

Example 1:

Input: nums = [0,1,0,3,12]
Output: [1,3,12,0,0]
Example 2:

Input: nums = [0]
Output: [0]
 

Constraints:

1 <= nums.length <= 104
-231 <= nums[i] <= 231 - 1
 

Follow up: Could you minimize the total number of operations done?
 * 
 * 
 * 
 * 
 */