import java.util.HashMap;
import java.util.Map.Entry;


public class HMdemo {

    public static void main(String[] args) {

        HashMap <Integer, String> map = new HashMap<>(); // declared a hash mao
 
        // Insert Value
        map.put(1, "Sam");
        map.put(2, "ram");
        map.put(3, "cam");

        System.out.println("map: " + map);

        // putall() uses a hash map to insert its data in another map
        // putIfAbsent() is a method to check first then insert later

        System.out.println("Value at key 1: " + map.get(1));
        System.out.println("Key set of map: " + map.keySet());
        System.out.println("Value set of map: " + map.values());
        System.out.println("Key-value pair or entry set of map: " + map.entrySet());


      // To replace a value at a key, we use replace() method with key and its new value
     // We also have a replaceAll() method

     map.remove(2); // removes key value pair at index 2
    
     System.out.println("New size after removing key 2: " + map.size());
     System.out.println("does the map has a key by 2: " + map.containsKey(2));
     System.out.println("does the map has a value Sam: " + map.containsValue("Sam"));
     System.out.println("Is the map empty: " + map.isEmpty());

    // iterate through keys only
    System.out.print("Keys: ");
    for (Integer key : map.keySet()) {
      System.out.print(key);
      System.out.print(", ");
    }

    // iterate through values only
    System.out.print("\nValues: ");
    for (String value : map.values()) {
      System.out.print(value);
      System.out.print(", ");
    }
    
    // iterate through key/value entries by importing entry in map in util
    System.out.print("\nEntries: ");
    for (Entry<Integer, String> entry : map.entrySet()) {
      System.out.print(entry);
      System.out.print(", ");
    }




        
    }
    
}
