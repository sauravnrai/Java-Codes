import java.util.Arrays; // need to import to use its methods
import java.io.IOException;


public class Array1d {

    public static void main(String[] args) throws IOException {

        // datatype [] name = new datatype[size];
        // datatype[] name is evaluated at compile time and new datatype[size] is evaluated at runtime allocating memory to array

        int[] arr = new int[5]; // default value of all items is 0 in integer

        System.out.println(arr.length); // .length gives the length of the array

        arr[0] = 1;
        arr[1] = 2;
        arr[3] = 4;
        arr[4] = 5;

        // for each loop to print the array
        // datatype variable_name : name
        for(int num: arr){
            System.out.print(num + " ");
        }
        
        System.err.println();

        // Copy of the array till specified length
        int[] copy = Arrays.copyOf(arr,3);
        System.out.println(Arrays.toString(copy));

        // copy of array from range
        int[] copy1 = Arrays.copyOfRange(arr, 0, 4);

        // To print the array using toStrings method
        System.out.println(Arrays.toString(copy1));

        // equals mehtod returns boolean i.e true or false
        System.out.println(Arrays.equals(copy,copy1));

        // sort() to sort the array
        Arrays.sort(copy1);
        System.out.println(Arrays.toString(copy1));

     // binary search in array
     System.out.println(Arrays.binarySearch(copy1, 0)); // returns index


        
    }
    
}
