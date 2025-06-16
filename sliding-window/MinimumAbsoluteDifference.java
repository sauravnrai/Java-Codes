import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumAbsoluteDifference {

    public List<List<Integer>> minimumAbsDifference(int[] arr) {

        List<List<Integer> > ls = new ArrayList<>();
       
       // sort the array
        Arrays.sort(arr);


        int diff = Integer.MAX_VALUE;
        int left;
        int right;
    
    // Find the minimum difference through out the array first
        for(int i=0; i< arr.length - 1; i++){
          left = arr[i];
          right = arr[i+1];
      
      // find the lowest difference thorugh out the array 
          if(Math.abs(left - right) < diff) diff = Math.abs(left - right);
           
        }
    
    // Now, add the pair of elements that have this difference
       for(int i=0; i<arr.length - 1; i++){
        left = arr[i];
        right = arr[i + 1];

        if(diff == Math.abs(left - right)){
            List<Integer> temp = new ArrayList<>();
            temp.add(left);
            temp.add(right);
            ls.add(temp); // adds the pair to the list

        }

       }


      return ls; // returns the list
    }
    
}

/*
 * We need to find the pair of those elements that have the minimum difference between them
 * We will first find that minimum difference throught out the array
 * We will sort the array and then use every two elements to find the difference
 * The lowest difference found through out this array will be our base difference
 * 
 * Now, we will run another loop to find these pairs such that their difference is equal to the difference
 * We will add these pairs in the list of list
 * We will return the list of list in the end
 * 
 * We are using a sliding window approach since we are taking every two pairs of elements in ascending order
 * 
 * 
 * 
 */


/*
 * Given an array of distinct integers arr, find all pairs of elements with the minimum absolute difference of any two elements.

Return a list of pairs in ascending order(with respect to pairs), each pair [a, b] follows

a, b are from arr
a < b
b - a equals to the minimum absolute difference of any two elements in arr
 

Example 1:

Input: arr = [4,2,1,3]
Output: [[1,2],[2,3],[3,4]]
Explanation: The minimum absolute difference is 1. List all pairs with difference equal to 1 in ascending order.
Example 2:

Input: arr = [1,3,6,10,15]
Output: [[1,3]]
Example 3:

Input: arr = [3,8,-10,23,19,-4,-14,27]
Output: [[-14,-10],[19,23],[23,27]]
 

Constraints:

2 <= arr.length <= 105
-106 <= arr[i] <= 106
 * 
 * 
 * 
 * 
 */