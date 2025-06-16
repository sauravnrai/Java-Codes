

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



public class PathSum {

    public boolean hasPathSum(TreeNode root, int targetSum) {

        if(root == null) return false; // if the root is null, return false
        
        // if the root is leaf and equal to target sum, then return true
        if(root.left == null && root.right == null && root.val == targetSum) return true;

    // recursive call where every node explores it left and right
    // In order to explore its children, we will subtract that node value from current target sum
    // If we find any path that leads to target then we will return true
    return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
        
    }
    
}

/*
 * We are suppose to check if there exist a path such that root to leaf gives us target sum
 * We will use DFS or recursive approach
 * We will check if the current root is null, if it is then return false
 * If a leaf node is present and equal to current target sum, then we will return true
 * 
 * At every node, we will explore its left and right
 * The current node value will be subtracted from the target sum before exploring children
 * We will use an || operator or logical OR since we are searching for atleast 1 such path
 * If we hit one such path, then overall result will be true
 * 
 * 
 * 
 */


/*
 * Given the root of a binary tree and an integer targetSum, return true if the tree has a root-to-leaf path such that adding up all the values along the path equals targetSum.

A leaf is a node with no children.
 * 
Input: root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
Output: true
Explanation: The root-to-leaf path with the target sum is shown.
 * 
 * 
 * Input: root = [1,2,3], targetSum = 5
Output: false
Explanation: There are two root-to-leaf paths in the tree:
(1 --> 2): The sum is 3.
(1 --> 3): The sum is 4.
There is no root-to-leaf path with sum = 5.



Input: root = [], targetSum = 0
Output: false
Explanation: Since the tree is empty, there are no root-to-leaf paths.
 

Constraints:

The number of nodes in the tree is in the range [0, 5000].
-1000 <= Node.val <= 1000
-1000 <= targetSum <= 1000
 * 
 */