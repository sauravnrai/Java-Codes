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

public class Search {

    public TreeNode searchBST(TreeNode root, int val) {
        
        if(root == null) return null; // base case if the node is no where found after exploring leaves

        if(root.val == val) return root; // case when node is finally found


        // based on value to search, we will either search left or right
        // We will return the node of that tree if it is found or else null
        // val < root.val will take the recusive call to left subtree if true or else to right subtree if false
        return val < root.val ? searchBST(root.left, val): searchBST(root.right, val);

        
    }
    
}


/*
 * We are supposed to search in the BST and return the node that contains the target value
 * 
 * We can either explore left or right tree since left node <= root <= right node
 * Based on the current value, we will either go to left subtree or right subtree
 * Once we find the node, we return node
 * If we don't we return null
 * 
 * Time complexity will be log n since we are searching in either left or right of each node
 * 
 * 
 */



/* 
You are given the root of a binary search tree (BST) and an integer val.

Find the node in the BST that the node's value equals val and return the subtree rooted with that node. If such a node does not exist, return null.
 * 
 * Input: root = [4,2,7,1,3], val = 2
   We will return node 2 Treenode

   Input: root = [4,2,7,1,3], val = 5
Output: null
 

Constraints:

The number of nodes in the tree is in the range [1, 5000].
1 <= Node.val <= 107
root is a binary search tree.
1 <= val <= 107
 * 
 */