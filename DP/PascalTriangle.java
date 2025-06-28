import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {

    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> ans = new ArrayList<>(); // creates a 2d list 

        for(int i=0; i<numRows; i++){

             ans.add(new ArrayList<Integer>()); // creates a new arraylist for each row

              for(int j=0; j<= i; j++){

                if(j == 0 || j == i){
                 ans.get(i).add(1); // set first and last element as 1 in the current row
                }else{
                   ans.get(i).add( ans.get(i-1).get(j-1) + ans.get(i-1).get(j) ); // adds previous row elements of current and current - 1 index
                }

              }
        }


        return ans; // return the list of list
        
    }
}



/*
 * Given an integer numRows, return the first numRows of Pascal's triangle.

In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:

Example 1:

Input: numRows = 5
Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
Example 2:

Input: numRows = 1
Output: [[1]]
 

Constraints:

1 <= numRows <= 30
 * 
 * 
 * 
 * 
 */