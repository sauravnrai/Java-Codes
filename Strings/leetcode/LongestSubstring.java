import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LongestSubstring {

     public int Approach2(String s) {
      

        int max_length = 0;
        int left = 0; // left pointer of the window
      Set<Character> set = new HashSet<>();

      for(int right=0; right<s.length(); right++){
      
      // when we encounter the repeated character, we will delete the elements until we delete that character
        while(set.contains(s.charAt(right))){
            set.remove(s.charAt(left)); 
        // the left pointer will shrink the window by deleting all the characters till the repeated character is encountered

            left++;
     // we have to increment left since we window will start from character after the repeated character as substrings may overlap along with their indices       
        }

        set.add(s.charAt(right));
        max_length = Math.max(max_length, right - left + 1); // gets the size of the current window, +1 because index is starting from 0
      }
       

    return max_length;
    }



    public int Approach1(String s) {


        int final_long_length = 0;

       List<Character> list = new ArrayList<>();

    for (int i = 0; i < s.length(); i++) {
        char currentChar = s.charAt(i);

        if (list.contains(currentChar)) {
            final_long_length = Math.max(final_long_length, list.size());
            int index = list.indexOf(currentChar); // gives first occurence of the repeated character
            list.subList(0, index + 1).clear(); // shrinks or readjust the window from next character of repeated character
        }

        list.add(currentChar); // Only add after duplicate removal
    }

    // Final check at the end of the loop in case the longest substring is at the end
    final_long_length = Math.max(final_long_length, list.size());

    return final_long_length;
    }
    


}


/*
Two approaches for the solution

We will have two approaches for this solution both follow the basic intution for solving the problem given below
 * 
 * ArrayList approach is O(n-square)
 * contains, indexOf, and subList().clear() are O(n) and running them in a loop of length n makes the entire code
 * in worst case n-square time complexity
 * 
 * Set based approach uses O(n) approach
 * since we will keep adding the characters, characters are always unique in set due to set's property
 * The while loop will clear all the characters till the first occurence of the repeated character
 * Set based approach is similar to array list approach in the working but uses only O(n) time complexity
 * 
 */


 /* Special test cases
  * for "" ans is 0 since empty string
    for " " ans is 1 since space
    for "    " ans is still 1 since space be any long it is always counted as 1 length
   No matter how big the space is, it is always treated as a single character and thus gives length 1
  *
  *
  * 
  */

/*
Solution for the problem

 problem with this question is that substring can occur from any index to any index
 And we need to find substring without repeating characters
 Cheacters can be space, numbers, digits

 This means we can have overlapping substrings, A linear method cannot be useful

 For example

 dvdf -> vdf is the longest substring, how is it computed?
 d is first character
 v is append to d, so dv is substring
 now, d is already present, so we record dv length and start the new sequence from v 
 since it will also be a substring without repeating character

 Now, vd is the new substring
 f is added and vdf is new substring

 The final substring is vdf and length is 3

 We can use a sliding window appraoch but we need to be mindful where to start and end the previous window

At any juncture, we need to have characters to be non-repeating in the window
In that window, we need to have unique characters 

When the character is repeated, we will end the window till that character in the existing window 
and start the window from next character and append the new character at the end

Let us try to understand with this example "pwwkew"
 * 
 * Initially, window is empty
 * we add p to window
 * we add w to window
 * Now, when w occurs, we will first append the repeating character i.e w, making window "pww"
 * Now, we will delete or shrink the window to first occurence of w,
 * so characters till first w are deleted and window now has only w
 * 
 * k is appended to the window, "wk"
 * e is appended to the window, "wke"
 * Now, w is repeated, so we first add w, "wkew"
 * Now, we shrink or delete the window till first occurence of repeating character
 * so, window is now "kew"
 * 
 * before we shrink the window, we always record the window size because 
 * that is the maximum longest substring length without repeating character
 * 
 */

 

/*
 * 
 * Given a string s, find the length of the longest substring without duplicate characters.

 

Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 

Constraints:

0 <= s.length <= 5 * 104
s consists of English letters, digits, symbols and spaces.
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */