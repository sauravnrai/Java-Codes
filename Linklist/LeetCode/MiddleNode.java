
import java.util.ArrayList;
import java.util.List;

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


public class MiddleNode {

     public ListNode middleNode(ListNode head) {

        List<Integer> ls = new ArrayList<>(); // List to hold the elements of the array

        ListNode temp = head;
        // Temporary pointer to process all elements in the linked list
      
        // Loop to add all elements in the list
        while(temp != null){
            ls.add(temp.val);
            temp = temp.next;
        }
     
        // Finds the size of the list
        int size = ls.size();
        int index = size / 2;
        // finds the middle index of the list

       // System.out.println(size + " " + index + " " + ls);

        ListNode head2 = null; // New head to start a linked kist
        temp = null;
        for(int i = index; i< size; i++){
             
             if(head2 == null){
                temp = new ListNode(ls.get(i)); // adds the first node of the list
                head2 = temp; // assign first node to head
             }else{
                temp.next = new ListNode(ls.get(i)); // increases the linked list chain
                temp = temp.next; // increases the pointer
             }
        }
        

        return head2; // returns the head of the list
    }

    
}


/*
 * Given the head of a singly linked list, return the middle node of the linked list.

If there are two middle nodes, return the second middle node.

Input: head = [1,2,3,4,5]
Output: [3,4,5]
Explanation: The middle node of the list is node 3.



Input: head = [1,2,3,4,5,6]
Output: [4,5,6]
Explanation: Since the list has two middle nodes with values 3 and 4, we return the second one.



Constraints:

The number of nodes in the list is in the range [1, 100].
1 <= Node.val <= 100
 * 
 * 
 * 
 * 
 */