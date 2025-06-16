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

public class Insert {


     public TreeNode insertIntoBST(TreeNode root, int val) {


        // Base case if the root itself is null, then return the new node
        if(root == null){
            TreeNode temp = new TreeNode(val);
            root = temp;
        }
        
        // If the left condition is valid
       if(val < root.val && root.left == null){

        TreeNode temp = new TreeNode(val); // create a new node
        root.left = temp; // insert to left of the root

       }else if(val < root.val){
              insertIntoBST(root.left, val);
       }
     
     // if the right condition is valid
     if(val > root.val && root.right == null){
        TreeNode temp = new TreeNode(val); // create a new node
        root.right = temp; // insert to right of the root

     }else if(val > root.val){
       insertIntoBST(root.right, val);
     }

        return root; // By default we return the root 
    }
    
}

/*
 * There could be multiple ways to insert a node and return a valid binary search tree
 * But our solution will focus on inserting a new node at the leaf node or last level
 * We shall then return the root of the tree
 * This is one of the valid solutions but not the only solution
 * 
 * We will use DFS or recursive approach
 * 
 * We will go deep in the tree either or the left or right subtree
 * At every node, we will check for left <= root <= right case
 * 
 * If a node has no left child and current val <= root then we will insert it to the left of the root
 * if the node has a left child and current val is <= root, we will explore left subtree of the root node
 * 
 * If a node has no right child and current val >= root then we will insert it to the right of the root
 * If the node has a right child and current val >= root, we will explore right subtree of the root node
 * 
 * But it is a guarantee in the given question that value does not exist in the tree, 
 * so we no need to check <= or >= case. We can use < and > case 
 */


/*
  You are given the root node of a binary search tree (BST) and a value to insert into the tree. Return the root node of the BST after the insertion. It is guaranteed that the new value does not exist in the original BST.

Notice that there may exist multiple valid ways for the insertion, as long as the tree remains a BST after insertion. You can return any of them.

 
 * 
 * Input: root = [4,2,7,1,3], val = 5
Output: [4,2,7,1,3,5]
 * 
 * 
 * Input: root = [40,20,60,10,30,50,70], val = 25
Output: [40,20,60,10,30,50,70,null,null,25]
 * 
 * 
 * Input: root = [4,2,7,1,3,null,null,null,null,null,null], val = 5
Output: [4,2,7,1,3,5]
 

Constraints:

The number of nodes in the tree will be in the range [0, 104].
-108 <= Node.val <= 108
All the values Node.val are unique.
-108 <= val <= 108
It's guaranteed that val does not exist in the original BST.
 * 
 * 
 */