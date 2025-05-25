import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class LevelOrder {

     public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> ans = new ArrayList<>();
        
        int index = 0; // to check the new list in the array list

        LinkedList<TreeNode> q = new LinkedList<>();
        q.addLast(root);

        if(root == null) return ans;

        while(!q.isEmpty()){
         
            ans.add(new ArrayList<>()); // creates a new list to add nodes of that level
            TreeNode temp;
            int size = q.size();

            for(int i=0; i<size; i++){
                temp = q.removeFirst(); // removes the node
                ans.get(index).add(temp.val); // adds the removed node value

                // pushes left and right child of the node in queue
                if(temp.left != null) q.addLast(temp.left);
                if(temp.right != null) q.addLast(temp.right);
            }

            index ++; // for the new level, index is also updated

        }

    return ans;
        
    }
    
}



/*
 * 
 * The problem is to find the level-order of a binary tree and return it as the list of list
 * So, level 1 as a single list
 * Level 2 as a single list and so on
 * 
 * We will use a list of list initialized as a new Arraylist and a queue to keep track of all the level order nodes
 * We will run a loop to check if the queue is empty and an index value to insert new values in the list
 * At each iteration, we will add a new empty list and begin the process
 * At the end, we will return the list of list
 * 
 */