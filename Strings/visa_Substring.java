/* Given a number 456 as a string, you have to find all the substring
 * i.e 4, 5, 6, 45, 56, 456
 * return a count of these substrings that are divisble by 3
 * and make sure none of the stirngs start from 0
 * 
 */

import java.util.*;

public class visa_Substring {

    public static void main(String[] args) {
        
        String str = "6666";

        System.out.println("Number of substrings divisible by 3 are: " + divi(str));
    }

    public static int divi(String str){

        ArrayList<String> arr = new ArrayList<>();

        int num = 0;

        for(int i=0; i<str.length(); i++){
            for(int j= i+1; j<= str.length(); j++){

                arr.add(str.substring(i, j)); // adds all the substring to arraylist

            }
        }
      
        System.out.println("Substring array: " + arr);
        int temp_num;

        for(String temp: arr){
           temp_num = Integer.parseInt(temp);

           if(temp_num % 3 == 0){
            num++;
           }
        }


        return num;


    }
    
}
