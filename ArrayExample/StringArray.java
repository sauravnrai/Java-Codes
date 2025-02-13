
import java.util.Scanner;

public class StringArray {

    public static void main(String[] args) {
        
        Scanner sc =  new Scanner(System.in);

        // Use next line method
        String[] str = sc.nextLine().split(" "); // Takes the input string sentence with spaces and stores each word on an index
        
        for(String temp: str){
            System.out.println(temp + " ");
        }

        sc.close();
    }
    
}
