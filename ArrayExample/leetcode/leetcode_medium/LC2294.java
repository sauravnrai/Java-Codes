

// Partition Array Such that Maximum difference is K

import java.util.Arrays;

public class LC2294 {

    public int partitionArray(int[] nums, int k) {

        if(nums.length == 1) return 1;

        Arrays.sort(nums);

        // The given problem is similar to merge interval in arrays

        int counter = 1;
        int range = nums[0] + k; // sets the initial range

    for(int i=1; i<nums.length; i++){

        if(nums[i] > range){
            counter ++;
            range = nums[i] + k;
        }

    }

        return counter;

}
    
}

/*
  Solution to the problem
  
 * Leetcode 2294: Partition Array Such That Maximum Difference Between Any Two Elements Is Less Than or Equal to K
 *
 * Problem Summary:
 * - Given an array of integers `nums` and an integer `k`, partition the array into the **minimum number of subsequences**
 *   such that the **difference between the maximum and minimum** element in each subsequence is **at most `k`**.
 * - Return the minimum number of subsequences (partitions) needed.
 *
 * Intuition:
 * - The idea is similar to merging intervals. We want to group elements such that the difference in each group is ≤ k.
 * - To do this efficiently, we sort the array first so similar values are grouped together.
 * - We iterate through the array and keep track of the current valid range (`min + k`). If a number exceeds this range,
 *   we start a new partition and update the range.
 *
 * Step-by-step Explanation:
 *
 * 1. If the array has only one element, we return 1 (since one element itself is a valid partition).
 *
 * 2. Sort the input array to bring close values together. This is crucial because elements closer in value can
 *    be grouped into the same partition.
 *
 * 3. Initialize:
 *    - `counter = 1` → at least one group is needed.
 *    - `range = nums[0] + k` → this defines the maximum allowed value in the current group.
 *
 * 4. Traverse from the 2nd element (i = 1) to the end:
 *    - If the current element exceeds the current range (`nums[i] > range`), it cannot be in the same group.
 *    - So, increment the counter (start a new group) and reset the range to `nums[i] + k` (new base value).
 *
 * 5. Return the final count of partitions.
 *
 * Time Complexity:
 * - Sorting: O(N log N)
 * - Single pass: O(N)
 * - Total: O(N log N)
 *
 * Space Complexity:
 * - O(1) extra space (in-place operations)
 *
 * Example:
 * Input: nums = [3,6,1,2,5], k = 2
 * Sorted: [1,2,3,5,6]
 * Groups: [1,2,3] and [5,6] → 2 partitions
 */



/*
 * You are given an integer array nums and an integer k. You may partition nums into one or more subsequences such that each element in nums appears in exactly one of the subsequences.

Return the minimum number of subsequences needed such that the difference between the maximum and minimum values in each subsequence is at most k.

A subsequence is a sequence that can be derived from another sequence by deleting some or no elements without changing the order of the remaining elements.

 

Example 1:

Input: nums = [3,6,1,2,5], k = 2
Output: 2
Explanation:
We can partition nums into the two subsequences [3,1,2] and [6,5].
The difference between the maximum and minimum value in the first subsequence is 3 - 1 = 2.
The difference between the maximum and minimum value in the second subsequence is 6 - 5 = 1.
Since two subsequences were created, we return 2. It can be shown that 2 is the minimum number of subsequences needed.
Example 2:

Input: nums = [1,2,3], k = 1
Output: 2
Explanation:
We can partition nums into the two subsequences [1,2] and [3].
The difference between the maximum and minimum value in the first subsequence is 2 - 1 = 1.
The difference between the maximum and minimum value in the second subsequence is 3 - 3 = 0.
Since two subsequences were created, we return 2. Note that another optimal solution is to partition nums into the two subsequences [1] and [2,3].
Example 3:

Input: nums = [2,2,4,5], k = 0
Output: 3
Explanation:
We can partition nums into the three subsequences [2,2], [4], and [5].
The difference between the maximum and minimum value in the first subsequences is 2 - 2 = 0.
The difference between the maximum and minimum value in the second subsequences is 4 - 4 = 0.
The difference between the maximum and minimum value in the third subsequences is 5 - 5 = 0.
Since three subsequences were created, we return 3. It can be shown that 3 is the minimum number of subsequences needed.
 

Constraints:

1 <= nums.length <= 105
0 <= nums[i] <= 105
0 <= k <= 105
 * 
 * 
 * 
 */