import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class LC2099 {

    public int[] maxSubsequence(int[] nums, int k) {

        int[] ans = new int[k]; // initialize the final answer array

       PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[0], b[0]));
       // Priority queue to store the top k elements with their indices
        // Custom comparator compares based on values, smaller values have higher priority (min-heap)

        for(int i=0; i<nums.length; i++){

            pq.offer(new int[]{nums[i], i});
            // We will store (value, pair) in the min heap

            if(pq.size() > k) pq.poll();
            // remove the smallest element
        }


        // since the min-heap is storing primarily based on values, we need to sort it again based on indices
        // Min heap contains only k largest elements in the heap
        // We are taking an arraylist that will hold PQ where each element is an array 
        List<int []> topK = new ArrayList<>(pq);
        // since pq was storing an array with where each array would contain value and its index
 
 // Lets us sort the arraylist based on the index to maintain the subsequence order
   topK.sort((a,b) -> Integer.compare(a[1], b[1]));
   // Here, we have used index 1 not 0 because at every array, index 0 contains the value and index 1 contains the index of the value in the nums array


   // loop to insert the values in the final array
   for(int i=0; i<k; i++){
    ans[i] = topK.get(i)[0]; // we are just storing data or values as their are sorted by indices now
    // All these values are the top largest k elements thanks to heap
   }

        return ans; // return the final array answer
         
    }
    
}

/*
This function solves the problem of finding a subsequence of size `k` from the input array `nums`
such that the sum of elements in the subsequence is maximum. The order of elements in the original
array must be preserved in the final result.

### STEP 1: Initialize structures
- We initialize an array `ans` of size `k` to store the final answer.
- We use a `PriorityQueue<int[]>` (min-heap) to keep track of the top `k` elements with the highest values.
  Each entry in the heap is an `int[]` of two elements:
    - index 0 → the value of the number
    - index 1 → the original index in the array (to preserve order later)

### STEP 2: Traverse the input array
- For every element in `nums`, we add it to the heap along with its index.
- If the heap grows larger than `k`, we remove the smallest element. This ensures that only the top
  `k` largest elements remain in the heap at any time.
- This uses the property of min-heap: the smallest element is always at the top and gets removed first.

### STEP 3: Sorting the top k elements
- Now, the heap contains the top `k` largest values, but not in their original order.
- To maintain the **subsequence** requirement (preserve relative order from `nums`), we copy all
  elements from the heap into a `List<int[]>`, and sort that list by the original indices (i.e., second element in the pair).
- This way, we ensure that the selected elements appear in the same order as they did in the input.

### STEP 4: Extract final result
- Loop through the sorted list and collect only the values (not indices) into the result array `ans`.

### Why this approach works:
- The priority queue ensures we always track the `k` largest values.
- Sorting by original index ensures we preserve the order for the subsequence.
- Overall time complexity:
    - Heap operations: O(n log k)
    - Sorting top k elements: O(k log k)
- This solution is both optimal and clean for the given problem.
*/





/*
 * You are given an integer array nums and an integer k. You want to find a subsequence of nums of length k that has the largest sum.

Return any such subsequence as an integer array of length k.

A subsequence is an array that can be derived from another array by deleting some or no elements without changing the order of the remaining elements.

 

Example 1:

Input: nums = [2,1,3,3], k = 2
Output: [3,3]
Explanation:
The subsequence has the largest sum of 3 + 3 = 6.
Example 2:

Input: nums = [-1,-2,3,4], k = 3
Output: [-1,3,4]
Explanation: 
The subsequence has the largest sum of -1 + 3 + 4 = 6.
Example 3:

Input: nums = [3,4,3,3], k = 2
Output: [3,4]
Explanation:
The subsequence has the largest sum of 3 + 4 = 7. 
Another possible subsequence is [4, 3].
 

Constraints:

1 <= nums.length <= 1000
-105 <= nums[i] <= 105
1 <= k <= nums.length
 * 
 * 
 * 
 * 
 */