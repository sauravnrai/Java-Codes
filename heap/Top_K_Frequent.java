import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Top_K_Frequent {
    
    // MAX HEAP APPROACH
    public int[] topKFrequent(int[] nums, int k) {
      

      Map<Integer, Integer> map = new HashMap<>(); // map to count all of them

      for(int item: nums){
        map.put(item, map.getOrDefault(item, 0) + 1); // keeps the count of each item in the map
        // Please not that we are using item,0 in getOrDefault instead of 0, item
        // If the item is not found, then by default we will add 0 + 1 = 1 as element makes its first entry
        // if element is already present, then we will add +1 to its exisitng frequency
      }

      
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>( (a,b) -> (b[1] - a[1]));
        // max heap that uses an array for storing numbers and their frequencies

        // loop to add all entried of map in queue
           for(Map.Entry<Integer, Integer> entry: map.entrySet()){
              pq.offer(new int[] {entry.getKey(), entry.getValue()} ); // adds the map entry in pq
           }

           //result array
           int[] ans = new int[k];

        // loop to get top k frequent elements
        // since order does not matter, we will add them in any way
        while(k > 0){
            ans[k-1] = pq.poll()[0]; // always gets the top most since we are using max-heap
            k--;

        }

           return ans;
        
    }


    // MIN HEAP APPROACH
    
    // In min heap, we will have two changes
    // 1st change is PriorityQueue<int[]> pq = new PriorityQueue<int[]>( (a,b) -> (a[1] - b[1]));
    /*
     * 2nd change is if condition in this for loop
     * 
       // loop to add all entried of map in queue

           for(Map.Entry<Integer, Integer> entry: map.entrySet()){
              pq.offer(new int[] {entry.getKey(), entry.getValue()} ); // adds the map entry in pq

    // since we are using a min heap, we will delete the least frequency element when size is greater than k
              if(pq.size() > k) pq.poll(); // delete the element that has the least frequency
           }

     */

     public int[] topKFrequent(int[] nums, int k) {
    
      Map<Integer, Integer> map = new HashMap<>(); // map to count all of them

      for(int item: nums){
        map.put(item, map.getOrDefault(item, 0) + 1); // keeps the count of each item in the map
        // Please not that we are using item,0 in getOrDefault instead of 0, item
        // If the item is not found, then by default we will add 0 + 1 = 1 as element makes its first entry
        // if element is already present, then we will add +1 to its exisitng frequency
      }

      
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>( (a,b) -> (a[1] - b[1]));
        // max heap that uses an array for storing numbers and their frequencies

        // loop to add all entried of map in queue
           for(Map.Entry<Integer, Integer> entry: map.entrySet()){
              pq.offer(new int[] {entry.getKey(), entry.getValue()} ); // adds the map entry in pq
              // since we are using a min heap
              if(pq.size() > k) pq.poll(); // delete the element that has the least frequency
           }

           //result array
           int[] ans = new int[k];

        // loop to get top k frequent elements
        // since order does not matter, we will add them in any way
        while(k > 0){
            ans[k-1] = pq.poll()[0]; // always gets the top most since we are using max-heap
            k--;

        }

           return ans;
        
    }

    
}



/*
 * Solution to the problem
 * 
 * We either use a max heap or min heap approach
 * We will first iterate over the array to record all the frequencies and their elements in a hash map
 * We will use a priority queue and this map to get the top k frequenct elements
 * 
 * The implementation may differ wrt to max or min heap
 * 
 * max heap time complexity will be n log n with extra space of n
 * 
 */


/*
 * Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.

 

Example 1:

Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]
Example 2:

Input: nums = [1], k = 1
Output: [1]
 

Constraints:

1 <= nums.length <= 105
-104 <= nums[i] <= 104
k is in the range [1, the number of unique elements in the array].
It is guaranteed that the answer is unique.
 
 * 
 * 
 * 
 * 
 * 
 */