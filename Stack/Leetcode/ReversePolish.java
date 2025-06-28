import java.util.LinkedList;
import java.util.List;

public class ReversePolish {

    public int evalRPN(String[] tokens) {

        List<Integer> stack = new LinkedList<>(); // linked list that will have stack

     // Loop to go over all the strings
        for(String item: tokens){
        
                 // only perform operation if the token is a operator
                  if(isOperator(item)){
                      int num2 = stack.removeLast(); // 2nd number removed
                      int num1 = stack.removeLast(); // 1st number removed

                      if(item.equals("+")) stack.addLast(num1 + num2);
                      if(item.equals("-")) stack.addLast(num1 - num2);
                      if(item.equals("*")) stack.addLast(num1 * num2);
                      if(item.equals("/")) stack.addLast(num1 / num2);


            }else{
               int number = Integer.parseInt(item);
                stack.addLast(number); // number added

            }     

        }


        return stack.removeLast(); // returns result
        
    }

// checks if the current character is an operator
    public boolean isOperator(String op){

        if(op.equals("+") || op.equals("-") || op.equals("*") || op.equals("/")) return true;

        return false;

    }
    
}


/*
 * This solution evaluates an arithmetic expression given in Reverse Polish Notation (RPN).
 * RPN means that operators come **after** their operands.
 * For example, ["2", "1", "+"] means 2 + 1, and ["4", "13", "5", "/", "+"] means 4 + (13 / 5).
 *
 *  Stack is used to store operands (numbers) while processing the expression.
 * When we encounter an operator, we pop the **top two** elements from the stack and perform the operation.
 * The result is then pushed back to the stack.
 *
 *  Why is num2 popped first and num1 second?
 * - Since we are using a stack (LIFO), the most recently added number is popped first.
 * - In an expression like "2 3 -", the last number pushed is 3, and before that was 2.
 * - So when we pop:
 *   → First pop gives us 3 → this is **num2** (right operand)
 *   → Second pop gives us 2 → this is **num1** (left operand)
 * - The operation is then **num1 - num2** → 2 - 3 = -1
 * - This ordering is essential for non-commutative operations like subtraction and division.
 *
 *  Process Flow:
 * - For each token in the input:
 *   → If it’s a number, convert to integer and push onto the stack.
 *   → If it’s an operator, pop num2 and num1, perform operation, and push result.
 *
 *  Final Step:
 * - After processing all tokens, only one value remains in the stack — the final result.
 *
 *  Edge Case Handling:
 * - Division uses integer division (truncates towards zero, as per Java behavior).
 * - Input is guaranteed to be valid, so we don’t handle malformed input cases here.
 *
 * Time Complexity: O(N), where N is the number of tokens.
 * Space Complexity: O(N), in the worst case all tokens are numbers (stack grows linearly).
 */




/*
 * You are given an array of strings tokens that represents an arithmetic expression in a Reverse Polish Notation.

Evaluate the expression. Return an integer that represents the value of the expression.

Note that:

The valid operators are '+', '-', '*', and '/'.
Each operand may be an integer or another expression.
The division between two integers always truncates toward zero.
There will not be any division by zero.
The input represents a valid arithmetic expression in a reverse polish notation.
The answer and all the intermediate calculations can be represented in a 32-bit integer.
 

Example 1:

Input: tokens = ["2","1","+","3","*"]
Output: 9
Explanation: ((2 + 1) * 3) = 9
Example 2:

Input: tokens = ["4","13","5","/","+"]
Output: 6
Explanation: (4 + (13 / 5)) = 6
Example 3:

Input: tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
Output: 22
Explanation: ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
= ((10 * (6 / (12 * -11))) + 17) + 5
= ((10 * (6 / -132)) + 17) + 5
= ((10 * 0) + 17) + 5
= (0 + 17) + 5
= 17 + 5
= 22
 

Constraints:

1 <= tokens.length <= 104
tokens[i] is either an operator: "+", "-", "*", or "/", or an integer in the range [-200, 200].
 * 
 * 
 * 
 * 
 */