import java.util.HashMap;
import java.util.Map;

public class SubArraySumK {
public int subarraySum(int[] nums, int k) {

        int current = 0; // used to find prefix sum
        int count = 0; // used to find the count
        Map<Integer, Integer> map = new HashMap<>(); // map to check if count is greater than 0 
        // We will store prefix sum - target in the map and it appread how many times
        map.put(0, 1); // For 0, map should be 1

        for(int item: nums){

            current = current + item;

            count = count + map.getOrDefault(current - k, 0);
            // This checks if the current - k was their in map or not, if not then it gives result as 0. current - k indicates result was there

            map.put(current, map.getOrDefault(current, 0) + 1);
            // This is used to store the current prefix sum in the map and increment its value by 1
            /* We are storing all prefix sums, and if a prefix has occured in the past then it 
             is a indiciation that there is a subarray is their equals k*/



        }
        return count;
    }
    
}


/*
Solution for the problem
 * 
 * To solve this problem we need to use prefix sum and hash map
 * 
 * We will use the target to see till what point of the array, we could get a particular sum
 * The target sum k can occur between any two indices subarrays
 * A brute force way to find this would be to use two loops and get the sum equal to k
 * But this will be slow and will take n-square time complexity
 * 
 * If we use a hash map using key-value pair, we can easily find all the occurence
 * We will find prefix sum till that element and subtract it using the target
 * We will track all of these values in a hash map, use result as a key and occurence as a value
 * 
 * At the end of the program, we will use target as a key in the return the occurence
 * 
 * 
 */

/*
 * 
 * Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.

A subarray is a contiguous non-empty sequence of elements within an array.

 

Example 1:

Input: nums = [1,1,1], k = 2
Output: 2
Example 2:

Input: nums = [1,2,3], k = 3
Output: 2
 

Constraints:

1 <= nums.length <= 2 * 104
-1000 <= nums[i] <= 1000
-107 <= k <= 107

 */