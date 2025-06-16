
import java.util.ArrayList;
import java.util.List;


public class Inorder {

  public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> ans = new ArrayList<>();

        if(root == null) return ans;

        inorderTraverse(root, ans);
        
        return ans;
        
    }

    public static void inorderTraverse(TreeNode root, List<Integer> ans){
         
        // base case
        if(root == null) return;

       // Inorder traverse
        inorderTraverse(root.left, ans);
        ans.add(root.val);
        inorderTraverse(root.right, ans);

    }

    
}



/*
 * Given the root of a binary tree, return the inorder traversal of its nodes' values.
 * 
 * Input: root = [1,null,2,3]
   Output: [1,3,2]



   Input: root = [1,2,3,4,5,null,8,null,null,6,7,9]

   Output: [4,2,6,5,7,1,3,9,8]

   Input: root = []

   Output: []


   Input: root = [1]

   Output: [1]
 * 
 * 
 */