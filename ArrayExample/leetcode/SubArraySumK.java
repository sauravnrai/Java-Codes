

public class SubArraySumK {

    
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