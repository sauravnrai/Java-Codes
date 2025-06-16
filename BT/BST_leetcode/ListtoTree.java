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

import java.lang.classfile.components.ClassPrinter.ListNode;
import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */


public class ListtoTree {

     public TreeNode sortedListToBST(ListNode head) {

        ListNode temp = head;
         List<Integer> ans = new ArrayList<>(); // arraylist to store the values
       
       // store the list node in an array list
         while(temp != null){

            ans.add(temp.val);
            temp = temp.next;
         }
        
        TreeNode temp_root = null;
         temp_root = MakeBST(temp_root, ans, 0, ans.size() - 1); // function call to make the BST balanced

       return temp_root;
    }

    public static TreeNode MakeBST(TreeNode root, List<Integer> ans, int left, int right){

        if(left > right) return null; // base case when left pointer crosses right pointer then return null

        int index = (left + right) / 2; // gets the middle index
      
      // Gets the root node a node if it is null
        if(root == null){
            root = new TreeNode(ans.get(index));
        }

      root.left =  MakeBST(root.left, ans, left, index - 1); // left node of root

      root.right =  MakeBST(root.right, ans, index + 1, right); // right node of root

      return root; // return root


    }


    
}

/*
 * If you know Array to Tree, then this isn't much a problem
 * This question is just for revision purpose and ain't that though
 * 
 * We follow a similar appraoch to Array to tree
 * We are given a list or linkedlist
 * We will store all these linkedlist values in a list or arraylist
 * Then we will build a new BST and return the root
 * 
 * 
 */


/*
 * Given the head of a singly linked list where elements are sorted in ascending order, convert it to a height-balanced binary search tree.

 Input: head = [-10,-3,0,5,9]
Output: [0,-3,9,-10,null,5]
Explanation: One possible answer is [0,-3,9,-10,null,5], which represents the shown height balanced BST.


Input: head = []
Output: []
 

Constraints:

The number of nodes in head is in the range [0, 2 * 104].
-105 <= Node.val <= 105
 * 
 * 
 * 
 * 
 * 
 */