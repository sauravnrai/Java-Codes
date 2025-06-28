


/* 
 * Java StringBuilder class is used to create mutable (modifiable) String. 
 * The Java StringBuilder class is same as StringBuffer class except that it is non-synchronized. 
 * In strings, we will get immutable objects and result are new strings where old strings remain same
 * In string builder, we will get objects on which changes can be seen
 */

public class StringBuilderdemo{

    public static void main(String[] args) {

        StringBuilder sb = new StringBuilder();

        sb.append("o"); // adds the string or character
        sb.insert(0,"Hell"); // takes the index or offset where you want to insert the string
        System.out.println(sb);

        System.out.println("character at index 3: "+ sb.charAt(3));

        System.out.println(sb.reverse());

        sb.delete(0, 3);
        System.out.println("After deleting first three characters: " + sb);

        sb.replace(0, 3, "pie");
        System.out.println("After replacing three characters: " + sb);

        
        System.out.println("Lenght of the sb: "+ sb.length());
        
        sb.reverse(); // reverses the string
        
    }
}