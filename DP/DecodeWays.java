public class DecodeWays {

    public int numDecodings(String s) {

        // Base case if string starts at 0, then there is no spliting
        if(s.charAt(0) == '0') return 0;

        int[] dp = new int[s.length() + 1];
    /* we will have an +1 in size of dp because we are staring from 0
    and split can be either 1 character or 2 character

    empty string show successful split, and that is for 0th index
    index 1 depends on first character as it can be 0 or 1

    The last value will give us the solution that is dp[s.length]
    as indices are from 0 to s.length for size s.length + 1
    */

    dp[0] = 1; // for empty string as split is either 2 or 1
    dp[1] = 1; // only when character is from 1 to 9 not 0

 

    // Have to run the loop including s.length() because enite string should be covered and empty string is also included
    for(int i=2; i <= s.length(); i++){

        int oneDigit = Integer.valueOf(s.substring(i-1, i));
        int twoDigit = Integer.valueOf(s.substring(i-2, i));

        if(oneDigit >= 1) dp[i] = dp[i] + dp[i - 1];
        if(twoDigit >= 10 && twoDigit <= 26) dp[i] = dp[i] + dp[i - 2];
    }
    
     return dp[s.length()];   
    }
    
}

/*
 * Given strings are already encoded and we are suppose to decode it
 * But there could be more than 1 way a string is decoded
 * We will be focused more on combining two strings together or treat each character
 * But main problem is when we encounter 0
 * We have encoding from 1 to 26 encoded
 * for 0, we have only 10, 20 as proper combination
 * 
 * 06 does not have any proper encoding
 * 112 with either decoded as 1, 1, 2 or 11 or 2 or 1 , 12
 * 
 * The spliting is creating a lot combinations and hence it is dynamic programming
 * The split is either a single character or two characters
 * We can write a recursion for this
 * 
 * We will always start with the first character for the condition
 * If the first character is 0, then we will skip it and return 0
 * If we get an empty string, then string was successfully parsed
 * 
 * But do we need a dynamic programming
 * Yes, because we will get the same string after spliting which is an overlapping subproblem
 * We will record these strings and number of ways they were decoded using a hashmap or an array
 * 
 * 
 * In the end, we will get a solution
 * 
 * If we are using an array, we will be using
 * waysToDecode[i] = waysToDecode[i-1] + waysToDecode[i-2];
 * i-1 for 1 character split or if last 1 digit is valid
 * i-2 for 2 character split or if last 2 digits are valid
 * if the starting character is 0, then it is invalid and we always return 0
 * 
 * Please remember a string may contain 0 in the string at any point
 * 
 * Since, we are given numbers, we don't want to use strings all the time as it may fill our memory
 * as stirngs are stored in string pool
 * 
 * At any juncture, we are supposed to check for two things, 1 character or 2 character
 * These can also be converted to numbers
 * If for 1 character split, character is converted to a number and if it is 1 to 9 then we add 1
 * if for 2 characters split, character is between 11 and 26 then we also add 1
 * 
 * But we will take last two index values at any index till the current index as we are supposed to use dynamic programming
 * Thus we are 0th index as 1 and 1st index as 0 or 1 depending on that first character
 * 
 * The time complexity will be O(n)
 * 
 * 
 * The dp array will of size string.length() + 1 ans we need to run the loop till string.length()
 * The final index value will give us the solution
 * 
 * 
 * 
 * 
 */



/*
 * You have intercepted a secret message encoded as a string of numbers. The message is decoded via the following mapping:

"1" -> 'A'

"2" -> 'B'

...

"25" -> 'Y'

"26" -> 'Z'

However, while decoding the message, you realize that there are many different ways you can decode the message because some codes are contained in other codes ("2" and "5" vs "25").

For example, "11106" can be decoded into:

"AAJF" with the grouping (1, 1, 10, 6)
"KJF" with the grouping (11, 10, 6)
The grouping (1, 11, 06) is invalid because "06" is not a valid code (only "6" is valid).
Note: there may be strings that are impossible to decode.

Given a string s containing only digits, return the number of ways to decode it. If the entire string cannot be decoded in any valid way, return 0.

The test cases are generated so that the answer fits in a 32-bit integer.

 

Example 1:

Input: s = "12"

Output: 2

Explanation:

"12" could be decoded as "AB" (1 2) or "L" (12).

Example 2:

Input: s = "226"

Output: 3

Explanation:

"226" could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).

Example 3:

Input: s = "06"

Output: 0

Explanation:

"06" cannot be mapped to "F" because of the leading zero ("6" is different from "06"). In this case, the string is not a valid encoding, so return 0.

 

Constraints:

1 <= s.length <= 100
s contains only digits and may contain leading zero(s).
 */