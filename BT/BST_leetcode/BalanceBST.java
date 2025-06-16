import java.util.ArrayList;
import java.util.Collections;
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

public class BalanceBST {

public TreeNode balanceBST(TreeNode root) {

    List<TreeNode> q = new LinkedList<>(); // queue to process the BST
        q.addLast(root);

        List<Integer> ans = new ArrayList<>(); // arraylist to store the values
       
       // Level order traversal
        while( ! q.isEmpty()){
            int size = q.size();
            TreeNode temp;

            for(int i=0; i<size; i++){
                temp = q.removeFirst();
                ans.add(temp.val);

                if(temp.left != null) q.addLast(temp.left);
                if(temp.right != null) q.addLast(temp.right);
            }
        }
        
       
       Collections.sort(ans); // sorts the array list in increasing order

       TreeNode temp = null;

       temp = MakeBST(temp, ans, 0, ans.size() - 1); // function call to make the BST balanced

       return temp;
        
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
Solution to the problem

 * We will using level order traversal to get all the nodes val in a arraylist
 * Then we will sort this arraylist in increasing order
 * Now, we can use a recursive approach to build a new BST such that new BST is balanced
 * The process of making a new tree is similar to sorted Array to binary search Tree problem on leetcode
 * In the end, we will return the root of the new tree
 * 
 * This approach seems to be a bit slow in comparison to other approaches on the leetcode
 * The problem has been solved but it is a bit slow, if necessary, refer online for making the exisitng solution faster
 * The intution behind the problem is correct but it is slow in nature
 * 
 * 
 */



/*
 * 
 * Given the root of a binary search tree, return a balanced binary search tree with the same node values. If there is more than one answer, return any of them.

A binary search tree is balanced if the depth of the two subtrees of every node never differs by more than 1.
 * 
 * Input: root = [1,null,2,null,3,null,4,null,null]
Output: [2,1,3,null,null,null,4]
Explanation: This is not the only correct answer, [3,1,4,null,2] is also correct.


Input: root = [2,1,3]
Output: [2,1,3]
 

Constraints:

The number of nodes in the tree is in the range [1, 104].
1 <= Node.val <= 105
 * 
 * 
 */