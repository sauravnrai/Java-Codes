import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DisappearNums {


     public List<Integer> findDisappearedNumbers(int[] nums) {

     List<Integer> ans = new ArrayList<>();

     int[] map = new int[nums.length + 1];
     // Array will have 0 to n, so we will use length + 1
     // We will parse the array from index 1

     Arrays.fill(map, 0);
  
  // Marks or stores all numbers in map via index
     for(int item: nums){
         map[item] = 1;
     }
  
  // Adds all missing number in the list
  // We will parse from 1 because list has range from 1 to n
    for(int i=1; i<map.length; i++){
          if(map[i] == 0) ans.add(i);
    }

     return ans;
        
    }
    
}



/*
 * Given an array nums of n integers where nums[i] is in the range [1, n], return an array of all the integers in the range [1, n] that do not appear in nums.

 

Example 1:

Input: nums = [4,3,2,7,8,2,3,1]
Output: [5,6]
Example 2:

Input: nums = [1,1]
Output: [2]
 

Constraints:

n == nums.length
1 <= n <= 105
1 <= nums[i] <= n
 * 
 * 
 */