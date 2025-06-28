import java.util.Arrays;
import java.util.Comparator;

public class MergeInterval {

    public int[][] merge(int[][] intervals) {

        if(intervals.length == 1) return intervals;

        //sort the array based on the starting point of each interval
        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));

        int rows;
        int size = intervals.length;
       int[][] temp = new int[size][2];

       temp[0][0] = intervals[0][0];
       temp[0][1] = intervals[0][1];
       rows = 1;
       // The first row is added by default

       for(int i=1; i<size; i++){
        int pointer = intervals[i][0];

        if(temp[rows - 1][0] <= pointer && temp[rows - 1][1] >= pointer){
            temp[rows - 1][1] = Math.max(intervals[i][1], temp[rows - 1][1]);
            // current interval is updated
        }else{
            // new interval is added
            rows++;
            temp[rows - 1][0] = intervals[i][0];
            temp[rows - 1][1] = intervals[i][1];
        }
  
       }

       int[][] final_array = new int[rows][2];

       for(int i=0; i<rows; i++){
        final_array[i][0] = temp[i][0];
        final_array[i][1] = temp[i][1];
       }   

       return final_array;   
    }
    
}



/* Solution for the problem
 * 
 * The merge interval may look like a simple problem but it isn't 
 * The brute force takes n-square time complexity and still accurate result is not guaranteed
 * For example [1, 2] [2, 4], we will get [1, 4]
 * [1, 2] [0, 5], we will get [0, 5]
 * [0, 5] [-1, 6] we will get [-1, 6]
 * So, this is a tricky question when we have to check how to merge the intervals
 * Yes, one thing is for sure, if we see another intervals first element in our current then we can include and extend the current interval
 * Otherwise, we have to start a new interval
 * 
 * To make life easier, it is better to sort this intervals using Arrays.sort which uses
 * Comparator.comparingInt(i->i[0]) i->i[0] shows sorting based on first element of the row
 * sorting take n log n time
 * 
 * When intervals are sorted, we can start from index 1 because index 0 is added by default
 * This will take place in O(n) time
 * so overall time complexity is O(n log n)
 * 
 * One thing to see is the condition
 * We need to pick lowest of both intervals if the condition for merging is satisfied
 * 
 * 
 * 
 * 
 * 
 */



 /*
  * Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.

 

Example 1:

Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
Example 2:

Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 

Constraints:

1 <= intervals.length <= 104
intervals[i].length == 2
0 <= starti <= endi <= 104

  */