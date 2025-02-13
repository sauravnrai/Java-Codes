import java.util.LinkedList;

public class InbuiltLL {

    public static void main(String[] args) {

        LinkedList<Integer> l = new LinkedList<>();

        l.add(5); // adds at the end of the list
        l.addFirst(10); // adds at the first
        l.addLast(20); // adds at last
        l.isEmpty(); // checks if the list is empty

        System.out.println(l);

        l.removeFirst(); // removes the first element
        l.removeLast(); // removes last element
        l.size(); // gives size of the list
        l.remove(0); // removes element at first index since index is 0

        System.out.println(l);
        l.add(5); // adds at the end of the list
        l.addFirst(10); // adds at the first
        l.addLast(20); // adds at last



        System.out.println(l.peekFirst()); // gives peek at first element
        System.out.println(l.peekLast()); // gives peek at last element

        l.get(2); // gets element at index at 2
        l.getFirst(); // gets element at first index
        l.getLast(); // gets element at last index

        l.contains(5); // gives a boolean if the item is present in list

        
    }
    
}
