/**
 * Question: Implement a function that encrypts a given string using Caesar Cipher.
 *           The function should shift each letter in the string by `k` positions 
 *           while maintaining case sensitivity. Non-alphabetic characters should remain unchanged.
 *           
 * Example:
 *   Input:  "Hello, World!", k = 3
 *   Output: "Khoor, Zruog!"
 */

 public class CaesarCipher {
    // Predefined input string
    private static final String INPUT_STRING = "Hello, World!";
    private static final int SHIFT_KEY = 3;

    public static void main(String[] args) {
        // Encrypt the predefined string
        String encryptedText = caesarCipher(INPUT_STRING, SHIFT_KEY);
        System.out.println("Original Text: " + INPUT_STRING);
        System.out.println("Encrypted Text: " + encryptedText);
    }

    public static String caesarCipher(String s, int k) {
        StringBuilder s1 = new StringBuilder();
        k = k % 26; // Reduce unnecessary rotations
        
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            
            if (!((ch >= 65 && ch <= 90) || (ch >= 97 && ch <= 122))) {
                s1.append(ch); // Append non-alphabetic characters as they are
            } else {
                int temp = ch; // Get ASCII value
                int ascii = temp + k; // Apply shift
                
                // Wrap around for uppercase letters
                if (temp >= 65 && temp <= 90 && ascii > 90) {
                    ascii = 65 + (ascii - 91); // Wrap within A-Z
                } 
                // Wrap around for lowercase letters
                else if (temp >= 97 && temp <= 122 && ascii > 122) {
                    ascii = 97 + (ascii - 123); // Wrap within a-z
                }
                
                s1.append((char) ascii);
            }
        }
        
        return s1.toString();
    }
}
