public class StringObject {

    public static void main(String[] args) {
        
        String str = "Saurav"; // This is a string reference variable that is pointing to a string in the string pool
        // String pool is a special memory location in heap

        String str1 = new String("Saurav"); // This is a string object reference variable that is pointing to a string in heap



        System.out.println(str1 == str); // gives false since str1 is not is string pool
        // would give true if str1 = str was used since both were pointing at same object

        
        System.out.println(str1.equals(str)); // gives true because value was checked
    }
    
}
