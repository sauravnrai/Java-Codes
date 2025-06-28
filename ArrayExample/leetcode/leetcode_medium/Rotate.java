
public class Rotate {

    public void rotate(int[] nums, int k) {

        int len = nums.length;
        int left;
        int right;
        int temp;
        
        /*If the size of the k is greater than size of the array, the code without this line would throw 
        array index out of bound for the reversing the elements from 0 to k-1 and 1 to k

        If k is greater than n, then final result would lie in 0 to n shift operations
        hence, we do k % n where n is size of the array

        An example is given at the end of the program
        */
        if(k > len) k = k % len;

        
        // inverts the entire array
        left = 0;
        right = len - 1;
        while(len > 1 && left < right){
            temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;

            left++;
            right--;
            
        }

        // invert the first k elements
        left = 0;
        right = k-1;
        while(len > 1 && left < right){
            temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;

            left++;
            right--;
            
        }

    // invert the remaining elements after of the array
    left = k;
    right = len - 1;
     while(len > 1 && left < right){
            temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;

            left++;
            right--;
            
        }

        
    }
    
}

/*

Solution

The proposed solution uses the same loop three times, the loop is same but uses different values of variables
We can write a seperate method and make look more concise, but for understanding purpose the solution has used
same while thrice in the method

If necessary we can use a single method, but it is better to understand the program execution


 * The initial intution was to use an ArrayList or a Linked List to do this problem
 * but the perforance of these collection will exceed time
 * 
 * We are given k steps or the value of k to rotate array
 * 
 * We will first invert the entire array
 * We will then invert the first k elements of the array
 * We will at last invert all the reamining elements of the array
 * 
 * The resulting array would be our result. We will use two pointers to solve this
 * 
 * There is one edge case that is k being more than the size
 * In that case, we can take k as k % n
 * Why, because reverse will work till first n length but after that will start giving array index out of bound exception
 * 
 * example
 * Array is 1, 2 and k is 3
 * for k = 1, array will be 2, 1
 * for k = 2, array will be 1, 2
 * for k = 3, array will be again 2, 1
 * So, we are literally running in circles when k becomes larger than the size of the array
 * We will encounter the same reverse at the end which we might have seen, so we use k % n to get the final correct array
 * 
 * 
 */

/*
 * Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.

 

Example 1:

Input: nums = [1,2,3,4,5,6,7], k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]
Example 2:

Input: nums = [-1,-100,3,99], k = 2
Output: [3,99,-1,-100]
Explanation: 
rotate 1 steps to the right: [99,-1,-100,3]
rotate 2 steps to the right: [3,99,-1,-100]
 
 * 
 * 
 * 
 * 
 */