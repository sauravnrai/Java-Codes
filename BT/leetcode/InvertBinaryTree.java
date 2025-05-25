import java.util.LinkedList;

public class InvertBinaryTree {
    
    public TreeNode invertTree(TreeNode root){

        if(root == null) return null;

        LinkedList<TreeNode> q = new LinkedList<>();
        q.addLast(root);

        while(!q.isEmpty()){

            int length = q.size();
            
            TreeNode node;
            TreeNode temp;
           
            node = q.removeFirst();

               if(node.left != null) q.addLast(node.left);
               if(node.right != null) q.addLast(node.right);

               temp = node.left;
               node.left = node.right;
               node.right = temp;
              
        }
    return root;

    }
    
}



/*Solution to the problem
 * 
 * We have to switch places of these nodes from left to right at each level
 * 
 * This will take a queue data structure but it is not all about replacing like to like
 * We also have to take care of null values i.e null value at left will appear or right and vice versa
 * Right skewwed tree will be left skewwed and vice-versa
 * It will take atleast two variables for each node to set things right
 * 
 * 
 * There are two ways we can solve this
 * Recursion
 * Level-order using a queue and swapping
 * 
 * If we are using recursion, we will be inverting the links
 * 
 * If we are using a level-order, then we will be swapping nodes at individual node's children
 * The proposed solution is level-order solution but recursion solution is also added in the comments for understanding purpose
 * The same level-order solution is uploaded on leet code
 * 
 */

 /*
  * Level-order traversal O(n) time complexity

  In this solution, we will use a queue and add elements level wise

  We will only use a single loop since we just have to invert children of each node
  
  The base case will be root == null

  If the root is not null, we will add it in the queue by default
  We will use a temporary variable for swapping


  The present node is deleted from the queue first
  We will add its children in the queue first, then swap them
  After swapping the element, the loop will start from the children

  We will repeat this process until queue is empty


  */


 /*
  * Recursion solution

  public TreeNode invertNode(TreeNode root){

  // Base case to stop recursion
  if(root == null) return;

  TreeNode left = invertNode(root.left);
  TreeNode right = invertNode(root.right);

  root.left = right;
  right.right = left;

  return root;
  }


  Let us say we have this B.T [4, 2, 7, 1, 3, 6, 9]

  root is 4
  2 is left and 7 is right
  The recursion call will be on 2 and followed by 7

  On 2, we have node 1 and 3. 1 and 3 are leaves so there we will be swapped 
  2's left child will be 3 and right will be 1

  On 7, it will be 9 on left and 6 on right

  Now, we will swap 2 and 7

  So, 7 will come to left of 4 along with its child and 2 will come to right along with its child

  Now, B.T will be [4, 7, 2, 9, 6, 3, 1]


  */

/* 
 * If a binary tree has root at 4, next level 2, 7, next level 1, 3, 6, 9
 * then result should be root at 4, next level 7, 2, next level 9, 6, 3, 1
 *
 * Input: root = [4,2,7,1,3,6,9]
Output: [4,7,2,9,6,3,1]
 * 
 * 
 */