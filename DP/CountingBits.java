public class CountingBits {

    public int[] countBits(int n) {
       
       // Array to store answers to add numbers containing number of 1s
        int[] ans = new int[n + 1];

        ans[0] = 0; // 0 always has 0 1s

       for(int i = 1; i<= n; i++){
           
           if( i % 2 == 0){
            ans[i] = ans[i / 2]; // some values will have same number of 1's if they are divisble by 2
           }else{
            ans[i] = 1 + ans[i-1]; // if a number is not divisible by 2, it will contain 1 more bit than the previous number
           }
       }

        return ans;
        
    }

    
}

/*
 * Let us observe the number of 1's from 0 to 16
 * 
 * 0 - 0000
 * 1 - 0001
 * 2 - 0010
 * 3 - 0011
 * 4 - 0100
 * 5 - 0101
 * 6 - 0110
 * 7 - 0111
 * 8 - 1000
 * 9 - 1001
 * 10 - 1010
 * 11 - 1011
 * 12 - 1100
 * 13 - 1101
 * 14 - 1110
 * 15 - 1111
 * 16 - 10000
 * 
 * If we observe, then 1, 2, 4, 8, 16 all take only 1 bit since they are power of 0 and
 * 2 / 2 is 1, 4 / 2 is 2, 8 / 2 is 4, 16 / 2 is 8 
 * 
 * Now, if we check 3, 6, 12, they all take 2 1's
 * 6 / 2 is 3, 12 / 2 is 6
 * 
 * Now, if we check 5 and 10 they all take 2 1's
 * 10 / 2 is 5, 
 * 
 * But if we also observe, 3 takes 1 more bit than 2 (previous number) since it is not divisible by 2
 * Same for 5, it takes 1 more bit than its previous number that is 4
 * 
 * 7 takes 3 1's that is 1 more bit from its previous number 6
 * 
 * So, if a number num is divisible by 2 (not remainder % == 0) then it will contain same bits as its num / 2
 * If a number is not divisble by 1, then it will contain an extra 1 than its previous number
 * 
 * Since we are using previously computed solutions, this is a dynamic programming problem
 * 
 */


/*
 * Given an integer n, return an array ans of length n + 1 such that for each i (0 <= i <= n), ans[i] is the number of 1's in the binary representation of i.

 

Example 1:

Input: n = 2
Output: [0,1,1]
Explanation:
0 --> 0
1 --> 1
2 --> 10
Example 2:

Input: n = 5
Output: [0,1,1,2,1,2]
Explanation:
0 --> 0
1 --> 1
2 --> 10
3 --> 11
4 --> 100
5 --> 101
 

Constraints:

0 <= n <= 105
 * 
 * 
 * 
 * 
 * 
 */