import java.util.PriorityQueue;

public class K_largest {

    public int findKthLargest(int[] nums, int k) {

      PriorityQueue<Integer> pq = new PriorityQueue<>(k); // sets the initial size as k

        for(int item: nums){
            pq.offer(item); // adds element in the queue

            if(pq.size() > k){
                pq.poll(); // remove or pop element from the queue
            }
        }

        return pq.peek(); // returns the top or forward most element
        
        
    }
    
}



/*
  Solution for the problem
 * 
 * For kth largest, make an max heap using a priority queue of size K or solve it using the quick select algorithm
 * 
 * To find the first or 2nd largest, we can do it using a single loop and two variables
 * But to find third and next largest, we can use this approach
 * We want to solve this problem without sorting
 *
 * Please note that duplicate values are also added since duplicates are allowed.
 * 
 * Both priority queue or max heap and quick select can be used to find the kth largest element
 * We will use priority queue solution to solve this problem
 * 
 */



 /* Priority queue solution
  * 



  */


  /* Quick select solution
   * 
   * 
   * 
   */



/*
 * 
 * Given an integer array nums and an integer k, return the kth largest element in the array.

Note that it is the kth largest element in the sorted order, not the kth distinct element.

Can you solve it without sorting?

 

Example 1:

Input: nums = [3,2,1,5,6,4], k = 2
Output: 5
Example 2:

Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
Output: 4
 
 * 
 * 
 * 
 * 
 * 
 * 
 */