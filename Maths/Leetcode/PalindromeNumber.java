
public class PalindromeNumber {

    public boolean isPalindrome(int x) {
        
       // Base Cases because log 10 does not work on 0 and negative values
       // negative numbers are never palindrome
        if(x < 0) return false;
        if(x == 0) return true;

        int digits = (int)Math.log10(x) + 1; // gets number of digits in the number
        int[] arr = new int[digits]; // creates an array of those digits

        int left = 0; // start index of array
        int right = digits - 1; // end index of arrray
        int flag = 1; // flag to track if there are any digits not equal to each other


        // store these digits in the array
        for(int i=digits - 1; i>= 0; i--){
             arr[i] = x % 10;
             x = x / 10;
            // System.out.println(arr[i]);
        }

        // skims through entire array
        while(left <= right){

          // System.out.println(digits + " " + arr[left] + " " + arr[right]);

            if(arr[left] != arr[right]){
                flag = 0;
            }

            left++;
            right--;
        }
    
        // returns final result
        if(flag == 0){
            return false;
        }else{
            return true;
        }
        
    }
    
}




/*
 * Given an integer x, return true if x is a palindrome, and false otherwise.

 

Example 1:

Input: x = 121
Output: true
Explanation: 121 reads as 121 from left to right and from right to left.
Example 2:

Input: x = -121
Output: false
Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
Example 3:

Input: x = 10
Output: false
Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 

Constraints:

-231 <= x <= 231 - 1
 * 
 * 
 * 
 */