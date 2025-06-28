import java.util.*;

public class subset {

    public static void main(String[] args) {

        int[] set = {1, 2, 3}; // array

        List<List<Integer>> ans = new ArrayList<>();  // list of list to store these subsets
        List<Integer> p = new ArrayList<>(); // processed array
        List<Integer> up = new ArrayList<>(); // unprocessed list that takes an array

        // Add the array to the unprocessed list
        for(int item: set){
            up.add(item);
        }
        
        Sub(ans, p, up); // method to get all subsets

        System.out.println(ans);
    }

    public static void Sub(List<List<Integer>> ans, List<Integer> p, List<Integer> up ){

        if(up.isEmpty()){
            ans.add(p);
            return;
        }

        int first_term = up.get(0); // first term of the arraylist

        List<Integer> temp_p = new ArrayList<>(p); // makes the copy of p
        temp_p.add(first_term); // adds first term and return boolean
        // Since we return a boolean when we add, we are using a temporary list in the function call

        Sub(ans, temp_p, up.subList(1, up.size()));
         // add the first element of the unprocessed list and use rest of the list


        Sub(ans, p, up.subList(1, up.size())); 
        // skip the first element of the unprocessed list and use the rest of the list

    } 
    
}


/*
 * Subset in an array is of both adjacent and non-adjacent collection of elements
 * 
 * Let us say we have an array [1, 2, 3]
 * 
 * The power set will contain all the subsets
 * [], [1], [2], [3], [1, 2], [2, 3], [1, 3], [1, 2, 3]
 * 
 * For array size 3, we got 8 subsets
 * 
 * If we look at the order, the order of elements are intact
 * 1 is first, 2 is second, 3 is third
 * In all of these subsets, we have maintained the order
 * 
 * [3, 1] is not a valid subset but a permutation since order is not restored
 * 
This program generates all possible subsets (the power set) of a given array using recursion and backtracking.

Concept:
For every element in the array, we make two choices — either include it in the current subset or exclude it.
This binary choice leads to 2^n total subsets for an array of length n.

Explanation:
- We maintain two lists: 
  1. `p` (processed): the current subset being built.
  2. `up` (unprocessed): the remaining elements of the original array.
- On each recursive call, we pick the first element of `up` (called `first_term`) and do the following:
  a) Include it in a new copy of `p` and recursively call with the rest of `up`.
  b) Exclude it and recursively call with the rest of `up` unchanged.
- When `up` is empty, we've built a complete subset, so we add `p` to the final answer list `ans`.

Note:
- We use `subList` to pass slices of the list instead of modifying the original.
- We copy `p` using `subList(0, p.size())` before adding `first_term`, to avoid unintended side-effects across recursive paths.
- This method ensures all combinations are explored: include or exclude each element, building the complete power set.


// Java's List.subList(fromIndex, toIndex) gives a view of a portion of the list
// We use it to pass a "sliced" version of up — i.e., the unprocessed list minus the first element
// This helps simulate removing the head and passing the tail (like in functional programming)



// Lists in Java are mutable — if we modify p directly, it affects all recursive calls
// So, we create a new copy `temp_p` with `p.subList(0, p.size())`
// Add to this copy and use it in the include path
// The exclude path uses the original p untouched

 * 
 * 
 */