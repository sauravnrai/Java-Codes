import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import javax.swing.tree.TreeNode;

public class Diameter {

      public int diameterOfBinaryTree(TreeNode root) {

         if(root == null) return 0;

         int diameter = 0;

        Map<TreeNode, Integer> map = new HashMap<>();

        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.addLast(root); // always add root by default
    
         while(!stack.isEmpty()){
            TreeNode node = stack.getLast(); // peeks at the top of the stack

            // Post order way to add these nodes
            if(node.left!= null && !map.containsKey(node.left)){
                stack.addLast(node.left);
            } else if(node.right!= null && !map.containsKey(node.right)){
                stack.addLast(node.right);

            }else{

                node = stack.removeLast(); // removes the leaf node

                int leftDepth = map.getOrDefault(node.left,0); // Gets left Depth for a node, 0 for leaves
                int rightDepth = map.getOrDefault(node.right, 0); // Gets right Depth for a node, 0 for leaves

                map.put(node, 1 + Math.max(leftDepth, rightDepth)); // Sets the Depth for the popped node using its left and right depth
                
                diameter = Math.max( diameter, leftDepth + rightDepth); // gets the current diameter for the tree
            }



         }

        return diameter; 
        
        
    }

}


/*
We can use recursion but it will cause a lot of confusion to solve the problem

 * We can follow a stack and a map in an iterative approach to solve this problem
 * The depth is the maximum distance between two nodes in the tree
 * It may or may not include root node 
 * 
 * Both Left-subtree and Right-subtree are used as problem in itself
 * 
 * The map is used to store the node and the maximum depth of that node
 * The stack is used to push these nodes. We will be using a post-order traversal to solve this problem using a stack
 * We will keep pushing the elements in the stack until we reach the leaf node
 * 
 * The root node needs to be processed at the last in the last. Same in recursion, root it always the last calling for the recursion
 * In recursion, we usually go to the left and then right, similarly, we will push left node and right node
 * In recursion, when we hit a leaf, we do some computation
 * Similarly in stack, we will do computation when we hit the leaf node
 * 
 * The recursion ends when all the stack calls are completed
 * Similarly, here the iteration will end when stack is empty
 * 
 * The default depth of all nodes are 0 and diameter is 0
 * We will use map to update the depths
 * 
 * In the proposed solution, we are using a stack, a map, and while loop
 * The loop will run until the stack is empty
 * The root is pushed on the stack by default
 * 
 * We will use the peek or getFirst method to see the top of the stack
 * Now, we will use post-order i.e always push left then right using if-else
 * The condition at if-else is if left child is not null and depth is not known in map, then push on the stack
 * 
 * If left child is not present, then push the right child on the stack only if it is present and its depth is not known in the map
 * 
 * If the node does not have any children, then we pop it
 * We also pop the node, if its left and right chil were in the map using ContainsKey method
 * This if post-order traversal indeed
 * 
 * We use the default value to first check its depth using getOrDefault() method with left child or 0 and right child or 0
 * If a node has a children, then left depth will be left child depth and right depth will be right child depth
 * For a leaf node, initially it is 0
 * After the operation, leaf node is updated to 1
 * 
 * We will use map.put to set the depth of that node that was popped from the stack
 * node, 1 + Math.max(leftDepth, rightDepth)
 * 
 * The diameter is also updates with max between the popped node depth or the exisitng diameter
 * Initially diameter is 0
 * We do this since it is node necessary that root node will be part of the diameter
 * 
 * We continue the entire process until all the stack is empty
 * 
 * 
 */


/*
 * The diameter of a binary tree is defined as maximum distance from any one node of the tree to another node
 * 
 * Addition of left subtree height anf right subtree height will give diameter from the root
 * But this will only be case if the root is part of the diameter
 * It is not necessary that root will always be part of the diameter
 * Diameter of a binary tree may not contain the root and this condition should be known before we move forward to code
 * 
 *In other words, diameter may not contain root at all
 So, we have to find maximum height at all levels, and then look for the max value overall
 Each node will behave like a root node
 * 
 * 
 * Another point to note is height and depth are not the same thing
 * Height of the tree can be calculated from the root
 * But depth of the tree is nothing but its height
 * But depth of a node depends on its children
 * 
 * To find the diameter of the tree, we need to find the depth of each node
 * Diameter of the tree is depth of the tree will be depth of left tree + depth of right tree
 * 
 * For example [1, 2, 3, null, null, 4, 5]
 * 
 * We have a tree whose root is 1, 2 and 3 are its children, and 3 has 4 , 5 as its children
 * From root 1, it may appear that left + right height will give diameter which is not a correct deduction
 * 
 * The leaves are always at depth 1
 * 2 is depth 1 since it is a leaf
 * 4 and 5 are at depth 1 since they are leaf
 * 3 is at depth 2 from its deepest children i.e depth of left + depth of right
 * 
 * We can see, though 2 and 3 are on the same level, depths are different
 * 
 * Now, 1's depth will be 3 because of node 3's depth
 * 
 * 
 * Most important point to note is depth of all leaves is always 1, no matter at what level they are
 * diamater of a tree is addition of depth from left and depth from right
 */

 /*
 Special Note
  * For root that has null, diameter will be 0
    For root that has only 1 node, diameter will be 0
    For root with two nodes, diameter will be 1
    So, we also need to have a look on the node's parent as well

  */