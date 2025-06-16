import java.util.Arrays;

public class SearchInsertPosition {

 public int searchInsert(int[] nums, int target) {

        int index = Arrays.binarySearch(nums, target);
        // returns index if found or negative index where element should be place
        // if 2 is is index and element is not found at 2, then it will return -3
        // So we first need to convert -3 to 3 and subtract 1

        if(index < 0) index = (-1 * index) - 1 ;
        // If index is not found, then we first convert negative index to positive and subtract -1 as result was 1-based index
         
        return index;
    }

    
}



/*
 * 
 * Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You must write an algorithm with O(log n) runtime complexity.

 

Example 1:

Input: nums = [1,3,5,6], target = 5
Output: 2
Example 2:

Input: nums = [1,3,5,6], target = 2
Output: 1
Example 3:

Input: nums = [1,3,5,6], target = 7
Output: 4
 

Constraints:

1 <= nums.length <= 104
-104 <= nums[i] <= 104
nums contains distinct values sorted in ascending order.
-104 <= target <= 104
 * 
 * 
 * 
 * 
 */