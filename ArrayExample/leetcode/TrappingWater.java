public class TrappingWater {

    public int trap(int[] height) {

        int size = height.length;

        int[] left = new int[size]; // Tracks left highest buidling
        int[] right = new int[size]; // Tracks right highest building
        int max; // used for calculating the maximum height
        int water = 0;
        
        // Left building
        max = height[0];
        left[0] = max; // for the first value, left highest building is itself
        for(int i=1; i < size; i++){

            if(max < height[i]){
                max = height[i];
            }

            left[i] = max;
        }


        // Right building
        max = height[size - 1];
        right[size - 1] = max; // For the last element, highest buidling is itself
        for(int i = size - 2;  i>=0; i--){
           
           if(max < height[i]){
            max = height[i];
           }

           right[i] = max;
        }
      
      // Calculates water
      for(int i=0; i<size; i++){
         water = water + (Math.min(left[i], right[i]) - height[i]);
         // Min will give the max water that can be trapped and subtracting height gives exact water at that index
      }

        
        return water;
    }
    
}

/*
 * Solution to the problem
 * To trap water, we need a strcutrue that has some space in center with solid walls to its left and right
 * We can contain water in this structure
 * But the ground or level from which water may get store will also depend
 * 
 * For example [4, 0, 6]
 * Here, I have wall of size 4 and size 6 to left and right of 0
 * So, we can trap a max water os size 4
 * Minimun of 4 and 6 and result is again subtracted by 0
 * 
 * For exmaple [4, 2, 6]
 * We will trap 2 units of water because 4 is the minimum height that supports this
 * So, Min(4, 6) - 2 = 4 - 2 = 2
 * 
 * But we can have an array [0, 4, 5, 6, 7, 9, 2]
 * For each cell, we have to find left and right maximum height
 * Then we can compute the result as a sum on whole
 * 
 * 
 * 
 * 
 */



/*
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.

 Example 1

 Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
 * 
 
 Example 2:

Input: height = [4,2,0,3,2,5]
Output: 9
 

Constraints:

n == height.length
1 <= n <= 2 * 104
0 <= height[i] <= 105
 * 
 * 
 */