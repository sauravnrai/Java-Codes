
import java.util.ArrayList;
import java.util.List;

public class ReverseList2 {

    public ListNode reverseBetween(ListNode head, int left, int right) {

        List<Integer> ls = new ArrayList<>(); // an array list to store all linked list data
        ListNode temp = head; // temp pointer to process the entire list
  
  // Adds the entire linked list data in arraylist
        while(temp != null){
            ls.add(temp.val);
            temp = temp.next;
        }
   
   // Fix indices two reverse that part of the linked list in array list
        int i = left - 1;
        int j = right - 1;
     
     // Swaps the linked list via array list
        while(i < j){
            int swap = ls.get(i);
            ls.set(i, ls.get(j));
            ls.set(j, swap);
            i++;
            j--;
        }

        temp = head; // set temp to head to change head
    
    // Loop to copy entire array list in the linked list
      for(int k = 0; k < ls.size(); k++){
          temp.val = ls.get(k);
          temp = temp.next;
      }

        return head; // return head
        
    }
    
}

/*
  Solution to the problem
 * 
 * We are supposed to reverse only a part of the list
 * We will store these linked list elements in an array list
 * We will reverse that part in the array list
 * We will copy the array list in the linked list
 * Now, we return the head of the list
 * 
 * There is extra space we are taking here i.e array list
 * Time complexity is still O(n)
 * 
 */


/*
 * Given the head of a singly linked list and two integers left and right where left <= right, reverse the nodes of the list from position left to position right, and return the reversed list.
 * 
 * Input: head = [1,2,3,4,5], left = 2, right = 4
Output: [1,4,3,2,5]

Input: head = [5], left = 1, right = 1
Output: [5]
 

Constraints:

The number of nodes in the list is n.
1 <= n <= 500
-500 <= Node.val <= 500
1 <= left <= right <= n
 * 
 * 
 */