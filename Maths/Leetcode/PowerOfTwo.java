public class PowerOfTwo {

 public boolean isPowerOfTwo(int n) {
        
        if(n == 1) return true; // for 1, it is true
        if(n % 2 != 0) return false; // no point in checking for numbers that are not even divisble by 2

        int index = 0; // index to be used for generating power of 2

       long power = 0; // keeps track of power of 2 generated in the loop
       long temp = n; // stores n in temp

       // loop through until we reach the number
        while(power <= temp){   
           power = (int)Math.pow(2, index);
           
           // if the number and power of 2 generated are exactly the same, then return true
            if(power == temp) return true;

            index++; // increment index to generate the power
        }


        return false; // default case if no power is available
        
    }


    
}

/*
 * Bit-wise operation can be more useful and faster to solve this problem
 * 
 */



/*
 * Given an integer n, return true if it is a power of two. Otherwise, return false.

An integer n is a power of two, if there exists an integer x such that n == 2x.

 

Example 1:

Input: n = 1
Output: true
Explanation: 20 = 1
Example 2:

Input: n = 16
Output: true
Explanation: 24 = 16
Example 3:

Input: n = 3
Output: false
 

Constraints:

-231 <= n <= 231 - 1
 * 
 * 
 * 
 */