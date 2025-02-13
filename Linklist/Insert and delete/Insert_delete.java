class Node{
    int data;
    Node next;

     Node(int data){
        this.data = data;
        this.next = null;
    }
}

class LL{
    Node head;
    Node tail;
    int size = 0;

    void listSize(){
        System.out.println("The size of the list is " + size);
    }

    void display()
    {
        Node temp = head;

        while(temp!= null)
        {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }

        System.out.println("null");
    }


    void insert(int data){
        Node node = new Node(data);
        head = node;
        tail = head;
        size++;

    }
   
   void insertFirst(int data){

    if(head == null)
    {
        insert(data);
    }else{
        Node node = new Node(data);
        node.next = head;
        head = node;
        size++;
    }

   }

   void insertLast(int data){
    if(tail == null){
        insert(data);
    }else{
        Node node =  new Node(data);
        tail.next = node;
        tail = node;
        size++;
    }
   }

   void insertAt(int data, int index){

    if(index == 1){
        insertFirst(data);
    }else if(index > size){
        insertLast(data);
    }else{
        Node temp = head;

        for(int i=1; i < index - 1; i++)
        {
            temp = temp.next;
        }

        Node node = new Node(data);
        node.next = temp.next;
        temp.next = node;
        size++;
    }

   }


void deleteFirst(){
    Node temp;
    temp = head;
    head = head.next;
    temp.next = null;
    size--;
}

void deleteLast(){
    Node temp;
    temp = head;

    while(temp.next != tail){
        temp = temp.next;
    }
   
    tail = temp;
    tail.next = null;
    size--;

}

void deleteAt(int index){
    if(index == 1){
        deleteFirst();
    }else if(index == size){
        deleteLast();
    }else{
        Node temp1 = head;
        Node temp2 = head.next;

        for(int i=1; i< index-1; i++){
            temp1 = temp1.next;
            temp2 = temp2.next;
        }

        temp1.next = temp2.next;
        temp2.next = null;
        size--;
    }
}

}


class Insert_delete{
    public static void main(String args[]){
    
    LL list = new LL();
    list.insertFirst(10);
    list.insertLast(20);


    list.insertAt(5, 1);
    list.insertAt(30, 4);
    list.insertAt(15, 2); 
    list.insertFirst(0);
    list.insertLast(40);
    list.listSize();
    list.display();

    
    list.deleteFirst();
    list.display();
    list.deleteLast();
    list.display();
    list.deleteAt(3);
    list.display();
    list.listSize();

    }
}