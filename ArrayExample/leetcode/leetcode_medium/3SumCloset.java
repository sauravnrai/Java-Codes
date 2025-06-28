public class 3SumCloset {

    public int threeSumClosest(int[] nums, int target) {

        int close = Integer.MAX_VALUE;
        int sum = 0;
        // The close variable will be used to get the difference value
        // Initially, it will have the maxed out value

        if(nums.length < 3) return sum;

        Arrays.sort(nums);
        //Sort the entire array
     
       // left and right pointers so that all elements till last 3rd element is even a fair share to form a triplet
        int left;
        int right;

        for(int i=0; i< nums.length - 2; i++){

            int temp_target = target - nums[i]; // n1 + n2 + n3 = 0, so n1 + n2 = -n3

            left = i + 1; // next element is always starting point
            right = nums.length - 1; // lways starts at end

            // Two sum begins for temp_target but we will never get the equal case
            // We are looking for closest case. so every result will be checked
            while(left < right){

                int temp_sum = nums[left] + nums[right];
                // Calculate the two sum first

                // Check how two sum is meeting the temporary target
                // We may get equal case here but getting equal in not a priority 
                // If we get the target, we will simply return it as distance is 0 from the target itself
                if(temp_sum < temp_target){
                    left++;
                }else if(temp_sum > temp_target){
                    right--;
                }else{
                    left++;
                    right--;

                }
                
                int three_sum = temp_sum + nums[i];
                temp_sum = Math.abs(target - three_sum);
                // Calculates the absolute difference between actual target and 3Sum
                // temp_sum had two sum with 3rd value as - target and now, we store the difference 


                

               if (temp_sum < close) {
                     close = temp_sum;
                     sum = three_sum;
                   }

               
               
               
                // stores the closest difference in close
               // Assigns sum as new three_sum
               // We will check if the previous numbers was close or far with respect to new number

            }

        }



        return sum;
        
    }


    
}


/*
 * In the previous sum, it was n1 + n2 + n3 = 0
 * But now, we have n1 + n2 + n3 = target
 * So, we will use the previous but n1 + n2 = target - n3
 * 
 * We are not interested in finding the triplet
 * We are rahter intrested in finding the sum closest to the target
 * We have to use absolute difference
 * 
 * We will use the same 3Sum approach with minor twerks in the solution
 * We will maintain difference and sum variables
 * difference is maxed out initially so that we could record the closed sum that could get us the target
 * The overall time complexity of the solution is n-square
 * 
 * 
 * 
 * 
 */



/*
 * Given an integer array nums of length n and an integer target, find three integers in nums such that the sum is closest to target.

Return the sum of the three integers.

You may assume that each input would have exactly one solution.

 

Example 1:

Input: nums = [-1,2,1,-4], target = 1
Output: 2
Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
Example 2:

Input: nums = [0,0,0], target = 1
Output: 0
Explanation: The sum that is closest to the target is 0. (0 + 0 + 0 = 0).
 

Constraints:

3 <= nums.length <= 500
-1000 <= nums[i] <= 1000
-104 <= target <= 104
 */