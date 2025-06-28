public class 3Sum {

     public List<List<Integer>> threeSum(int[] nums) {


        Arrays.sort(nums); // sort the array first to solve the problem

        Set<List<Integer>> ans = new HashSet<>();
        // We are using a set because the result will contain duplicates
        // Hence we will add the new arraylist in the set and in the end return an arraylist

        if(nums == null || nums.length < 3) return new ArrayList<>(); // return an empty list

        int left; // left pointer
        int right; // right pointer

// We can only find three sum till the last third index as last two indices are needed to find the triplet
     for(int i = 0; i< nums.length - 2; i++){

            // Two sum solution
            // For every element, we will find its two sum in the remaining array to the right of it
            //every element will be treated as target

            int target = - nums[i]; // n1 + n2 = - n3 because n1 + n2 + n3 = 0
            left = i + 1; // next index after target
            right = nums.length - 1; // Last index of the array


            while(left < right){
                
                // finds those two elements
                if(nums[left] + nums[right] < target){
                    left++;
                }else if(nums[left] + nums[right] > target){
                    right--;
                }else{

                    // found those two elements for the target

                    List<Integer> temp = new ArrayList<Integer>(); // Triplet array
                    temp.add(nums[i]);
                    temp.add(nums[left]);
                    temp.add(nums[right]);

                    ans.add(temp); // Adds the triplet to the final solution


                  // Update the pointers
                    left++;
                    right--;

                } 
                // Found those two elements and triplet was found using those two elements and target


            }


        }
      

        return new ArrayList<>(ans); // converts the set to an List using constructor
        
    }
    
}



/*
 * Solutio to the problem
 * 
 * We are supposed to return a triplet whose sum is equal to 0
 * The triplets must contain elements from unique indices.
 * No index is repeated, Same element may occur as elements can be duplicate
 * The triplet contains elements but not indices
 * n1 + n2 + n3  = 0
 * 
 * It is all about how we look at this problem
 * We can re-write this as n1 + n2 = -n3
 * n1 and n2 are elements that give a sum of -n3, this is 2-sum now
 * But there are couple of extra things to remember
 * 
 * 1) Does your array contain duplicates
 * 2) Is your array sorted
 * 3) What will be your n1, n2 ad n3 as they will change
 * 
 * 
 * Answers
 * 1) Yes array does contain duplicate elements
 * 2) No array is not sorted. We can sort it to make our life easy
 * 3) We have to decide every element as -n3 and thus we will find its elements in array after n3 index
 * 
 * Consider this example
 * 
 * [-1, 0, 1, 2, -1, -4, 0, 2]
 * 
 * After sorting
 * [-4, -1, -1, 0, 0, 1, 2, 2]
 * 
 * Every elemet will be treated as target
 * For -4, target becomes -(-4) = 4
 * We get 4, 2, 2
 * We will apply 2-sum from -1, -1, 0, 0, 1, 2, 2
 * 
 * For -1, target becomes -(-1) = 1
 * We get -1, 0, 1
 * We will apply 2-sum from -1, 0, 0, 1, 2, 2
 * 
 * For -1, target becomes -(-1) = 1
 * We get -1, 0, 1
 * We will apply 2-sum from 0, 0, 1, 2, 2
 * But this triplet was already there
 * Hence, we use a SET collection in java to ignore duplicates
 * 
 * We will continue till last 3rd element as last two elements are need for a triplet
 * Therefore the loop is running from index 0 to length - 2
 * 
 * In the end, we send the set converted to an arraylist as the solution
 * 
 * 
 */

/*
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.

 

Example 1:

Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Explanation: 
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
The distinct triplets are [-1,0,1] and [-1,-1,2].
Notice that the order of the output and the order of the triplets does not matter.
Example 2:

Input: nums = [0,1,1]
Output: []
Explanation: The only possible triplet does not sum up to 0.
Example 3:

Input: nums = [0,0,0]
Output: [[0,0,0]]
Explanation: The only possible triplet sums up to 0.
 

Constraints:

3 <= nums.length <= 3000
-105 <= nums[i] <= 105
 */