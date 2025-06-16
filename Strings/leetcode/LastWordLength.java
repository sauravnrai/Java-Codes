
public class LastWordLength {

    public int lengthOfLastWord(String s) {

        String[] arr = s.split("\\s+"); // splits the entire string in words now matter how long the space is
        // This is trim and clear all spaces at start, end, in middle, and how long the space is

        int size = arr.length; // finds the size of the array

        int length = arr[size - 1].length(); // gets the length of the last string
       

       return length;
        
    }
    
}

/*
 * Solution to the problem
 * 
 * In this, we will first split the given string and store it in an string array
 * We will clear all spaces, no matter where it occurs, and how big it is
 * space can occur at start, end, or in the middle
 * 
 * Now, we will find the size of the array
 * Then we will find the length of the last string in the string array and return it 
 * 
 * To split a string in Java while ignoring any number of spaces, you can use the split() method with a regular expression that matches one or more whitespace characters. Here's how:
Using \\s+:
The regular expression \\s+ matches one or more whitespace characters (spaces, tabs, newlines, etc.).
 */


/*
 * 
 * Given a string s consisting of words and spaces, return the length of the last word in the string.

A word is a maximal substring consisting of non-space characters only.

 

Example 1:

Input: s = "Hello World"
Output: 5
Explanation: The last word is "World" with length 5.
Example 2:

Input: s = "   fly me   to   the moon  "
Output: 4
Explanation: The last word is "moon" with length 4.
Example 3:

Input: s = "luffy is still joyboy"
Output: 6
Explanation: The last word is "joyboy" with length 6.
 

Constraints:

1 <= s.length <= 104
s consists of only English letters and spaces ' '.
There will be at least one word in s.
 * 
 * 
 * 
 */