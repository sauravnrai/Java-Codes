import java.util.LinkedList;
import java.util.List;

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

public class MinStack {

    // Let us create two global linked list called stack and min_stack
    // stack will add all values pushed towards it
    // min stack will maintain a stack of all minimum numbers i.e at every push of regular stack, we will check if new pushed element is smaller than the top of the min stack

    List<Integer> stack;
    List<Integer> min_stack;

    public MinStack() {
        stack  = new LinkedList<>(); // initialize main stack
        min_stack = new LinkedList<>(); // initialize min stack
    }
    
    public void push(int val) {

        if(stack.isEmpty()){
               stack.addFirst(val); // adds 1st value to the stack
               min_stack.addFirst(val); // adds 1st value to the min stack as 1st value is always minimum
        }else{

            stack.addFirst(val); // adds element to the main stack

            int top = min_stack.getFirst(); // gets the top of the min stack
             
             // We are using < =  because duplicate elements can also occur in the stack
            if(val <= top){
                min_stack.addFirst(val); // adds new minimum at the top of the min stack
            }

        }
        
    }
    
    public void pop() {
        
       int temp = stack.removeFirst();
       int top = min_stack.getFirst();

       if(temp == top) min_stack.removeFirst(); // removes min stack top since it was the top of stack as well, we don't want to give incorrect minimum i.e element present in min stack but not in main stack
    }
    
    public int top() {
        return stack.getFirst(); // returns top of the main stack
    }
    
    public int getMin() {
        return min_stack.getFirst(); // returns minimum element i.e top of min stack
    }
    
}

/*
 * MinStack - Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 * We are maintaing another stack because push, pop, top are O(1) but getMinimum() is not
 * We have to check all the contents of stack by using another stack which is time consuming and O(n)
 * we maintain a minstack to get minimum element of the stack in O(1) time
 *
 *  Why use two stacks?
 * - We maintain two separate stacks:
 *   1. `stack` → The main stack where all pushed values are stored.
 *   2. `min_stack` → An auxiliary stack that keeps track of the **minimum element** at every level.
 *
 *  How it works:
 * - Every time we push a value onto the stack, we also check if it is smaller than or equal to the current minimum.
 * - If it is, we push it to the `min_stack` as well.
 * - This way, `min_stack` always holds the history of minimum values. The top of `min_stack` is the current minimum.
 *
 * Why use `<=` in comparison?
 * - To handle **duplicate minimum values**.
 * - For example, if two `2`s are pushed, and one is popped, we still want the remaining `2` to be considered the current minimum.
 *
 *  Operations:
 * 
 * 1. push(int val):
 *    - Push the value onto `stack`.
 *    - If the value is <= current min (or stack is empty), push it onto `min_stack` too.
 *
 * 2. pop():
 *    - Remove the top element from `stack`.
 *    - If this element is equal to the top of `min_stack`, remove the top from `min_stack` as well (to keep both in sync).
 *
 * 3. top():
 *    - Simply return the top of `stack`.
 *
 * 4. getMin():
 *    - Return the top of `min_stack` → this is always the current minimum in O(1) time.
 *
 *  Time Complexity:
 * - push: O(1)
 * - pop: O(1)
 * - top: O(1)
 * - getMin: O(1)
 *
 *  Space Complexity:
 * - O(N) for storing elements in both `stack` and `min_stack`.
 *
 *  Summary:
 * - By using an additional stack to track the minimum value at each stage,
 *   we ensure constant-time retrieval of the minimum element without having to scan the entire stack.
 */







/*
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

Implement the MinStack class:

MinStack() initializes the stack object.
void push(int val) pushes the element val onto the stack.
void pop() removes the element on the top of the stack.
int top() gets the top element of the stack.
int getMin() retrieves the minimum element in the stack.
You must implement a solution with O(1) time complexity for each function.

 

Example 1:

Input
["MinStack","push","push","push","getMin","pop","top","getMin"]
[[],[-2],[0],[-3],[],[],[],[]]

Output
[null,null,null,null,-3,null,0,-2]

Explanation
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin(); // return -3
minStack.pop();
minStack.top();    // return 0
minStack.getMin(); // return -2
 

Constraints:

-231 <= val <= 231 - 1
Methods pop, top and getMin operations will always be called on non-empty stacks.
At most 3 * 104 calls will be made to push, pop, top, and getMin.
 * 
 * 
 * 
 * 
 */