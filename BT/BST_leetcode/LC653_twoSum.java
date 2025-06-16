import java.util.ArrayList;
import java.util.LinkedList;
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

public class LC653_twoSum {

     public boolean findTarget(TreeNode root, int k) {
   
    LinkedList<TreeNode> q = new LinkedList<>(); // list or queue to contain all node
    q.addLast(root); // add root by default
   
    List<Integer> ans = new ArrayList<>(); // list to store arrays
 
 // Level order traversal
    while(! q.isEmpty() ){
        int size = q.size(); // gets queue size
        TreeNode temp;

        for(int i=0; i<size; i++){
            temp = q.removeFirst(); // removes first node of queue

            if(temp.left != null) q.addLast(temp.left); // adds left child
            if(temp.right != null) q.addLast(temp.right); // adds right child
             
             ans.add(temp.val); // add value to the list
        }
    }
      
    // loop to find the two sum
      for(int i=0; i< ans.size(); i++){
        int temp = ans.get(i); // gets the element on that index

        if(ans.contains(k - temp) && ans.indexOf(k - temp) != i) return true;
        // contains run in O(n) complexity making solution n-square complexity
        // We will find the two sum using contains methos
        // We will also ensure that same element is not used for two sum
      }


        return false;
        
    }
    
}


/*
 * We will use BFS with queue to get level-order
 * We will store all these nodes in an arrayList
 * After storing this in an arraylist, we can use the traditional two sum approach to get the solution
 * 
 * The solution takes O (n-square) appraoch which can be avoided using map or two pointers
 * since we have used contains, it is given n-square time complexity
 * We have solved the problem using level order, queue, and array list
 */


/*
 * 
 * Given the root of a binary search tree and an integer k, return true if there exist two elements in the BST such that their sum is equal to k, or false otherwise.

 Input: root = [5,3,6,2,4,null,7], k = 9
Output: true

Input: root = [5,3,6,2,4,null,7], k = 28
Output: false
 

Constraints:

The number of nodes in the tree is in the range [1, 104].
-104 <= Node.val <= 104
root is guaranteed to be a valid binary search tree.
-105 <= k <= 105
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */