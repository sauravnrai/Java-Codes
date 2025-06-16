public class UniquePath {

     public int uniquePaths(int m, int n) {

        int[][] dp = new int[m][n];
        // m is the row and n is the column

        dp[m-1][n-1] = 1; // last index which is target index will always be 1

        for(int i = m-1; i >= 0; i--){
            for(int j = n-1; j >= 0; j--){

                int right = 0;
                int down = 0;

                if(i + 1 < m) down = dp[i + 1][j];
                if(j + 1 < n) right = dp[i][j + 1];
               
               dp[i][j] = Math.max(1, right + down);

            }
        }
        
        return dp[0][0];
    }
    
}


/*
 * Solution behind the problem
 * 
 * We will create a dp array of 2d with sixe m x n where m is row and n is column
 * The target is m-1 and n-1 index, and we need to start from 0, 0
 * At all the cells we can either place 1 be default
 * We either move right or down but it is only possible if
 * current row allows us and it is less than m 
 * current columns allows us and it is less than n
 * The sum of right and down will give the answer for that number of ways from that cell to reach last m-1 and n-1 index
 * The answes at 0, 0 will be the final answes
 * 
 * 
 * 
 */



/*
There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.

Given the two integers m and n, return the number of possible unique paths that the robot can take to reach the bottom-right corner.

The test cases are generated so that the answer will be less than or equal to 2 * 109.
 * 
 * Example 1:
 * Input: m = 3, n = 7
Output: 28
Example 2:

Input: m = 3, n = 2
Output: 3
Explanation: From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
1. Right -> Down -> Down
2. Down -> Down -> Right
3. Down -> Right -> Down
 

Constraints:

1 <= m, n <= 100
 * 
 */
