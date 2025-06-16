import java.lang.classfile.components.ClassPrinter.ListNode;

public class LinkListCycle {

    public boolean hasCycle(ListNode head) {

        if(head == null) return false;

        ListNode pointer1 = head; // slow pointer
        ListNode pointer2 = head; // fast pointer


     // We will check if both pointers are not null and since pointer2 is hoping twice, we have to check for its next not to be null
     // If pointer2 is null, then without checking if we try to hop two places, we will get null pointer exception
        while(pointer1 != null && pointer2 != null && pointer2.next != null){
            pointer1 = pointer1.next; // hops 1 position
            pointer2 = pointer2.next.next; // hops 2 position

           if(pointer1 == pointer2){
            return true;
           }
        }
        
        
            return false;
    }
    
}


/*
 * Solution of the problem
 * 
 * We can store nodes in a hash map and then check if any node occured twice.
 * Though this approach gives correct solution, we will acquire extra space for map
 * 
 * So, we use slow and fast pointer
 * slow pointer hops 1 position
 * fast pointer hops 2 position
 * If they meet then we return true
 * 
 * But challenge is null pointer exception and to check if pointer2 can make that leap
 * 
 * In order to solve this, initially both pointers will start from head
 * We will check if slow and fast pointer are not null, if they are then we break the loop
 * We will also check if fast pointer next is not null, otherwise we will hop 2 places to no where
 * This will give us null pointer exception
 * So, we will check slow pointer not null, fast pointer not null, and fast pointer next not null in the loop
 * 
 * within the loop, if we found both slow and fast at same location i.e address then loop exists
 * We return true
 * We return false by default
 * 
 * slow pointer will be equal to slow.next which is a single hop
 * fast pointer will be equal to fast.next.next which is two hops
 * 
 * 
 */


/*
 * 
 * Given head, the head of a linked list, determine if the linked list has a cycle in it.

There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.

Return true if there is a cycle in the linked list. Otherwise, return false.

 Input: head = [3,2,0,-4], pos = 1
Output: true
Explanation: There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed).

Input: head = [1,2], pos = 0
Output: true
Explanation: There is a cycle in the linked list, where the tail connects to the 0th node.

Input: head = [1], pos = -1
Output: false
Explanation: There is no cycle in the linked list.
 

Constraints:

The number of the nodes in the list is in the range [0, 104].
-105 <= Node.val <= 105
pos is -1 or a valid index in the linked-list.
 * 
 * 
 * 
 * 
 */