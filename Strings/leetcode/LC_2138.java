

public class LC_2138 {


    // Approach 1 that was written without string builder

    public String[] divideString(String s, int k, char fill) {

        int str_len = s.length(); // takes the length of the string
        int groups = 0; // Initialliy we will have 0 groups

    
        if(str_len >= k) groups = str_len / k; 
    // We will get an intial value of group that might be divisble by k.
    // We will get a whole value if string length is well within k, but there might be last part of string that may not form a group that has the k length
    // The group will remain 0, if the value of k is greater than string length

        if(str_len % k != 0) groups = groups + 1;
 // We need one more group if current groups are not sufficient to occupy the entire string
 // If the stirng length is lesser than k, then group will always be 1 i.e string and filler

        String[] ans = new String[groups];

        System.out.println(groups);

        // Loop to fill the entire last group with the filler
         int fill_count = groups*k - str_len; // this will give the number of characters to append to the string before dividing
         for(int i=0; i<fill_count; i++){
            s = s + fill; // adds filler
         }
     
     
     // Loop to divide the string into groups
     int index = 0;
     for(int i=0; i<groups; i++){
        ans[i] = s.substring(index, index + k);
        index = index + k;

     }

        return ans;
        
    }

    
}


/*
 * Approach 1 solution explanation
 
This function divides the given string into groups of size k.
If the string can't be evenly divided, it fills the last group with a filler character.

Intuition:
------------
- We need to split a string into chunks (substrings) of equal size 'k'.
- If the string length is not divisible by 'k', then the last group will be incomplete.
- According to the problem, we must **pad** the last group with the given fill character to make it exactly length 'k'.
- Our final answer should be an array of strings, each string of length 'k'.

Step-by-step explanation:
--------------------------
1. First, calculate the length of the input string.
2. Then, determine how many groups are needed:
   - If the string is divisible by k, we simply divide length by k.
   - Otherwise, we’ll need one additional group to hold the remaining characters and fill it later.
3. Create a result array of that group size to store the final substrings.
4. Figure out how many filler characters are needed:
   - Multiply the total number of groups by k (total required length).
   - Subtract the original string length from that value to know how many fill characters are needed.
5. Append the fill character that many times to the string.
   - This ensures the string is now perfectly divisible by k.
6. Loop through the string and extract each group of size k and store it in the result array.
   - Keep track of the current position using an index.
7. Finally, return the result array.

Why this works:
----------------
- This approach guarantees that each group is exactly length 'k'.
- It handles edge cases like string shorter than 'k', or not divisible by 'k'.
- The padding is only added at the end — as required — and does not disturb earlier characters.

Use cases:
----------
- Can be applied in text formatting, fixed-length encoding, chunked transmissions, etc.

*/



/*
 * CHATGPT OPTIMIZED CODE with string builder (Best solution)
 * 
 * 
 * Why StringBuilder?
StringBuilder is mutable, meaning it avoids the overhead of creating new string objects every time you append.

Improves performance especially when appending many characters.

Key Advantages of this Code:
Handles edge cases like s.length() < k or s.length() % k != 0.

int totalGroups = (len + k - 1) / k;

how many full-size k groups fit in len, even if the last one is not full?

Appends filler characters only when needed.

Avoids string immutability inefficiencies.

Clean and readable code.


public String[] divideString(String s, int k, char fill) {
        int len = s.length();
        int totalGroups = (len + k - 1) / k; // ceiling of (len/k)
        String[] result = new String[totalGroups];
        
        StringBuilder sb = new StringBuilder(s);

        // Pad with fill character if needed
        while (sb.length() % k != 0) {
            sb.append(fill);
        }

        // Slice into groups
        int idx = 0;
        for (int i = 0; i < totalGroups; i++) {
            result[i] = sb.substring(idx, idx + k);
            idx += k;
        }

        return result;
    }
 * 
 * 
 */



/*
Problem Statement

 * A string s can be partitioned into groups of size k using the following procedure:

The first group consists of the first k characters of the string, the second group consists of the next k characters of the string, and so on. Each element can be a part of exactly one group.
For the last group, if the string does not have k characters remaining, a character fill is used to complete the group.
Note that the partition is done so that after removing the fill character from the last group (if it exists) and concatenating all the groups in order, the resultant string should be s.

Given the string s, the size of each group k and the character fill, return a string array denoting the composition of every group s has been divided into, using the above procedure.

 

Example 1:

Input: s = "abcdefghi", k = 3, fill = "x"
Output: ["abc","def","ghi"]
Explanation:
The first 3 characters "abc" form the first group.
The next 3 characters "def" form the second group.
The last 3 characters "ghi" form the third group.
Since all groups can be completely filled by characters from the string, we do not need to use fill.
Thus, the groups formed are "abc", "def", and "ghi".
Example 2:

Input: s = "abcdefghij", k = 3, fill = "x"
Output: ["abc","def","ghi","jxx"]
Explanation:
Similar to the previous example, we are forming the first three groups "abc", "def", and "ghi".
For the last group, we can only use the character 'j' from the string. To complete this group, we add 'x' twice.
Thus, the 4 groups formed are "abc", "def", "ghi", and "jxx".
 

Constraints:

1 <= s.length <= 100
s consists of lowercase English letters only.
1 <= k <= 100
fill is a lowercase English letter.
 * 
 * 
 * 
 */