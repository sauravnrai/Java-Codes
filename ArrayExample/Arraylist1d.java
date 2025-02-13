import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Arraylist1d {

    public static void main(String[] args) {

    ArrayList<Integer> arr = new ArrayList<>(); // Creates an arraylist

    arr.add(1); // adds item to the start of the list i.e at index 0
    arr.add(1, 2); // adds item to an index i.e index first then element later

    System.out.println(arr.get(0)); // gets the elements at that index

    arr.set(1, 15); // sets the elements at an index i.e index first, element later

    System.out.println(arr.remove(1)); //removes an element at an index and returns that index element
    // remove can take both vlaue and index

    arr.add(25);
    System.out.println(arr.size()); // gives the size of the arraylist

    System.out.println(arr.contains(25)); // takes an element or item to check if it is available in list
    System.out.println(arr.indexOf(25)); // gives the index of the first occurence element
    System.out.println(arr.lastIndexOf(25)); // gives the index of the last occurence element

    Collections.sort(arr); // sorts the array list via collections method called sort
    System.out.println(arr);
    arr.add(2, 50);

    List<Integer> subarr = arr.subList(0, 2); 
    //gives a sublist from a source index to destination index excluded using list collection


    
  
  
    System.out.println(subarr);
    arr.addAll(subarr); // adds the sublist at the end
    System.out.println(arr);


    // Please take a note of concurrent modification exception error on the original list
    arr.subList(0, 1).clear(); // removes the sublist from the array from source index to destionation index
    arr.isEmpty(); // checks if the arraylist is empty
        
    }
    
}
