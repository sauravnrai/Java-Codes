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


public class BinaryTreePath {

    public List<String> binaryTreePaths(TreeNode root) {

        List<String> path = new ArrayList<>(); // array list to store all paths as strings
       
       pathLeaf(root, path, ""); // method call to find all paths
       //method to find all the paths

        return path; // return list
        
    }

    public void pathLeaf(TreeNode root, List<String> path, String str){

        if(root.left == null && root.right == null) path.add(str + "" + root.val); // if the node is leaf, then just add that node in the incoming string

      if(root.left != null) pathLeaf(root.left, path, str + "" + root.val + "->"); // if the node has a left child
      if(root.right != null) pathLeaf(root.right, path, str + "" + root.val + "->"); // if the node has a right child
    }
    
}


/*
This solution is probably not the optimal solution but it does solve the problem

We are suppose to find the path from root to leaf and document it as an string
Since, there will be multiple paths from root to leaf nodes, we are suppose to return a list of strings

We will only explore left or right, if that left or right is present
If we hit a leaf node, we won't explore it further

The above code does the same
 * 
 There might be a faster approach since we are creating too many string objects in our string pool
 We could optimize it using string builder
 * 
 * 
 */



/*
 * Given the root of a binary tree, return all root-to-leaf paths in any order.

A leaf is a node with no children.
 * 
 * 
 * Input: root = [1,2,3,null,5]
Output: ["1->2->5","1->3"]

Input: root = [1]
Output: ["1"]
 

Constraints:

The number of nodes in the tree is in the range [1, 100].
-100 <= Node.val <= 100
 * 
 */