import java.util.*;
import java.util.ArrayList;
import java.util.Arrays;

public class TwoSum {

    public static void main(String[] args) {
        
        Integer[] nums = {2,7,11,15};
        int target = 9;
        twoSum1(nums, target);
    }

    public static int[] twoSum1(Integer[] temp, int target){

        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(temp));
        int[] ans = new int[2];

        for(int element: arr){
            if(arr.contains(target - element)){
                ans[0] = element;
                ans[1] = target - element;
            }
        }
    
    System.out.println(Arrays.toString(ans));
    return ans;
    }

}
    
/*Solution

 * You need to use Integer as array instead of int and Arrays.asList() method to convert array to arraylist
 * 
 * The implementation is not exactly code needed for leetcode. On leetcode, we need to return indices
 * 
 * We will choose an element, reduce it in the target and check if the remaining number is part of the array
 * 
 * If we get both elements, we will note them or their indices, and return an array
 */


/*
 * 
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.

 

Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
Example 2:

Input: nums = [3,2,4], target = 6
Output: [1,2]
Example 3:

Input: nums = [3,3], target = 6
Output: [0,1]
 

Constraints:

2 <= nums.length <= 104
-109 <= nums[i] <= 109
-109 <= target <= 109
Only one valid answer exists.
 */


 /* Code submitted on Leetcode
 
 Note: We can't use same number twice

 class Solution {

    public int[] twoSum(int[] nums, int target) {

    Integer[] nums1 = new Integer[nums.length];

    for(int i=0; i<nums.length; i++){
        nums1[i] = nums[i];
    }

     return twoSum1(nums1, target);
        
    }

    public static int[] twoSum1(Integer[] temp, int target){

        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(temp));
        int[] ans = new int[2];
        Arrays.fill(ans, -1);

        for(int i=0; i <arr.size(); i++){
            if(arr.contains(target - arr.get(i))){
                ans[0] = i;
                ans[1] = arr.indexOf(target - arr.get(i));
            }

            if(ans[0]!= ans[1]){
                break;
            }
        }
    
  //  System.out.println(Arrays.toString(ans));
    return ans;
    }
}

  * 
  */