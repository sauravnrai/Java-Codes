

public class LC3566 {
    
}

/*
 * Solution for the problem
 * 
 * 
 * If we can divide the array into subset such that product is target, then product of these two subsets will
 * be target * target
 * 
 * So, the base case to check if it is possible is to check target * target
 * We will find product of all elements and then check it against target * target
 * If equal, we will continue otherwise return false
 * 
 * Now, It is not possible to apply DP because there are no overlapping subproblems
 * We have to find all the possible subsets and then check among them
 * If we have an array [1, 2, 3, 6] then for target 6, we have to check 2 power 4 possible subsets
 * In these subsets, we will get [1, 6] and [2, 3]
 * But we can use bit mask to represent these subsets
 * For subset [1], we could use 1000 that shows 1 is included and rest are excluded
 * For subset [1, 6], we could use 1001 that shows 1 and 6 are included
 * For subset [2, 3], we could use 0110 that shows 2 and 3 are included
 * 
 * Using these 1's we will find the product and only include those elements that have 1
 * This approach will reduce time-complexity
 * 
 * 
 * 
 * 
 * 
 */


/*
 * 
 * You are given an integer array nums containing distinct positive integers and an integer target.

Determine if you can partition nums into two non-empty disjoint subsets, with each element belonging to exactly one subset, such that the product of the elements in each subset is equal to target.

Return true if such a partition exists and false otherwise.

A subset of an array is a selection of elements of the array.
 

Example 1:

Input: nums = [3,1,6,8,4], target = 24

Output: true

Explanation: The subsets [3, 8] and [1, 6, 4] each have a product of 24. Hence, the output is true.

Example 2:

Input: nums = [2,5,3,7], target = 15

Output: false

Explanation: There is no way to partition nums into two non-empty disjoint subsets such that both subsets have a product of 15. Hence, the output is false.

 

Constraints:

3 <= nums.length <= 12
1 <= target <= 1015
1 <= nums[i] <= 100
All elements of nums are distinct.
 * 
 * 
 * 
 * 
 */