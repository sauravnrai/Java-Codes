import java.util.ArrayList;
import java.util.Collections;

class Node{
     int data;
     Node link;

    Node(int data){
        this.data = data;
        this.link = null;
    }
}



class Stack{

    Node top;
    int size = 0;

    void insertFirst(int data){
        top = new Node(data);
        size++;
    }

    void push(int data){
        if(top == null){
            insertFirst(data);
        }else{
            Node temp = new Node(data);
            temp.link = top;
            top = temp;
            size++;
        }
    }

    void pop(){
        System.out.println(top.data + " removed from stack");
         Node temp = top;
        top = top.link;
        temp.link = null;
        size--;

    }

    void peek(){
        System.out.println(top.data + " is at the top of the stack");
    }

  void stackSize(){
    System.out.println("The size of the stack is " + size);
  }


 void display(){
    Node temp;
    temp = top;

    ArrayList<Integer> list = new ArrayList<>();

    while(temp!= null){
        list.add(temp.data);
        temp = temp.link;
    }

    Collections.reverse(list); // order of insertion in the stack
    System.out.println(list);
 }
} 



class CustomStack{
    public static void main(String args[]){

        Stack st = new Stack();
        st.push(10);
        st.push(50);
        st.push(5);
        st.display();
        st.stackSize();
        st.peek();
        st.pop();
        st.display();
        st.stackSize();

    }
}