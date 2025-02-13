class Node{
    int data;
    Node next;

    Node(int data)
    {
      this.data = data;
      this.next = null;


    }
}


class LL{
    int size = 0;
    Node head;
    Node tail;
 
   
   void firstNode(int data) {

    head =  new Node(data);
    tail = head;
    size++;
     
   }

    void insertFirst(int data)  {

        if(size == 0)
        {
          firstNode(data);
        }
        else
        {
          Node temp = new Node(data); //  new node
          temp.next = head; // links at the head
          head = temp; // update head
          size++; // update size
        }

    }

    void insertLast(int data) {

     if(size == 0)
        {
          firstNode(data);
        }
        else
        {
          Node temp = new Node(data); // new node
          tail.next = temp; // links at the end
          tail = temp; // update tail
          size++; // update size
        }
    }
   
  
    void insertAt(int data, int index) {
      if(index == 1){
        insertFirst(data);

      }else if(index > size){
        insertLast(data);

      }else{

        Node temp = head;

        for(int i = 1 ; i<index - 1; i++)
        {
          temp = temp.next;
        }

        Node node = new Node(data);
        node.next = temp.next;
        temp.next = node; 
        size++;

      }

    }

    void display() {
      Node temp;

      temp = head;

      while(temp!= null)
      {
        System.out.print(temp.data +"->");
        temp = temp.next;
      }
     System.out.println("null");
    }

void listSize(){
  System.out.println("size of the list is " + size);
}

}

class Insert{

    public static void main(String args[]){

      LL list = new LL();
      list.insertFirst(5);
      list.insertLast(7);
      list.insertAt(11, 1);
      list.insertAt(15, 4);
      list.display();
      list.insertAt(21, 2);
      list.listSize();
      list.display();


    }
}