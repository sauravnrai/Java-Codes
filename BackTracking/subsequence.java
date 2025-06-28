import java.util.*;


public class subsequence {

    public static void main(String[] args) {

        String str = "abc";
        
        // List to store all subsequence
        List<String> ans = new ArrayList<>();
        
        Subseq(ans,"", str ); // this method call contains list, processed, unprocessed
        // initially, list is empty. Processes stirng is also empty, unprocessed is entire str

        System.out.println(ans);
        
    }

    public static void Subseq(List<String> ans, String p, String up){

        if(up.isEmpty()){
            ans.add(p); // record the processed string in the ans
            return; // return
        }

        Subseq(ans, p + up.charAt(0), up.substring(1)); // Either take the first character of the processed string
        Subseq(ans, p, up.substring(1));  // Ignore the first character of the string

    }
}


/*
 * 
 * We are given a string abc
 * 
 * Subsequence is group of characters that form a string that may or may not be adjacent
 * 
 * For abc, we will get 8 substrings and they are "", a, b, c, ab, ac, bc, abc
 * If we see, order of these characters haven't changed wrt original string
 * a is first, b is second, c is last
 * In all of these subsequences, we have maintained that order
 * ca is not a valid subsequence of abc but a permutation
 * 
 *  
 * 
 * 
 * 
 * 
 */