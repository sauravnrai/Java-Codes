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

public class ArraytoTree {

    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode temp = null; // initially root node is null
 
      temp = makeTree(temp, nums, 0, nums.length - 1); // creates a tree       

        return temp; // return root node
        
    }

    public TreeNode makeTree(TreeNode root, int[] nums, int left, int right){
      

    // base case if any index gets out of bound
    if(left > right) return null;

        int index = (left + right) / 2; 
    // gets the half of the index because root will be in middle of the node

        if(root == null) root = new TreeNode(nums[index]);
        // made the root node or parent node
        
        // Now that the root is made, we will have to build its left and right subtree
        root.left =  makeTree(root.left, nums, left, index - 1); // left subtree
       root.right = makeTree(root.right, nums, index + 1, right); // right subtree

       return root;
    }
    
}

/*
 * One such property of BST is if we do in-order traversal, then we will always get a sorted array in increasing order
 * We are already given a sorted array in increasing order and numbers are strictly increasing
 * 
 * If we look at the sorted array, we can find the root exactly at the center
 * The elements left of it will be in left subtree
 * The elements right of it will be in right subtree
 * 
 * So, initially sorted array will have a root that is center of the array, left of that element, and right of that element
 * 
 * Now, even in the left of the root node array, we can divide this array in root and left subtree and right subtree 
 * The root of this left subarray will be left child of the root of the tree
 * 
 * Similarly, the right subarray to the right of the root can again be divided into the root and left and right subarray
 * Now, the root of this right subarray will be the right child of the root of the tree
 * 
 * If we clearly, we are in a recursive process where base case will be the leaf nodes or array of size 1
 * We can construct the tree following this approach and ensure the height difference is never greater than 1
 * 
 * Code explanation
 * 
 * The solution uses a similar structure that of a binary search algorithm
 * The base cases is when left pointer crosses the right pointer, if that is the case then we return null
 * 
 * Every middle element in an index range of left and right becomes the root or parent
 * And the last elements always end up as leaves at a level
 * It is important to understand the base cases i.e left > right becuase this means we are moving out of bounds
 * 
 * The code returns the root node or parent node in the end
 */


/*
 * Given an integer array nums where the elements are sorted in ascending order, 
 * convert it to a height-balanced binary search tree.
 * 
 * Height-balanced tree means from root both left and right subtree height difference is not more than 1
 * 
 * A height-balanced binary tree is a binary tree in which 
 * the depth of the two subtrees of every node never differs by more than one.
 * 
 * Input: nums = [-10,-3,0,5,9]
Output: [0,-3,9,-10,null,5]
Explanation: [0,-10,5,null,-3,null,9] is also accepted:

Input: nums = [1,3]
Output: [3,1]
Explanation: [1,null,3] and [3,1] are both height-balanced BSTs.
 

Constraints:

1 <= nums.length <= 104
-104 <= nums[i] <= 104
nums is sorted in a strictly increasing order.
 * 
 */