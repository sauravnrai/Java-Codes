public class LongestMountain {

    public int longestMountain(int[] arr) {
    // A mountain must be at least 3 elements long
    if (arr.length < 3) return 0;

    int maxLength = 0;
    int i = 1;
  
    // First and last elements cannot be peaks, so we are starting from index 1 to second last index
    while (i < arr.length - 1) {

        // Check if current element is a peak
        if (arr[i - 1] < arr[i] && arr[i] > arr[i + 1]) {
            int left = i - 1; // to check left
            int right = i + 1; // to check right

            // Move left pointer back while elements are increasing
            while (left > 0 && arr[left - 1] < arr[left]) {
                left--;
            }

            // Move right pointer forward while elements are decreasing
            while (right < arr.length - 1 && arr[right] > arr[right + 1]) {
                right++;
            }

            // Calculate current mountain length
            int currentLength = right - left + 1; // includes peak
            maxLength = Math.max(maxLength, currentLength);

            // Skip to the end of this mountain for next iteration or in short next element
            i = right;
            // If the peak conditions were satisfied then we will start again from next element
        } else {
            // Not a peak, move to next element
            i++;
        }
    }

    return maxLength;
}
    
}

/*
Solution to the problem

arr.length >= 3
There exists some index i (0-indexed) with 0 < i < arr.length - 1 such that:
arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
arr[i] > arr[i + 1] > ... > arr[arr.length - 1]

This method finds the length of the longest mountain in the array.
 * 
 * Definition of a mountain:
 * - At least 3 elements long
 * - Strictly increasing sequence followed by a strictly decreasing sequence
 * 
 * Approach:
 * 1. Iterate through the array from the second to the second last element.
 * 2. Check if the current element is a peak (greater than neighbors).
 * 3. If it is a peak:
 *    - Expand leftwards while elements keep increasing strictly.
 *    - Expand rightwards while elements keep decreasing strictly.
 *    - Calculate the length of this mountain (right - left + 1).
 *    - Update maxLength if this mountain is longer.
 * 4. Move the main index to the end of the current mountain to avoid reprocessing elements.
 * 5. Return the maximum mountain length found.
 * 
 * Time Complexity:
 * - Although it looks like nested loops, each element is visited at most twice 
 *   by the left and right expansions combined.
 * - The main pointer skips over processed mountains, so total time is O(n).
 * 
 * Space Complexity:
 * - Only uses a few variables, no extra data structures proportional to input size.
 * - Space complexity is O(1).
 * 
 * This method efficiently finds the longest mountain peak in linear time without
 * the need for multiple passes or extra storage.

 */

/*
 * You may recall that an array arr is a mountain array if and only if:

arr.length >= 3
There exists some index i (0-indexed) with 0 < i < arr.length - 1 such that:
arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
Given an integer array arr, return the length of the longest subarray, which is a mountain. Return 0 if there is no mountain subarray.

 

Example 1:

Input: arr = [2,1,4,7,3,2,5]
Output: 5
Explanation: The largest mountain is [1,4,7,3,2] which has length 5.
Example 2:

Input: arr = [2,2,2]
Output: 0
Explanation: There is no mountain.
 

Constraints:

1 <= arr.length <= 104
0 <= arr[i] <= 104
 

Follow up:

Can you solve it using only one pass?
Can you solve it in O(1) space?
 * 
 * 
 * 
 * 
 */