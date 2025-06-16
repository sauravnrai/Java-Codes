/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

public class RemoveElement {

    public ListNode removeElements(ListNode head, int val) {

        ListNode temp = null; // temp to insert a new node
        ListNode head2 = null; // new head node

        while(head != null){
             
             // If current node value is not equal to val
            if(head.val != val){
                       
                       // First insertion if both temp and head2 are null
                       if(temp == null){
                            temp = new ListNode(head.val); // creates a new node and attach to temp
                            head2 = temp; // makes head2 as head

                         }else{
                            temp.next = new ListNode(head.val); // creates a new node and attaches to temp
                            temp = temp.next; // increment temp
                            // Insert a new node and increment the temp node
                         }
            }

            head = head.next; // moves to next node
        }

        return head2;
    }
    
}



/*
 * Given the head of a linked list and an integer val, remove all the nodes of the linked list that has Node.val == val, and return the new head.
 * 
 * 
Example 1:
Input: head = [1,2,6,3,4,5,6], val = 6
Output: [1,2,3,4,5]

Example 2:

Input: head = [], val = 1
Output: []

Example 3:

Input: head = [7,7,7,7], val = 7
Output: []
 

Constraints:

The number of nodes in the list is in the range [0, 104].
1 <= Node.val <= 50
0 <= val <= 50
 * 
 * 
 */