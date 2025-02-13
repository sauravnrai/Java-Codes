import java.util.Arrays;

public class CharArray{
    public static void main(String[] args) {
        String str = "Saurav";

        int len = str.length();
        
       char[] ch = new char[len];

        for(int i=0; i<len; i++){
         ch[i] = str.charAt(i);
        }

        System.out.println(Arrays.toString(ch));

    }
}