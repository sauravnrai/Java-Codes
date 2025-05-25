import java.util.Arrays;

public class BinarySearch {

    public int search(int[] nums, int target) {
     
    // To apply binary search, array should be sorted in ascending order which can be done using Arrays.sort(array_name)
     int result = Arrays.binarySearch(nums, target); 
     // returns the index if element is present or returns the possible position or index in negative

     if(result < 0) result = -1; 
// if the index is not found, then set result to -1 as it previously contained negative index where element can fit

        return result; 
        
    }
    
}
