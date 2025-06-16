public class LC1266 {


  public int minTimeToVisitAllPoints(int[][] points) {

        int time = 0;
        int size = points.length;

        // This two will keep track of previous points that were used
        // In short, they will store previous points to calculate time
        int pointer1 = points[0][0]; 
        int pointer2 = points[0][1];
        // Since we need to find difference between next and present, we will store first coordinate in them and start from index 1

        // The approach is simple and requires absolute difference between the points
        // x coordinates difference stored in one variable
        // y coordinates difference stored in another variable
        // The time for between these two points will be maximum of x and y difference
        for(int i=1; i< size; i++){

            int diff1 = Math.abs(pointer1 - points[i][0]); // x difference
            int diff2 = Math.abs(pointer2 - points[i][1]); // y difference

            time = time + Math.max(diff1, diff2); // tracks time
        
        // Stores previous points
            pointer1 = points[i][0];
            pointer2 = points[i][1];

        }


        return time;
        
    }


    
}

/*
 * 
 * On a 2D plane, there are n points with integer coordinates points[i] = [xi, yi]. Return the minimum time in seconds to visit all the points in the order given by points.

You can move according to these rules:

In 1 second, you can either:
move vertically by one unit,
move horizontally by one unit, or
move diagonally sqrt(2) units (in other words, move one unit vertically then one unit horizontally in 1 second).
You have to visit the points in the same order as they appear in the array.
You are allowed to pass through points that appear later in the order, but these do not count as visits.
 
 * 
 Example 1
Input: points = [[1,1],[3,4],[-1,0]]
Output: 7
Explanation: One optimal path is [1,1] -> [2,2] -> [3,3] -> [3,4] -> [2,3] -> [1,2] -> [0,1] -> [-1,0]   
Time from [1,1] to [3,4] = 3 seconds 
Time from [3,4] to [-1,0] = 4 seconds
Total time = 7 seconds


Example 2:

Input: points = [[3,2],[-2,2]]
Output: 5
 * 
 */