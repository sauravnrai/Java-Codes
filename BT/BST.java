class Node{

    int data;
    Node left;
    Node right;


    // Constructor to fill the node value
       Node(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }

}

 class BinaryTree{

    Node root = null;

 public void insert(int data) {
       
   root = insertRec(root, data); // gets hold of the latest node
       
    }

    public Node insertRec(Node root, int data){

        if(root == null){
          root = new Node(data); // creates root
        }else if(root.data > data){
           root.left = insertRec(root.left, data); // insert at left
        } else{
          root.right = insertRec(root.right, data); // insert at right
        }

        return root; // return the root node at the end
    }
    
 public int height() {
    return heightRec(root);
    }

    public int heightRec(Node root){

        int leftTree = 0;
        int rightTree = 0;

        if(root == null){
            return 0;
        }
        
        if(root.left != null){
            leftTree = 1 + heightRec(root.left); // since left node is available we add 1
        }
        
        if(root.right != null){
             rightTree = 1 + heightRec(root.right); // since right node is available we add 1
        }
      
          
            return  leftTree > rightTree ? leftTree : rightTree; // sends the height
        }
        

        
    public void inorder() {

        inorderRec(root);
                    
    }


    public void inorderRec(Node root){

        if(root == null){
            return;
        }else{
            inorderRec(root.left);
            System.out.print(root.data + " ");
            inorderRec(root.right);
        }

    }
                
     public void preorder() {

        preorderRec(root);
                                    
    }

    public void preorderRec(Node root){

        if(root == null){
            return;
        }else{
            System.out.print(root.data + " ");
            preorderRec(root.left);
            preorderRec(root.right);
        }

    }
                                
    public void postorder() {

        postorderRec(root);
                         
    }


    public void postorderRec(Node root){

        if(root == null){
            return;
        }else{
            
            postorderRec(root.left);
            postorderRec(root.right);
            System.out.print(root.data + " ");
        }

    }


                                                            
    }
                                                            
                                                            
                                                        
public class BST {
                                                            
    public static void main(String[] args) {
                                                                    
     BinaryTree bt = new BinaryTree();
        bt.insert(10);
        bt.insert(5);
        bt.insert(15);
        bt.insert(3);
        bt.insert(12);
      System.out.println("Height " +  bt.height());
      System.out.println("Inorder" );
       bt.inorder();
       System.out.println("\nPreorder" );
       bt.preorder();
       System.out.println("\nPostorder" );
       bt.postorder();
    }
    
}
