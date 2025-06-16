public class TwoSum2 {

public int[] twoSum(int[] numbers, int target) {

        int[] ans = new int[2]; // create a new array of size 2

        int left = 0; // left pointer starts at 0
        int right = numbers.length - 1; // right pointer starts at last index

        while(left < right){
          
            if(numbers[left] + numbers[right] > target){
                right --;
            } else if (numbers[left] + numbers[right] < target){
                left ++;
            }else{
                ans[0] = left + 1; // +1 to the index
                ans[1] = right + 1; // +1 to the index
                break;
            }
        }
        
        return ans;
    }
    
}


/*
Solution to the problem
 *
 * The previous two sum was not sorted but this question is sorted 
 * We are again supposed to find indices of those two elements that give us the target
 * And we are supposed to return index + 1 of these elements
 * The smallest element is always at the left and largest element is always at the right
 * We can use a two pointer approach to solve this problem
 * 
 * The first pointer will be placed at the left
 * The last pointer will be placed at the last
 * We will add elements at these indices
 * 
 * If the sum is less than the target, then move left by left--
 * If the sum is greater than the target, then move right by right--
 * Once we get the exact target, we just store these indices and break out of the loop
 * This is how this problem is solved in O(n) time complexity
 * 
 * The previous two sum approach was using n-square time complexity because of contains() method
 * We could have used a map similar to SubArray Sum equal to K problem.
 * 
 * 
 * 
 * 
 */


/*
 * Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order, find two numbers such that they add up to a specific target number. Let these two numbers be numbers[index1] and numbers[index2] where 1 <= index1 < index2 <= numbers.length.

Return the indices of the two numbers, index1 and index2, added by one as an integer array [index1, index2] of length 2.

The tests are generated such that there is exactly one solution. You may not use the same element twice.

Your solution must use only constant extra space.

 

Example 1:

Input: numbers = [2,7,11,15], target = 9
Output: [1,2]
Explanation: The sum of 2 and 7 is 9. Therefore, index1 = 1, index2 = 2. We return [1, 2].
Example 2:

Input: numbers = [2,3,4], target = 6
Output: [1,3]
Explanation: The sum of 2 and 4 is 6. Therefore index1 = 1, index2 = 3. We return [1, 3].
Example 3:

Input: numbers = [-1,0], target = -1
Output: [1,2]
Explanation: The sum of -1 and 0 is -1. Therefore index1 = 1, index2 = 2. We return [1, 2].
 

Constraints:

2 <= numbers.length <= 3 * 104
-1000 <= numbers[i] <= 1000
numbers is sorted in non-decreasing order.
-1000 <= target <= 1000
The tests are generated such that there is exactly one solution.
 */