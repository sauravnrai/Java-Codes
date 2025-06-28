public class ValidPalindrome {

    public boolean isPalindrome(String s) {

   String cleaned = s.replaceAll("[^a-zA-Z0-9]", ""); // regular expression to replace all non-alphanumeric characters

    cleaned = cleaned.toLowerCase(); // gets the lower case

    StringBuilder cleaned2 = new StringBuilder(cleaned); // put new string in string builder

    cleaned2.reverse(); // reverse the string

    return cleaned.equals(cleaned2.toString()); // compare and send return value

        
    }
    
}



/*
 * A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.

Given a string s, return true if it is a palindrome, or false otherwise.

 

Example 1:

Input: s = "A man, a plan, a canal: Panama"
Output: true
Explanation: "amanaplanacanalpanama" is a palindrome.
Example 2:

Input: s = "race a car"
Output: false
Explanation: "raceacar" is not a palindrome.
Example 3:

Input: s = " "
Output: true
Explanation: s is an empty string "" after removing non-alphanumeric characters.
Since an empty string reads the same forward and backward, it is a palindrome.
 

Constraints:

1 <= s.length <= 2 * 105
s consists only of printable ASCII characters.
 * 
 * 
 * 
 * 
 */