

public class LCS {

     public int longestCommonSubsequence(String text1, String text2) {

        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        // A dp array to check for the common substring
        // We will use size + 1 because empty strings are always 0


// since we have empty string too, we will start from 1 and 1
        for(int i=1; i <= text1.length(); i++){
            for(int j=1; j <= text2.length(); j++){
            
            // -1 to the indices becuase we are fill array from index 1 but strings index start at 0
                  if(text1.charAt(i-1) == text2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1]; // if character match then we add previous vertical element value
                  }else{
                     dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                      }
             // if characters are not a match, then we take max of vertical and horizontal element value
                  }
            }
        
        return dp[text1.length()][text2.length()];
        // returns the longest common subsequence length
    }
    
}

/*
 * The subsequence means characters from any indices 
 * We need to find longest common between two indices
 * 
 * We can take a brute-force approach but it will take exponential time as we have to compute all the subsequences
 * So, we move to dynamic programming as there are ovelapping sub problems
 * We will maintain a 2d array ofr string string1 + 1 and string2 + 1 length
 * At index 0, we wont compute as their are empty strings
 * 
 * If we find a common character, then we will update the current cell value by 1 + previous cell value in the same column
 * i-1, j-1 cell 
 * 
 * If we can't find a common character then we will update the current cell with either max of previous cell between row and column
 * i-1 , j and i and j-1 if characters don't match
 * 
 * We will run the loop from 1 to values equal to string lengths as in dp we have lengths + 1 for both row and column
 * The last index dp[string1 length][string2 length] will return the value or the answer
 * 
 * 
 */




/*
 * 
 * Given two strings text1 and text2, return the length of their longest common subsequence. If there is no common subsequence, return 0.

A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.

For example, "ace" is a subsequence of "abcde".
A common subsequence of two strings is a subsequence that is common to both strings.

 

Example 1:

Input: text1 = "abcde", text2 = "ace" 
Output: 3  
Explanation: The longest common subsequence is "ace" and its length is 3.
Example 2:

Input: text1 = "abc", text2 = "abc"
Output: 3
Explanation: The longest common subsequence is "abc" and its length is 3.
Example 3:

Input: text1 = "abc", text2 = "def"
Output: 0
Explanation: There is no such common subsequence, so the result is 0.
 

Constraints:

1 <= text1.length, text2.length <= 1000
text1 and text2 consist of only lowercase English characters.
 */