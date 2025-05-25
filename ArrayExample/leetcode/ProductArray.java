

public class ProductArray {

     public int[] productExceptSelf(int[] nums) {
        
        int len = nums.length;
        int[] left = new int[len];
        int[] right = new int[len];
        int holder = 1;
        
        // loop to find left product of each element using nums array
        for(int i=0; i<len; i++){
           
           left[i] = holder;
           holder = holder * nums[i];
        }

        holder = 1;

        // loop to find right product of each element using nums array
        for(int i=len-1; i>= 0; i--){
            right[i] = holder;
            holder = holder * nums[i];
        }

      // loop to find the result
        for(int i=0; i<len; i++){
            nums[i] = left[i] * right[i];
        }

        return nums;
    }
    
}


/*
The initial thinking to solve the problem was to find prodcut of all elements and then divide that element
This would work great for all those integers that don't occupy 32 bits integer
If the product of all terms exceeds more than 32 bits, then it would be a problem

Similary, for arrays containing 0 is also an edge case where 0 can't be used to divide

Let us say array is 1 2 0 3 4

The product array would be 0 0 24 0 0

The reason is we are using 0 for other elements but when its 0's turn, we aren't using it

If we look at 0's position, 24 can be achieved by multiplying all the elements to the left of it and right of it

We can maintain two extra arrays to calculate left prodcut and right product for each element

We can use these two arrays to find the product for that index
 * 
 * The proposed solution uses two extra arrays to find the solution
 * 
 * 
 */

/*
 * Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

You must write an algorithm that runs in O(n) time and without using the division operation.

 

Example 1:

Input: nums = [1,2,3,4]
Output: [24,12,8,6]
Example 2:

Input: nums = [-1,1,0,-3,3]
Output: [0,0,9,0,0]
 
 */