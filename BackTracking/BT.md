# BackTracking Notes

# Basics

- Before starting with backtracking, it is important to understand Recursion
- You need to be good with methods, classes, return type, arrays, arraylist, etc
- Kindly, review the recursion codes once before we start with backtracking
- Try to review codes like remove character, remove substring, subsequences in recursion

## Subset and Subsequence

# Subset

A subset is any combination of elements from an array, where order doesn't matter, and you choose to include or exclude each element.

Example: For [1, 2, 3], subsets include:

[], [1], [2], [3], [1,2], [1,3], [2,3], [1,2,3]

Total number of subsets = 2^n for n elements.

Works similarly to subsequences, but with numbers (or elements) instead of characters.

Recursive Logic:
You process each element of the array:

Include the current element in the subset.

Exclude the current element and move forward.

This approach gives all possible combinations of the array.



# Subsequence

A subsequence is derived by deleting zero or more characters from the original string, without changing the order of the remaining characters.

Example: For "abc", valid subsequences include:

"a", "b", "c", "ab", "ac", "bc", "abc", "" (empty string)

Total number of subsequences = 2^n where n is the length of the string.

Order matters — you cannot rearrange characters.

Use-case: Problems like finding longest increasing subsequence, generating all subsequences for string pattern matching.

Recursive Logic:
For each character:

Take it and add to the result.

Skip it and continue.

This leads to a binary tree-like structure of decisions.

# Difference

Subsequence: Characters in original order; string-related.

Subset: Focused on presence/absence of elements; typically array-related.

Both follow a similar recursive pattern** using "include" or "exclude" logic.


## Permutation and Combinations