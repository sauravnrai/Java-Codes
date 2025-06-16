import java.lang.classfile.components.ClassPrinter.ListNode;

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




public class MergeTwoSortedList {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        if(list1 == null && list2 == null) return list1;
        if(list1 != null && list2 == null) return list1;
        if(list1 == null && list2 != null) return list2;

        ListNode final_list = null;
        ListNode temp = null;

        while(list1 != null || list2 != null){


    int min = Math.min(list1.val, list2.val); // take the min among the two values since we need to sort list in increasing order
      
     //  System.out.println(min + " " + list1.val + " " + list2.val);
       
            // makes the list
            if(final_list == null){
                temp = new ListNode(min);
                final_list = temp; // inserts first node
                }
            else{
                temp.next = new ListNode(min);
                temp = temp.next; // inserts final node
            }
             
        // either increment list1 pointer or list2 pointer
          if(min == list1.val){
            list1 = list1.next;
          }else{
            list2 = list2.next;
          }

         
        // if list1 has become null, then we append all list2
            if(list1 == null){
                while(list2 != null){
                  temp.next = new ListNode(list2.val);
                  temp = temp.next;
                  list2 = list2.next;
                }
            }
        
         // if list2 has become null, then we append all list2
            if(list2 == null){
                while(list1 != null){
                  temp.next = new ListNode(list1.val);
                  temp = temp.next;
                  list1 = list1.next;
                }
            }
         

        }


        return final_list;
        
    }
    
}

/* Solution to the problem

// Handle all edge cases first:
// - If both lists are null, return null.
// - If only one list is null, return the other as the merged result.

// Initialize two pointers:
// - 'final_list' to keep the head of the result linked list.
// - 'temp' to help build the list node by node.

// Loop continues as long as at least one of the lists still has elements.

// In each iteration:
// - Compare the current values of list1 and list2.
// - Take the smaller of the two values (using Math.min).
// - If it's the first value, initialize the list.
// - Otherwise, append a new node with the smaller value and move the temp pointer.

// Move the pointer (list1 or list2) from which the smaller value was taken.

// After comparing and adding a value:
// - If list1 becomes null, append all remaining nodes from list2 directly.
// - If list2 becomes null, append all remaining nodes from list1 directly.

// The merging is done in a sorted way by always picking the smaller of the current nodes.

// Finally, return the head of the merged list (final_list).

 * 
 * 
 * 
 */






/*
 * You are given the heads of two sorted linked lists list1 and list2.

Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.

Return the head of the merged linked list.

 Input: list1 = [1,2,4], list2 = [1,3,4]
Output: [1,1,2,3,4,4]
Example 2:

Input: list1 = [], list2 = []
Output: []
Example 3:

Input: list1 = [], list2 = [0]
Output: [0]
 

Constraints:

The number of nodes in both lists is in the range [0, 50].
-100 <= Node.val <= 100
Both list1 and list2 are sorted in non-decreasing order.
 * 
 * 
 * 
 * 
 * 
 */