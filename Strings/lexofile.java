
/*
 * You are given a file with a name and a target file with a name length
 * The goal is to find the lexographically smaller file name for target file
 * 
 * If file name is acb then target file size is also 3, then file will be aca. 
 * There are many files like aaa, abc, abb, but aca is more stricter
 * 
 * if file name is acb then target file is of length 4
 * then file name best suited is acaa
 */



public class lexofile {

    public static void main(String[] args) {

        // Test cases
        System.out.println(findSmallerFilename("acb", 4));   // "acba"
        System.out.println(findSmallerFilename("baa", 3));   // "azz"
        System.out.println(findSmallerFilename("abc", 3));   // "abb"
        System.out.println(findSmallerFilename("aaa", 3));   // "NO SMALLER STRING"
        System.out.println(findSmallerFilename("zzz", 3));   // "zzy"
        System.out.println(findSmallerFilename("abcd", 3));  // "abc"
        System.out.println(findSmallerFilename("acb", 2));   // "ac"
        System.out.println(findSmallerFilename("aaaa", 4));  // "NO SMALLER STRING"
        }
      
        public static String findSmallerFilename(String string, int i) {

            String target = "";



            return target;
            
        }
    
       

    
}
