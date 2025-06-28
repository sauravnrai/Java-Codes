public class Number_Island {

   public int numIslands(char[][] grid) {

        int row = grid.length;
        int column = grid[0].length;
        int count = 0;
        
        for(int i=0; i<row; i++){
            for(int j=0; j<column; j++){
                    if(grid[i][j] == '1'){
                        DFS(grid, i, j, row, column);
                        count++;
                    }
            }
        }
  

        return count;
        
       }

       public static void DFS(char[][] grid, int i, int j, int row, int column){
        
        // If we hit any of the edges cases then we return
        if(i < 0 || i >= row || j < 0 || j >= column || grid[i][j] == '0') return;

        grid[i][j] = '0'; //marks the cell as visited

        DFS(grid, i, j - 1, row, column); // moves left
        DFS(grid, i, j + 1, row, column); // moves right
        DFS(grid, i - 1, j, row, column ); // moves up
        DFS(grid, i + 1, j, row, column); // moves down


       }

    
}

/*
Solution of the problem
 * 
We can use DFS and BFS

We will use recursion i.e DFS

From any cell that has 1, we can either move in four directions
Up, down, left, and right
We need to understand that all these cases can get us out of bound 
We can either encounter 0 i.e water when we move to any direction

so when we hit any of these cases, we will return and increment the count of islands

These conditions are not supposed to be evaluated under any circumstance, as they throw index out of bound error

We will two loops, one for row and another for column, so time complexity will be big-O of n x m
 * 
 When we visit a cell, we will turn it to 0 marking it as visited and not coming back to it
 When a single cell of 1 is occupied by 1's from all direction, it will return
 * 

Why || is used:
This line is a guard clause that checks if any one of the invalid conditions is true. If even one is true, we should stop the recursion.

Let’s break down each condition:

i < 0 — row index is above the grid (invalid)

i >= row — row index is beyond the last row (invalid)

j < 0 — column index is left of the grid (invalid)

j >= column — column index is beyond the last column (invalid)

grid[i][j] == '0' — the cell is water or already visited (invalid)



If you used && instead:

This condition will only return true if all conditions are true at the same time, which is impossible:

i can’t be both less than 0 and greater than or equal to row simultaneously.

So this version would almost never return, allowing the DFS to proceed into invalid positions, which could lead to:

ArrayIndexOutOfBoundsException

Incorrect marking

Infinite recursion

So in simple terms
You want to stop (return) if you’re off the grid OR on water.
So you use OR (||) to catch any of those bad cases.
 */



/*
 * Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.

An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

 

Example 1:

Input: grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
Output: 1
Example 2:

Input: grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
Output: 3
 

Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 300
grid[i][j] is '0' or '1'.
 */