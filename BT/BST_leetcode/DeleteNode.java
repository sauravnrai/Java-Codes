
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


public class DeleteNode {

    public TreeNode deleteNode(TreeNode root, int key) {

        if(root == null) return null; // base case if no tree

     root = Delete(root, key); // The method is used to delete the node 

        return root; // return root
        
    }

    // Method to delete the node
    public static TreeNode Delete(TreeNode root, int key){

        if(root == null) return null; // This is the case when the element in not present in the tree
     
     // If the element is in left of the tree
     if(root.val > key){
        root.left = Delete(root.left, key); // search in left
     } else if(root.val < key){
       root.right = Delete(root.right, key); // search in right
     }else{
        // when the key and node value are same

        // if the node or root has both children
        if(root.left != null && root.right != null){

            int max = Max(root.left); // find the max in the left subtree of the node

            root.val = max; // replace the root value with the max of the left subtree

           root.left = Delete(root.left, max); // delete that max element node in the left subtree

            return root; // return the root after the operation

            // We are removing the root or node and it gets replaced by max in left subtree
            // We do so becuase the node replacement will keep BST and its property intact

        }else if(root.left != null){
            // if the node has only left child
            return root.left;

            // We simply attach left child to nodes parent

        }else if(root.right != null){
            // if the node has only right child

            return root.right;
            // We simply attach the nodes right child to its parent

        }else{
              // when the node has no children
              return null;
              // when a node that we are searhcing for is leaf then we put null to its parent link either left or right
              // since we are using recursion, we don't worry about the left or right as it automatically gets updates
        }

     }


        return root; // returns the root i.e the first call because there might be no value to be deleted
          
    }
 
    // Method to find the max element in the left subtree of the node
    public static int Max(TreeNode root){

        int max_val;
        
        if(root.right != null){
          return max_val = Max(root.right); // moves to right to find the max
        }else{
            return root.val; // There is no right, so the node itself is max
        }
    
        
    }
    
}

/*
This is probably one of the most important question of BST
We will use recursion to solve this problem
The recursive approach will help us update links properly, either left or right and at the parent level

 * When we try to delete a node, we will end up in three cases
 * 
 * 1) Node has no children
 * 2) Node either has left or right child
 * 3) Node has both children
 * 
 * Case 1: When a node that we want to delete has no children, we simply return null to its calling function 
 * so that the parent can update the link part to null instead of that node
 * 
 * Case 2: When a node has either a left or right child, we we return the link or address of its children to the nodes parent
 * This way the parent of that node that we want to delete gets directly attach to its child and BST is still valid
 * The unlinking of the address of the node and re-aataching its child is only possible if the node has only 1 child
 * since, we are using recursion, only 1 link gets affected throughout the node
 * 
 * Case 3: This is the most important case
 * Here we need to delete in such a way that BST rules apply
 * We can either replace the node with its max value in left sub tree or min value in right subtree
 * We will choose max value in left sub tree
 * 
 * We will first find the max value in that tree
 * We will replace the current node value with that value
 * Then we will delete the max value from that left sub-tree
 * since, we are using the left subtree, the node to be deleted left link or left node is passed in the delete method
 * The node to be deleted is simply changes its value to the max value of the left sub tree
 * 
 * 
 * 
 */


/*
 * Given a root node reference of a BST and a key, delete the node with the given key in the BST. Return the root node reference (possibly updated) of the BST.

Basically, the deletion can be divided into two stages:

Search for a node to remove.
If the node is found, delete the node.
 
Input: root = [5,3,6,2,4,null,7], key = 3
Output: [5,4,6,2,null,null,7]

Explanation: Given key to delete is 3. So we find the node with value 3 and delete it.
One valid answer is [5,4,6,2,null,null,7], shown in the above BST.
Please notice that another valid answer is [5,2,6,null,4,null,7] and it's also accepted.

Input: root = [5,3,6,2,4,null,7], key = 0
Output: [5,3,6,2,4,null,7]
Explanation: The tree does not contain a node with value = 0.


Input: root = [], key = 0
Output: []
 

Constraints:

The number of nodes in the tree is in the range [0, 104].
-105 <= Node.val <= 105
Each node has a unique value.
root is a valid binary search tree.
-105 <= key <= 105



 * 
 */