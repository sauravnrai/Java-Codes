
// If the substring to remove is app and string given is apple then we will not remove apple
// We will string remove string that is app but not in an occurence of apple

/* 
Input: str1: app str2: apple input: mangoappleapp
 */

 import java.util.Scanner;

public class RemoveSubstring2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read input and split into parts
        String[] inputtaker = sc.nextLine().split(" ");
        sc.close();

        // Assign variables
        String input = inputtaker[0];  // Input string
        String str1 = inputtaker[1];  // String to skip
        String str2 = inputtaker[2];  // String that contains str1 and shouldn't be skipped

        // Validate input
        if (!str2.contains(str1)) {
            System.err.println("Invalid input: str2 must contain str1 as a substring.");
            return;
        }

        // Output result
        System.out.println("Result: " + newStr(input, str1, str2));
    }

    public static String newStr(String input, String str1, String str2) {
        if (input.isEmpty()) {
            return "";
        }

        if (input.startsWith(str2)) {
            int len = str2.length();
            return str2 + newStr(input.substring(len), str1, str2);
        } else if (input.startsWith(str1)) {
            int len = str1.length();
            return newStr(input.substring(len), str1, str2);
        } else {
            char ch = input.charAt(0);
            return ch + newStr(input.substring(1), str1, str2);
        }
    }
}
