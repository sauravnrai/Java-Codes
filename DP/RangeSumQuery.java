public class RangeSumQuery {

    int[] prefix = null; // global variable since the functions are immutable

    public NumArray(int[] nums) {
        
        prefix = new int[nums.length + 1];
        // We will store from index 0 to nums.length + 1
        // Index 0 will always have sum 0
        // The new sum at any index will be current element + previous sum

        prefix[0] = 0;
        int i = 1;
        for(int item: nums){
           prefix[i] = prefix[i - 1] + item; // creates prefix sum
           i++;
        }


    }
    
    public int sumRange(int left, int right) {
        
        if(left == 0){
        return prefix[right + 1];
        } else{
            int temp_sum = prefix[left]; // since index is not starting from 0
            return prefix[right + 1] - temp_sum;
        }
    }
}

/*
 * Solution to the problem
 * 
 * We are already given two methods and we cannot make changes to them as per question
 * We have a nums array and we will be given two indices to find the sum between them
 * 
 * Since, we cannot make changes to the code, we will use a global array prefix for prefix sum
 * since we are using previously computed answers, this is a dp problem
 * 
 * We will calculate prefix sum of each element from index 0 to that index
 * We will start from nums.length + 1 prefix array
 * The first index i.e i = 0 in prefix array at 0, will contain sum 0
 * The second index i.e i = 1 in prefix array will contain 0 + nums[0] element
 * 
 * So to find the prefix sum from range 0 to x, we will use prefix sum's x+ 1 index
 * 
 * But left range can be from any custom index other than 0
 * In that case we will subtract that custom index sum from x + 1 index sum
 * for example 2 to 5
 * We already have 0 to 5 sum
 * We will subtract 0 to 2 sum from 5 sum to return the answer
 * The index 5 sum will be stored at 6th index i.e 6 in the prefix sum
 * So, we return prefix[5 + 1] - prefix[2]
 * We are not using prefix[3] instead of prefix[2] because we need to remove first two elements not 3 elements
 * 
 * 
 * 
 */


/*
 * Given an integer array nums, handle multiple queries of the following type:

Calculate the sum of the elements of nums between indices left and right inclusive where left <= right.
Implement the NumArray class:

NumArray(int[] nums) Initializes the object with the integer array nums.
int sumRange(int left, int right) Returns the sum of the elements of nums between indices left and right inclusive (i.e. nums[left] + nums[left + 1] + ... + nums[right]).
 

Example 1:

Input
["NumArray", "sumRange", "sumRange", "sumRange"]
[[[-2, 0, 3, -5, 2, -1]], [0, 2], [2, 5], [0, 5]]
Output
[null, 1, -1, -3]

Explanation
NumArray numArray = new NumArray([-2, 0, 3, -5, 2, -1]);
numArray.sumRange(0, 2); // return (-2) + 0 + 3 = 1
numArray.sumRange(2, 5); // return 3 + (-5) + 2 + (-1) = -1
numArray.sumRange(0, 5); // return (-2) + 0 + 3 + (-5) + 2 + (-1) = -3
 

Constraints:

1 <= nums.length <= 104
-105 <= nums[i] <= 105
0 <= left <= right < nums.length
At most 104 calls will be made to sumRange.
 * 
 * 
 * 
 */