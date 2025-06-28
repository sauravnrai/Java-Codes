import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LC90 {

    // User's approach not the optimal approach but solves the problem
    public List<List<Integer>> subsetsWithDup(int[] nums) {

     List<List<Integer>> ans = new ArrayList<>();
     List<Integer> p = new ArrayList<>();
     List<Integer> up = new ArrayList<>();

    for(int item: nums){
        up.add(item); // add all elements in the unprocessed array
    }

    Collections.sort(up); // sort the unprocessed to avoid different subsets containing the same elements
    // You could either sort up, or sort every temp_p in each function call. The difference will be 1 ms in execution 

    Sub(ans, p, up);


   Set<List<Integer>> set = new HashSet<>(ans); // to remove duplicates

   return new ArrayList<>(set); // return the set as a list
        
    }

    public void Sub(List<List<Integer> > ans, List<Integer> p, List<Integer> up){

        if(up.isEmpty()) {
            ans.add(p);
            return;
        }

        List<Integer> temp_p = new ArrayList<>(p);
        temp_p.add(up.get(0)); // adds the first element

        // if up is not sorted, then temp_p has to be sorted. either include up sort line or temp_p sort line with collection framework to get the right solution
        //  Collections.sort(temp_p); 
        // this will sort the exisitng processed list and avoid unnecessary subset genertion
        // Sort will ensure that same element subset does not happen in different ways. Only 1 way

        //Select first element
        Sub(ans, temp_p, up.subList(1, up.size()));


        // Not select first element
        Sub(ans, p, up.subList(1, up.size()));
    }


    
}

/*
This code is used to generate all **unique subsets** from an integer array that may contain duplicates.

The problem is a variation of the basic subset generation problem, but with duplicates in the input,
so we need to make sure our output does not contain duplicate subsets.

### High-Level Strategy:
We use recursion to generate subsets using the concept of "pick or not pick" for each element.
However, since duplicates exist, we need to avoid generating the same subset multiple times.

---

### Step-by-Step Explanation:

1. We initialize two lists:
   - `p` (processed): stores the current path or subset being constructed.
   - `up` (unprocessed): holds the elements we haven't considered yet.

2. We convert the input array into the `up` list and then **sort it**.
   - Sorting is crucial because it groups duplicates together.
   - It allows us to easily skip over duplicate elements during processing or ensure consistency in order.

3. We then call a recursive function `Sub`, which performs two actions at each step:
   - **Take the current element** and move forward with the remaining elements.
   - **Ignore the current element** and still move forward with the remaining elements.

4. Each time we take a subset (when unprocessed becomes empty), we add it to the answer list.

5. After all subsets are generated, we may still have duplicate subsets (e.g., [1,2] and another [1,2]).
   - So, we convert the result into a `Set`, which automatically removes duplicates since sets do not allow them.

6. Finally, we convert the set back into a list and return it as the final result.

---

### Why We Sort the Input Early:
If we sort at the start, all duplicate values are grouped together.
This allows us to either:
   - Skip over duplicates explicitly during recursion, or
   - Ensure that the same elements appear in the same order in every subset, allowing `Set` to detect and remove duplicates.

Sorting once is better than sorting individual subsets during recursion, which would be inefficient.

If you don't use sort at the begining, then you have to use it during the recursion with temp_p

---

### Why We Use Set at the End:
Even with sorting, our naive recursive solution will generate some duplicate subsets (just in consistent order).
Using a `Set<List<Integer>>` removes these duplicates efficiently at the end.

---

This solution uses:
- Recursion for subset generation
- Sorting to control duplicate permutations
- Set for deduplication
- Final conversion to list for return
*/



/*
 * Given an integer array nums that may contain duplicates, return all possible subsets (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.

 

Example 1:

Input: nums = [1,2,2]
Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
Example 2:

Input: nums = [0]
Output: [[],[0]]
 

Constraints:

1 <= nums.length <= 10
-10 <= nums[i] <= 10
 * 
 * 
 * 
 * 
 */