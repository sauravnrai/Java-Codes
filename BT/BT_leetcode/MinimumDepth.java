

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




public class MinimumDepth {

public int minDepth(TreeNode root) {

        if(root == null) return 0;

        if(root.left == null && root.right == null) return 1;

        int height;
        int left = Integer.MAX_VALUE;
        int right = Integer.MAX_VALUE;

        if(root.left != null) left = 1 + minDepth(root.left);
        if(root.right != null) right = 1 + minDepth(root.right);

        height = Math.min(left, right);
       

    return height;

        
    }

    
}

/*
 * Solution to the problem
 * 
 * We need to find the closest leaf node from the root
 * We could have used queue and BFS, but for this we have decided to use DFS or recursion
 * If the root is null, then we return 0
 * 
 * If a node is leaf, we won't explore its left and right and we will return 1
 * 
 * But what if the node is not leaf?
 * At every node, we will find left and right height
 * This height will be recursive in nature until we hit the leaf from left or right
 * When we hit the leaf from left or right, we can get two leaf node but our aim is to get nearest leaf
 * So, we will store the minimum of left and right
 * 
 * We will only explore left of a node if the left node is available
 * We will only explore right of a node if the right node is available
 * 
 * initially, left and right will be maxed out for every node
 * 
 * 
 */

/*
 * 
 * Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

Note: A leaf is a node with no children.
 * 
 * Input: root = [3,9,20,null,null,15,7]
Output: 2



Input: root = [2,null,3,null,4,null,5,null,6]
Output: 5
 

Constraints:

The number of nodes in the tree is in the range [0, 105].
-1000 <= Node.val <= 1000
 * 
 */