import java.util.ArrayList;
import java.util.List;

public class ZigZag {

    //User Code that could be optimized
    public String convert(String s, int numRows) {
       
       // If the string length is 1 or numRows is 1 then we will return the string itself
       
        if(s.length() == 1 || numRows == 1) return s;

        String ans_str = ""; // answer string

        List<List<Character>> ans = new ArrayList<>();

        for(int i=0; i<numRows; i++){
            ans.add(new ArrayList<>()); // adds the new arraylist at that row
        }
   

   // Loop to parse the entire string
        int index = 0;
        int direction = 1; // Direction will decide how to increment or decrement index
        // +1 if top to down
        // -1 for bottom to top

      for(int i=0; i<s.length(); i++){

           ans.get(index).add(s.charAt(i)); // adds the element to that row
         
         // Depending on direction, we will increment or decrement index
               if(index == 0){
                     direction = 1 ;// increment index based on direction
                  }else if(index == numRows - 1){
                      direction = -1; // decrement index based on direction
                   }

                   index = index + direction;
          
      }


  // Looping mechanism to get final string  
    for(int i=0; i<numRows; i++){

        for(int j=0; j < ans.get(i).size(); j++){
            ans_str = ans_str + ans.get(i).get(j); // forms the final string
        }
    }

       return ans_str; // returns the answer string
        
    }
    
}


/*
Solution of the code

Problem: Zigzag Conversion (Leetcode 6)

Given a string and a number of rows, we need to write the characters in a zigzag pattern
and then read them row-by-row to get the final output string.

For example:
Input: s = "PAYPALISHIRING", numRows = 3
Zigzag Pattern:
P   A   H   N
A P L S I I G
Y   I   R
Output: "PAHNAPLSIIGYIR"

--------------------------------------------
CODE EXPLANATION:

1. Base Case:
   - If the number of rows is 1 or the string has only 1 character, the output is the string itself
     because zigzag has no effect in these cases.

2. Data Structure:
   - We use a list of lists (rows) to represent the zigzag structure.
   - Each inner list stores the characters that go in that row.

3. Zigzag Simulation:
   - We simulate the zigzag pattern by maintaining two variables:
     - `index`: which row we're currently on.
     - `direction`: whether we're moving down (`+1`) or up (`-1`) through the rows.


  Zigzag Direction Logic Recap

The key logic of zigzag is the way we move down and up the rows:

Start at row 0.

Keep moving down (direction = +1) until you hit numRows - 1.

Then reverse the direction to up (direction = -1) until you hit row 0.

Repeat this cycle for every character.

The index variable acts like a pointer to the current row, and direction decides how to move the pointer.


4. Loop Through the String:
   - For each character, we add it to the current row (`index`).
   - If we're at the top row (`index == 0`), we set `direction = +1` to go down.
   - If we're at the bottom row (`index == numRows - 1`), we set `direction = -1` to go up.
   - We then update `index` by adding `direction` to it.

5. Building the Output String:
   - After placing all characters into the zigzag structure,
     we concatenate all rows from top to bottom to form the final answer string.

--------------------------------------------

KEY INTUITION:
- The index moves up and down like a wave to simulate the zigzag.
- By using this pattern and storing characters row-wise, we can easily read the rows at the end.

Suggested Improvement
Use StringBuilder[] instead of List<List<Character>> to improve performance (O(n) time vs O(n²)). 

*/


/*
 * CHATGPT CODE (OPTIMIZED)
 * 
public String convert(String s, int numRows) {
       
       // Base case
if (numRows == 1 || s.length() <= numRows) return s;

// Use StringBuilder array instead of List<List<Character>>
StringBuilder[] rows = new StringBuilder[numRows];
for (int i = 0; i < numRows; i++) rows[i] = new StringBuilder();

int index = 0;
int direction = 1;

for (char c : s.toCharArray()) {
    rows[index].append(c);
    if (index == 0) direction = 1;
    else if (index == numRows - 1) direction = -1;
    index += direction;
}

// Merge all rows into result
StringBuilder result = new StringBuilder();
for (StringBuilder row : rows) result.append(row);

return result.toString();
        
    }
 * 
 */




/*
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"

Write the code that will take a string and make this conversion given a number of rows:

string convert(string s, int numRows);
 

Example 1:

Input: s = "PAYPALISHIRING", numRows = 3
Output: "PAHNAPLSIIGYIR"
Example 2:

Input: s = "PAYPALISHIRING", numRows = 4
Output: "PINALSIGYAHRPI"
Explanation:
P     I    N
A   L S  I G
Y A   H R
P     I
Example 3:

Input: s = "A", numRows = 1
Output: "A"
 

Constraints:

1 <= s.length <= 1000
s consists of English letters (lower-case and upper-case), ',' and '.'.
1 <= numRows <= 1000
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */