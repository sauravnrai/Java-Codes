import java.util.Scanner;

public class BinarySearch{

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();

        int[] array = new int[size];

        for(int i=0; i<size; i++){
            array[i] = sc.nextInt();

        }
     
        int key = sc.nextInt();
        sc.close();

        int first = 0;
        int last = array.length - 1;
    
        int index = Search(array, key, first, last);

        if(index > -1){
         System.out.println("Key at index " + index);
        }else{
            System.out.println("Key not found");
        }
        
    }

    public static int Search(int arr[], int key, int first, int last){

        int center = (first + last)/2;
        
        if(first > last){
            return -1;
        }else if(arr[center]==key){
            return center;
        }else if(arr[center] > key){
          return  Search(arr, key, first, center-1);
        } else{
           return Search(arr,key,center+1,last);
        }

    }

}