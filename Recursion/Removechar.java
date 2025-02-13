import java.util.Scanner;


// if a string is abbcdeffa and character is a, then result will be bbcdeff
public class Removechar {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String input = sc.next(); // Takes input string
        char ch = sc.next().charAt(0); // Takes input character to be removed
        sc.close();

         System.out.println(newStr(input, ch));
        
    }

    public static String newStr(String input, char ch){

        // Base case to check if the string is empty
        if(input.isEmpty()){
            return "";
        }

        char chartemp = input.charAt(0); // gets the first character of string

        if(chartemp == ch){
            return newStr(input.substring(1), ch); // Skips the character and gives the rest of the string to next function call

        }else{

            return chartemp + newStr(input.substring(1), ch); // Stores the current character and gives the remaining string to the next function call

        }

    }
    
}
