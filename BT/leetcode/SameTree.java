import java.util.LinkedList;

import javax.swing.tree.TreeNode;

public class SameTree {

    public boolean isSameTree(TreeNode p, TreeNode q) {

        if(p == null && q == null) return true;
        if(p==null || q== null) return false;

        LinkedList<TreeNode> q1 = new LinkedList<>();
        q1.addLast(p);
        LinkedList<TreeNode> q2 = new LinkedList<>();
        q2.addLast(q);
        
        ArrayList<Integer> a1 = new ArrayList<>();
        ArrayList<Integer> a2 = new ArrayList<>();

        while(!q1.isEmpty()){
            TreeNode temp;
            int size = q1.size();

            for(int i=0; i<size; i++){
                temp = q1.removeFirst();

                if(temp == null){
                    a1.add(Integer.MIN_VALUE); 
                }else{
                a1.add(temp.val);
                 q1.addLast(temp.left);
                 q1.addLast(temp.right);
                }


            }

        }

        while(!q2.isEmpty()){

            TreeNode temp;
            int size = q2.size();

            for(int i=0; i<size; i++){
                temp = q2.removeFirst();

                if(temp == null){
                    a2.add(Integer.MIN_VALUE); 
                }else{
                a2.add(temp.val);
                 q2.addLast(temp.left);
                 q2.addLast(temp.right);
                }

        }

       
        
    }

     return a1.equals(a2);
    
}


/*
 * We need to return if two given trees are same or not
 * We can parse both trees level wise using two queues, one for each and then compare them in the end
 * If the trees are same, they contents will be same
 * We will use -1 for the null nodes
 * 
 * 
 * 
 * 
 * 
 */