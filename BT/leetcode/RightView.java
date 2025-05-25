
/* 

The roote definition of the TreeNode

public class TreeNode {
int val;
  TreeNode left;
      TreeNode right;

      TreeNode() {}

      TreeNode(int val) { this.val = val; }

      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
      
  */

import java.util.LinkedList;

import javax.swing.tree.TreeNode;

public class RightView {

    public static void main(String[] args) {

        System.out.println("Main logic is written in another class of this java file to be runned on leetcode directly");
        
    }
    
}

class Solution {
    public List<Integer> rightSideView(TreeNode root) {

        ArrayList<Integer> ans = new ArrayList<>();

        if(root == null) return ans;
    
        LinkedList<TreeNode> q = new LinkedList<>(); // Linkedlist to hold nodes of the tree
        q.addLast(root); // adds root

        while(!q.isEmpty()){

            int levelSize = q.size();
            int lastValue = 0;

            // It will cover all the levels
            for(int i=0; i<levelSize; i++){
                TreeNode node = q.removeFirst();
                lastValue = node.val;

                if(node.left != null) q.addLast(node.left);
                if(node.right != null) q.addLast(node.right);
            }

        ans.add(lastValue);

        }

        return ans;
    }
}

/* Solution for the problem

Run this code directly on the leetcode

The problem requires us to give right view of the tree

We can follow level-order traversal at each level and add the rightmost node in the array list
This is a BFS approach for the solution

If we are using a queue, we will add the root by default which gives 1st level, using root then its children which gives 2nd level
Using roots its children one after the another, we will add next level children and so on
We will populate the entire queue

The level size will be equal to the queue size

The most part is to catch the last element in this process, that is right view

If we asked for the left view, we will add the first value


The right tree will contain all those nodes that are visible from right. So, it is not necessary that all nodes will occur on right

Rather, it is all about the level and where this node is available. The maximum level is nothing but the height of the tree + 1


In the leetcode solution, we will be running two loops. One loop to add nodes in the queue and another loop to check if the queue is empty
We will use the parent nodes to add children nodes at next level in the queue
We will use their values and add them in the arraylist but only last value gets added
To only add the last value, we will use a seperate variable
We will also track the queue size which will give the number of nodes at a level
The inner loop is responsible for pushing all the nodes at a level in the queue
initial queue size before starting a new level will help us identify that last element in the queue to be added in the list

*/

/* 

 * Given the root of a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

 

Example 1:

Input: root = [1,2,3,null,5,null,4]

Output: [1,3,4]
 * 
 * 
 Input: root = [1,2,3,4,null,null,null,5]

Output: [1,3,4,5]
 * 
 * 
 */
