import javax.swing.tree.TreeNode;

public class LCA {

     public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        if(root == null) return null; // base case

        if(root == p || root == q) return root; // if p or q are equal to root, return root

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
       
       if(left == null) return right;
      else if(right == null) return left;

      
      return root;

      }
    
}


/*
 * This is leetcode 235 problem
 * 
 *  Solution to the problem
 * Let us say we have a tree
 * 3 as root
 * 4 and 5 as immediate children to root
 * and 7 , 8 as child of 4
 * 
 * If we want to find Lowest common ancestor, a node should be ancestor to given two nodes
 * and it should be the lowest. A node can be ancestor to itself
 * 
 * So, if we supposed to find LAC of 7 and 5 then it is 3 that is root
 * If we are asked to find LAC of 4 and 7 then it is 4
 * LAC of 7, 8 is also 4
 * 
 * If we look at the problem, we are actually going for two paths from the root
 * Both left and right
 * If we get anything back from both left and right then root is LAC
 * 
 * But we may not get anything in one of the subtree and both elements can be in a single sub-tree
 * for that, we will skip the null part of the return value from a subtree, and return another subtree answers as LAC
 * 
 * if left subtree return null, then right subtree answer is LAC
 * if right subtree return null, then left subtree answer is LAC
 * The LAC is that node that has both non-null values from its left and right subtree
 * 
 * Base case will be if root is null, then return null
 * if one of the node is root, then root is LAC
 * 
 * This is a recursive appraoch and both space and time complexity is O(n)
 * 
 * We can trace the code on different examples for a better understanding
 * 
 * 
 * 
 */


 /*
  * Given a binary search tree (BST), find the lowest common ancestor (LCA) node of two given nodes in the BST.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”

Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
Output: 6
Explanation: The LCA of nodes 2 and 8 is 6.


Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
Output: 2
Explanation: The LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.

Input: root = [2,1], p = 2, q = 1
Output: 2
 

Constraints:

The number of nodes in the tree is in the range [2, 105].
-109 <= Node.val <= 109
All Node.val are unique.
p != q
p and q will exist in the BST.

  */