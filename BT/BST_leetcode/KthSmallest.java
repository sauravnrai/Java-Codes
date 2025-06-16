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


public class KthSmallest {

    private int counter; // global variable to store counter
   private int result; // global variable to store the result

    public int kthSmallest(TreeNode root, int k) {
        
        counter = k;
        Element(root); // inorder traversal method to catch the element
        return result; // return the result
        
    }

    // Please note that we are using a non-static method because we are using global variables
    // Performing any action on global variables in static gives the below error
    // Error: Cannot make a static reference to a non-static field

    public void Element(TreeNode root){
        if(root == null) return ; 
        // if the node is null then do not visit ans we just return
        // since the return type is void, we just return


        Element(root.left); // left visit of the root

        counter--; // visit to the root itself, so decrement counter

        if(counter == 0){
            result = root.val; // if counter is 0, then root itself is kth smallest
            return; // since element is found, we return
            }


        Element(root.right); // right visit
    }
    
}

/*
Solution to the problem

 * The initial thoughts might be let's traverse the entire left subtree and get the kth smallest element
 * But it will not be the case all the time as exceptions like right-skewed tree also exists
 * This problem requires a better approach that could get kth smallest element on any type of BST
 * 
 * One appraoch would be to do in-order traversal since inorder traversal on BST gives sorted array in increasing order
 * Then we may pick that kth element from the array
 * Though this is correct solution, it might be slow in nature and it does adds an extra space
 * 
 * We can have a recursive approach to solve this problem with a counter equal to K
 * 
 * A node that is caught at counter 0 will be our solution. But what is this algoirthm all about?
 * 
 * We will do an inorder traversal in recursive way but we won't using an extra space like array
 * 
 * Initially at root, we will have the counter equal to k
 * We know that smallest is found in left side, so we will first move to left
 * Once we come back, we will reduce the k by 1 because now node itself is getting views
 * Then we will move to its right
 * 
 * But here is the catch, we won't update k if the node is null
 * And when we visit a node back and if the value of k is updated to 0 then 
 * that is our kth smallest element to be returned
 * 
 * This solution can also be extended to kth largest element of the BST which uses the same approach
 * 
 * In our current solution, we are using two global variables by name counter and result 
 * We are using these two variables because we don't want to deal with links 
 * This appraoch is clean and exits the method when the element is found
 * 
 * 
 * 
 */


/*
 * Given the root of a binary search tree, and an integer k, return the kth smallest value (1-indexed) of all the values of the nodes in the tree.

 Input: root = [3,1,4,null,2], k = 1
Output: 1
 * 
 * Input: root = [5,3,6,2,4,null,null,1], k = 3
Output: 3
 

Constraints:

The number of nodes in the tree is n.
1 <= k <= n <= 104
0 <= Node.val <= 104
 

Follow up: If the BST is modified often (i.e., we can do insert and delete operations) and you need to find the kth smallest frequently, how would you optimize?
 * 
 */