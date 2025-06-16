import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagram {

    public List<List<String>> groupAnagrams(String[] strs) {
    
    List<List<String>> ans = new ArrayList<>();
 

    // Base case if array has only 1 string
   if(strs.length == 1){
    List<String> temp = new ArrayList<>();
    temp.add(strs[0]);
    ans.add(temp);
    return ans;
   }


   String[] ang = new String[strs.length];
   // This array will store the sorted strings for every string in str
   // If two strings are anagram, we will get the same string at different index
   // Each sorted string at a index will represent the string in str
   // Two strings at different indices at str who are anagram, will have same string in ang

   Map<String, Integer> map = new HashMap<>();
   // This map will store the sorted string to index in the list of list
   // We will help to map all anagrams to an index in the list of list

   for(int i=0; i<strs.length; i++){
    ang[i] = sortString(strs[i]); // stores the sorted string returned by the function
   } 
   

   int index = 0; // This will help to keep track of list inside list
   // We will use this to insert a new entry and then increment it
   // This is where map will come in handy to map already inserted list


  // Loop to group anagrams
   for(int i=0; i<strs.length; i++){
     
     // We will use the sorted strings to group all anagrams
      if(! map.containsKey(ang[i])){
            map.put(ang[i], index); // put where this sorted strings is stored for an index
             
             List<String> temp = new ArrayList<>(); // create a new row or list to add in the list of list
             temp.add(strs[i]);

            ans.add(temp); // adds the relevant string at that index in arraylist

             index++; // increment the index
      }else{

        int temp_index = map.get(ang[i]); // gives the index to the sorted string which maps all anagram
        ans.get(temp_index).add(strs[i]); // adds the anagram to that index
      }

   }

        
    return ans;    
    }

    public static String sortString(String temp){

        char[] ch = temp.toCharArray();

        Arrays.sort(ch);

        return new String(ch);
    }
    
}


/*
Solution to the problem
 

Input:  ["eat", "tea", "tan", "ate", "nat", "bat"]
Output: [["eat","tea","ate"], ["tan","nat"], ["bat"]]


GROUP ANAGRAMS - EXPLANATION

    Problem:
    Given a list of strings, group all anagrams together.
    An anagram is formed by rearranging the letters of a word (e.g., "eat", "tea", "ate").

    Key Insight:
    All anagrams become the same string when their characters are sorted.
    Example: "eat", "tea", "ate" → sorted = "aet"
    So, we can use the sorted string as a unique "key" to group anagrams.

    Goal:
    Group all original strings that share the same sorted version.

    What I Did (High-Level Steps):

    1. Sort each string and store it in a separate array `ang[]`.
       This helps avoid sorting the same string multiple times.

    2. Use a Map<String, Integer>:
       - Key: sorted string (e.g., "aet")
       - Value: index of the group in the final result list (List<List<String>>)

    3. Loop through each string:
       - If its sorted version (ang[i]) is not in the map:
         Create a new list group for it in the result
         Add it to the final answer list (ans)
         Store its index in the map
       - If it already exists:
          Add the string to the existing group using its index from the map

    Why I Used `Map<String, Integer>` Instead of `Map<String, List<String>>`:
    - This saves space because I store only the index (int) of each group in the map.
    - It avoids holding full list references inside the map.
    - The actual group data is stored centrally in the main result list (`ans`).

     Why `ang[]`:
    - To avoid sorting strings multiple times
    - Helps separate the sorted version from the original string clearly

     Overall Benefit:
    - Efficient in both memory and speed
    - Cleanly separates logic of sorting, grouping, and indexing

     Summary in One Line:
      Sort strings to find anagram groups, use a map to store where each group lives in the final list,
      and build the result by grouping strings with the same sorted form.
 * 
 */



/*
 * Given an array of strings strs, group the anagrams together. You can return the answer in any order.

 

Example 1:

Input: strs = ["eat","tea","tan","ate","nat","bat"]

Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

Explanation:

There is no string in strs that can be rearranged to form "bat".
The strings "nat" and "tan" are anagrams as they can be rearranged to form each other.
The strings "ate", "eat", and "tea" are anagrams as they can be rearranged to form each other.
Example 2:

Input: strs = [""]

Output: [[""]]

Example 3:

Input: strs = ["a"]

Output: [["a"]]

 

Constraints:

1 <= strs.length <= 104
0 <= strs[i].length <= 100
strs[i] consists of lowercase English letters.
 * 
 * 
 * 
 * 
 */