import java.util.Arrays;

public class StringMethods{
    public static void main(String[] args) {

        String str = "Saurav";

        System.out.println(str.length()); // gives length
        System.out.println(str.isEmpty()); // checks if the string is empty
        // Note that the strings are immutable and these methods return strings too and won't change original ones

        String str2 = str.substring(1);
        // substring either takes first index, or source index to destination index

        // Check if the strings are equal
        System.out.println(str.equals(str2));

        //char at gives the character at index
        System.out.println(str.charAt(0));

        // to lower case and upper case
        System.out.println(str.toLowerCase());
        System.out.println(str.toUpperCase());

        // to char array
        char ch[] = str.toCharArray();
        System.out.println(Arrays.toString(ch));


        // starts with and Ends with
        str.startsWith("sau"); // returns true or false
        str.endsWith("rav");

        // Contains the string
        str.contains("rav"); // returns boolean

        // index of first occurence of character or a string
        str.indexOf("sau");

        // index of last occurence of character or a string
        str.lastIndexOf("rav");






        
    }
}