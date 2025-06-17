import java.util.PriorityQueue;

public class K_Closest_Point {

    public int[][] kClosest(int[][] points, int k) {

        // We need a priority queue
        // We need a max heap
        PriorityQueue<int []> pq = new PriorityQueue<int []>((a,b) -> (+ b[0]*b[0] + b[1]*b[1] - a[0]*a[0] - a[1]*a[1]) );
        // We need to write the comparator propely to give accurate answer
        // The comparator represents the distance of point b from origin - distance of point a from origin
        // Please note that we are not using square root because it will add more complex calculation, we are using only mutliplication as final answer won't be altered if roots are not found


        // We will add all these 1D arrays to the priority queue
        for(int[] pt : points ){

            pq.offer(pt); // adds the array based on their distances

            // if priortiy queue size becomes larger than k, then the 1 D array whose distance is larger is thrown out
            if(pq.size() > k) pq.poll();

        }

        int[][] res = new int[pq.size()][2]; // result to be returned after the 

        int count = 0; // we will start from index 0
        
        // loop to add pq elements in the 2D array by emptying pq
       while(! pq.isEmpty() ){
        res[count] = pq.poll(); // adds the 1D array in pq to the result array
        count++; // increments count
       }

        return res;
        
    }
    
}

/*
 * Solution to the problem
 * 
 * 
This solution finds the K closest points to the origin (0, 0) from a list of 2D coordinates.

To solve this efficiently, we use a max heap (priority queue) to keep track of the K closest points.
The heap will store the points with their distances from the origin. Since we want the K smallest distances,
we keep the heap size limited to K elements. That way, at any moment, the heap contains the current best K points.

Here's how the algorithm works step-by-step:

1. We define a custom comparator for the priority queue that compares points based on their distance from the origin.
   Instead of using the actual Euclidean distance (which involves a square root), we use the squared distance:
   distance² = x² + y². This avoids unnecessary square root calculations since the relative order remains the same.

2. We iterate through each point in the input list:
   - For every point, we calculate its squared distance and add it to the priority queue.
   - If the size of the priority queue exceeds K, we remove the point with the largest distance from the heap.
     This ensures the heap always contains only the K closest points encountered so far.

3. After processing all points, the heap contains exactly K points with the smallest distances.

4. We then extract these points from the heap and store them in a 2D result array to return as the final answer.

Time Complexity:
- Each insertion and deletion in the heap takes O(log K) time.
- Since we process N points, the total time complexity is O(N log K), where N is the number of input points.

Space Complexity:
- We use O(K) extra space for the heap to store the closest points.

This is an efficient solution especially when K is much smaller than N.
 * 
 * 
 */



/*
 * Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane and an integer k, return the k closest points to the origin (0, 0).

The distance between two points on the X-Y plane is the Euclidean distance (i.e., √(x1 - x2)2 + (y1 - y2)2).

You may return the answer in any order. The answer is guaranteed to be unique (except for the order that it is in).
 * 
 * 
 * Input: points = [[1,3],[-2,2]], k = 1
Output: [[-2,2]]
Explanation:
The distance between (1, 3) and the origin is sqrt(10).
The distance between (-2, 2) and the origin is sqrt(8).
Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
We only want the closest k = 1 points from the origin, so the answer is just [[-2,2]].
 * 
 * 
 * 
 * Input: points = [[3,3],[5,-1],[-2,4]], k = 2
Output: [[3,3],[-2,4]]
Explanation: The answer [[-2,4],[3,3]] would also be accepted.
 

Constraints:

1 <= k <= points.length <= 104
-104 <= xi, yi <= 104
 * 
 * 
 * 
 * 
 */