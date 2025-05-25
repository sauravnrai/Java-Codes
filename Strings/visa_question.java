/* given a string array, [cat, dog, mouse] return another string array such that [cg, de, mt]
 * if only one element [cat], then return [ct]
 * 
 * 
 */

import java.util.Arrays;

public class visa_question {

    public static void main(String[] args) {

        String[] array = {"cat", "dog", "eat"};

        String[] array1 = {"cat"};

        System.out.println(Arrays.toString(solution(array)));
        System.out.println(Arrays.toString(solution(array1)));
     
        // Better code than previous method
        System.out.println(Arrays.toString(transform(array)));
        System.out.println(Arrays.toString(transform(array1)));

    }

   public static String[] solution(String a[]){

        int len = a.length; // gives length of the array

        String[] str = new String[len];
     
        if(len == 1){
            int len2 = a[0].length(); // gives the length of the string
            str[0] = "" +a[0].charAt(0) + a[0].charAt(len2 - 1);
        }else{
            int len2 = 0;

            for(int i=0; i< a.length; i++){
                if(i == a.length - 1 ){
                    len2 = a[0].length(); // gets the first string length

                    str[i] = "" + a[i].charAt(0) + a[0].charAt(len2 - 1);

                }else{
                    len2 = a[i+1].length();
                str[i] = "" + a[i].charAt(0) + a[i+1].charAt(len2 - 1); // adds all the string except the last one
            }
            }
        }
    

        return str;

    }


    static String[] transform(String a[]){

        int len = a.length;
       
        String[] str = new String[len];


        for(int i=0; i<len; i++){
            int new_index = (i + 1) % len;

            str[i] = "" + a[i].charAt(0) + a[new_index].charAt(a[new_index].length() - 1);
        }
    

        return str;
    }
    
}
