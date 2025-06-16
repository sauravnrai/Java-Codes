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



public class AverageOfLevels {

    public List<Double> averageOfLevels(TreeNode root) {


        List<Double> ans = new ArrayList<>(); // to hold averages
        List<TreeNode> q = new LinkedList<>(); // to hold nodes at every level

        // Add the root by default
        q.addLast(root);
        
        while(! q.isEmpty() ){

            Double avg; // to caclulate avg of a level
            int size; // to track size of that level or number of nodes at that level
            long sum = 0; // sum to add all values at that level but we use long since adding numbers could take some extra space
            size = q.size();
           
           // Use the current size of the queue
           // Add next level nodes
           // Calculate sum
            for(int i=0; i<size; i++){
                TreeNode temp = q.removeFirst();

                if(temp.left != null) q.addLast(temp.left);
                if(temp.right != null) q.addLast(temp.right);

                sum = sum + temp.val;
            }

         System.out.println(sum + " " + size);
        avg = (double) sum / size ; // gets the avg but integer has to be converted to double first
        ans.add(avg); // adds that level avg to the list

        }

        return ans;
        
    }
}

/*
 * We will use a queue and BFS to solve this problem
 * 
 * At every level, we will add nodes, find their sum, 
 * keep track of size of the queue because it will give number of nodes at that level
 * then calculate the average of that level
 * 
 * The root node is added by default
 * We will use double to store average and long to store sum
 * We will use an additional list to add these averages and return the entire list
 * 
 * 
 * 
 */




/*
 * Given the root of a binary tree, return the average value of the nodes on each level in the form of an array. Answers within 10-5 of the actual answer will be accepted.
 * 
 * Input: root = [3,9,20,null,null,15,7]
Output: [3.00000,14.50000,11.00000]
Explanation: The average value of nodes on level 0 is 3, on level 1 is 14.5, and on level 2 is 11.
Hence return [3, 14.5, 11].
 * 
 * Input: root = [3,9,20,15,7]
Output: [3.00000,14.50000,11.00000]
 

Constraints:

The number of nodes in the tree is in the range [1, 104].
-231 <= Node.val <= 231 - 1
 */