import java.util.LinkedList;

class ValidPar{

     public boolean isValid(String s) {

        int size = s.length();
        LinkedList<Character> stack = new LinkedList<>();
        boolean result = false;

        if(size == 1){
            return false;
        }
        
        stack.addLast(s.charAt(0)); // avoiding empty stack
        for(int i = 1; i< size; i++){
            
            char temp = s.charAt(i);
            char top = ' ';
            if(!stack.isEmpty()) top = stack.getLast(); // peeks at the top of the stack

    if(temp == ')' && top == '(' || temp == '}' && top == '{' || temp == ']' && top == '['){
                 stack.removeLast();
            }else{
                stack.addLast(temp);
            }


        }
           
           if(stack.isEmpty() == true){
            result = true;
           }

       return result; 
    }
}


/*
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.
 

Example 1:

Input: s = "()"

Output: true

Example 2:

Input: s = "()[]{}"

Output: true

Example 3:

Input: s = "(]"

Output: false

Example 4:

Input: s = "([])"

Output: true

 

Constraints:

1 <= s.length <= 104
s consists of parentheses only '()[]{}'.
 * 
 * 
 * 
 * 
 * 
 * 
 */