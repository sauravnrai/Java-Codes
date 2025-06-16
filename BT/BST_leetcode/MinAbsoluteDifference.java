import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import javax.swing.tree.TreeNode;

public class MinAbsoluteDifference {

    public int getMinimumDifference(TreeNode root) {

        int difference = Integer.MAX_VALUE;

        List<TreeNode> q = new LinkedList<>();
        q.addLast(root);

        List<Integer> ans = new ArrayList<>();

        while( ! q.isEmpty()){
            int size = q.size();
            TreeNode temp;

            for(int i=0; i<size; i++){
                temp = q.removeFirst();
                ans.add(temp.val);

                if(temp.left != null) q.addLast(temp.left);
                if(temp.right != null) q.addLast(temp.right);
            }
        }
        
       
       Collections.sort(ans);

       for(int i=0; i < ans.size() - 1; i++){
             int j = i + 1;

    if( Math.abs(ans.get(i) - ans.get(j)) < difference  ) difference = Math.abs(ans.get(i) - ans.get(j));
       }


        return difference;
    }
    
}

/*
 * 
 * We can solve this using DFS or recursion or BFS with a queue
 * 
 * If we use DFS or recursion, we will find difference at every node's left and right child
 * At every parent that has atleast one children, we will find the difference between parent and node and return the lowest
 * Record the lowest and return it
 * 
 * 
 * But the current solution uses BFS level order using a queue
 * We are storing all elements in a arraylist processed via a queue
 * We will sort this arraylist and then find the minimum absolute difference using two pointer and a loop
 * This level order traversal approach is slower in comparison to DFS
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */


/*
 * Given the root of a Binary Search Tree (BST), return the minimum absolute difference between the values of any two different nodes in the tree.

 Input: root = [4,2,6,1,3]
Output: 1
 * 
 * 
 * Input: root = [1,0,48,null,null,12,49]
Output: 1
 

Constraints:

The number of nodes in the tree is in the range [2, 104].
0 <= Node.val <= 105
 * 
 */