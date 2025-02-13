import java.util.Scanner;


// If the input string is mangoappleorange ans string to skip is apple, then we will get mangoorange

public class RemoveSubstring {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.next(); // Takes input string
        String substr = sc.next(); // Takes substring
        System.out.println(remove(input, substr));
        sc.close();


    }
    
    public static String remove(String input, String substr){

        if(input.isEmpty()){
            return "";
        }

        char ch = input.charAt(0); // Takes the first character of the string


    if(input.startsWith(substr)){
           int len = substr.length(); // gets the length of the substrign to be skipped
        return remove(input.substring(len), substr); // skips the substring and then puts the next index string to the next function call

    }else{
        return ch + remove(input.substring(1), substr); // gives the string with next index to next function call 
    }


    }
}
