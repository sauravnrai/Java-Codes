
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

public class ReverseLinkedList {

 public ListNode reverseList(ListNode head) {

        List<Integer> ls = new ArrayList<>(); // ArrayList to store values

        ListNode temp = head; // temp pointer
    
    // Loop to add elements in list
        while(temp != null){
            ls.add(temp.val);
            temp = temp.next;
        }

        int size = ls.size();

        // Reverse the entire list
        temp = head;
        for(int i = size - 1; i >= 0; i--){
             temp.val = ls.get(i);
             temp = temp.next;
        }

        return head; // return head
        
    }
    
}




/*
 * Given the head of a singly linked list, reverse the list, and return the reversed list.
 * 
 * Input: head = [1,2,3,4,5]
Output: [5,4,3,2,1]
 * 
 * 
 * Input: head = [1,2]
Output: [2,1]


Input: head = []
Output: []
 
 */