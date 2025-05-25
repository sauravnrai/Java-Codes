

public class MaximumDepth {

    public int maxDepth(TreeNode root) {

        if(root == null) return 0;

        int height = Math.max(1 + maxDepth(root.left) , 1 + maxDepth(root.right));
        
        return height;
    }
    
}



/*
 * The question is to find the maximum depth of a binary tree which is nothing but its height. 
 * We can use a recursive method passing the root node at each function call and check for the maximum value
 * 
 * 
 * 
 * 
 * 
 */