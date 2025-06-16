import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicte2 {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
    Map<Integer, Integer> map = new HashMap<>(); // stores number and its last seen index

    for (int i = 0; i < nums.length; i++) {
        if (map.containsKey(nums[i])) {
            int prevIndex = map.get(nums[i]);
            if (i - prevIndex <= k) {
                return true; // duplicate within k distance
            }
        }
        map.put(nums[i], i); // update the index for current number
    }

    return false; // no valid duplicate found
}
    
}


/*
   The goal of this problem is to find atleast one element or number
    that occurs on two different indices in the array and satisfies 
    nums[i] == nums[j] and absolute difference between i and j should be less than or equal to k
 * 
 * // We use a HashMap to store the last index where each number was seen
// The goal is to check if a number has appeared before within a distance of k

// Iterate over the array from index 0 to n-1
// For each number:
//   - If the number already exists in the map:
//       - Retrieve its previous index
//       - Check if the difference between the current index and the previous index is <= k
//           - If yes, return true (a valid nearby duplicate is found)
//   - If the number is not in the map or the difference is too large:
//       - Update the map with the current index for that number

// If the loop completes without returning true, then no nearby duplicate was found
// Return false at the end

// Time Complexity: O(n), where n is the number of elements in the array
// Space Complexity: O(n), for storing elements and their indices in the HashMap

 * 
 * 
 */


/*
 * Given an integer array nums and an integer k, return true if there are two distinct indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <= k.

 

Example 1:

Input: nums = [1,2,3,1], k = 3
Output: true
Example 2:

Input: nums = [1,0,1,1], k = 1
Output: true
Example 3:

Input: nums = [1,2,3,1,2,3], k = 2
Output: false
 

Constraints:

1 <= nums.length <= 105
-109 <= nums[i] <= 109
0 <= k <= 105
 * 
 * 
 * 
 * 
 */