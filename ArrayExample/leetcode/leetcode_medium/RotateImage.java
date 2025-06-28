public class RotateImage {


     public void rotate(int[][] matrix) {

        int size = matrix.length; // grts the size
        
        // finds the transpose of a matrix
        for(int i=0; i<size; i++){
            for(int j=i; j<size; j++){

                int temp; // temporary variable

                if(i != j){
                    temp = matrix[i][j]; // gets element from current row
                    matrix[i][j] = matrix[j][i]; // replace it with diagonal element
                    matrix[j][i] = temp; // diagonal element got replaced
                }
            }
        }
        
        // Reverse columns so we travel till half length of the array
        for(int j=0; j < size / 2; j++){
            for(int i=0; i<size; i++){
                
                int left = j; // to catch the current column from left
                int right = size - (j + 1); // to catch the equal column for left from right

                // The reversal of columns from top to bottom
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;

            }

        }




    }


    
}


/*
 * To solve this problem, we have to rotate the array by 90 degrees
 * We can do that it two steps
 * 
 * 1) Transpose of a matrix i.e rows becomes column but result will always have same diagonal
 * We can do it by swapping elements above and below the diagonals
 * A[i][j] = A[j][i] where i is not equal to j
 *  
 * 2) Reverse the array by column i.e 1st column and last column are swapped
 * We will use two pointers because at any current column, we have to swap it with its equi-distant column from right
 * The left will start from 0 and rigth from length - 1
 * As we proceed, left will be at 1 and rigth will be at length - 2
 * 
 * The resulting array will give us array 90 degrees rotated
 * 
 * We could have used an extra space, but we want in-place i.e no extra space and within array computations
 * 
 * 
 */



/*
 * You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).

You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.
 * 
 * Example 1:
 * Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [[7,4,1],[8,5,2],[9,6,3]]
 * 
 * 
 * 
 * 
 * 
 */