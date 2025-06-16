import java.util.Arrays;

public class ValidAnagram {

    public boolean isAnagram(String s, String t) {

        char[] s1 = s.toCharArray();
        char[] s2 = t.toCharArray();

        Arrays.sort(s1);
        Arrays.sort(s2);

        return Arrays.equals(s1, s2);
        
    }
    
}

/*
 * 
 * Solution of the problem
 * 
 * Anagrams means two strings that have same characters in same frequency
 * 
 * We will store both strings in character array
 * sort them and then compare them
 * 
 * If they are equal, we will return true or else false
 * 
 * 
 */


/*
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.

 

Example 1:

Input: s = "anagram", t = "nagaram"

Output: true

Example 2:

Input: s = "rat", t = "car"

Output: false

 

Constraints:

1 <= s.length, t.length <= 5 * 104
s and t consist of lowercase English letters.
 

Follow up: What if the inputs contain Unicode characters? How would you adapt your solution to such a case?
 * 
 * 
 * 
 * 
 * 
 */