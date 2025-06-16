import java.util.ArrayList;
import java.util.List;

public class Spiral {

     public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> ans = new ArrayList<>();
        // The list to store all values

      // If we look closely, everytime a row is done, it is never used
      // If we look closely everytime a column is donw, it is never used
      // The matrix shrinks from top, bottom, left and right everytime a row or column is processed
      // From left to right and top to bottom, we have to maintain four variables
      int row_top = 0;
      int row_bottom = matrix.length - 1; // m is the number of rows
      int column_left = 0;
      int column_right = matrix[0].length - 1; // n is the number of columns

      // Every sprial is left to right, top to bottom, right to left, and bottom to top and then we do the same
      // But top never crosses bottom and left never crosses top

      while(row_top <= row_bottom && column_left <= column_right){
        
        // left to right
        for(int i = column_left; i <= column_right; i++) ans.add(matrix[row_top][i]);

        row_top++; // previous row was completed and now, we fix right column and will use top to bottom

        // top to bottom
        for(int i = row_top; i <= row_bottom; i++) ans.add(matrix[i][column_right]);

        column_right--; // since entire previous column was printed from rigth, we shift it

        // right to left
        if(row_top <= row_bottom){
            for(int i=column_right; i>= column_left; i--) ans.add(matrix[row_bottom][i]);
        }
        row_bottom--; // Previous row was printed, so fix row_bottom

        // bottom to top
        if(column_left <= column_right){
           for(int i = row_bottom; i>= row_top; i--) ans.add(matrix[i][column_left]);
        }
        
        column_left ++; // since previous entire column was printed 



      }


        return ans;
        
    }
    
}


/*
 * To solve this problem we need 4 elements and a while loop
 * 
 * 
 * 
 * row begin, row end, column begin, column end
 * row begin <= row end && column begin <= column end condition in while loop
 * 
 * Inside while loop we need four for loops
 * 
 * Traverse left to right: column begin is updated by each iteration and after successful iteration row begin updated
 * column begin++ and it should be less than and equal to column end
 * after iteration, row begin ++
 * 
 * Traverse top to bottom: row begin is updated each iteration and column end after successful iteration
 * row begin ++ and it should be less than equal to row end
 * after iteration, column end --
 * 
 * Traverse right to left
 * We first check row begin less than equal to row end
 * column end to greater than equal to column begin, column end --
 * row end -- after the iteration
 * 
 * Traverse bottom to top
 * column begin less than equal to column end
 * row end -- and greater tha equal to row begin
 * column begin ++ after iteration
 * 
 * end of while loop
 * 
 * The above looping mechanism will print matrix in sprial, we can use a list to store all these values and return
 * 
 */


/*
 * Given an m x n matrix, return all elements of the matrix in spiral order.
 * 
 * Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,2,3,6,9,8,7,4,5]

Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 

Constraints:

m == matrix.length
n == matrix[i].length
1 <= m, n <= 10
-100 <= matrix[i][j] <= 100
 * 
 * 
 * 
 */