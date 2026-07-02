Longest Repeating Subsequence
Given a string, print the longest repeating subsequence such that the two subsequence don’t have same string character at same position, i.e., any i’th character in the two subsequences shouldn’t have the same index in the original string.
Example:
Input: str = "aab"
Output: "a"
The two subsequence are 'a'(first) and 'a' 
(second). Note that 'b' cannot be considered 
as part of subsequence as it would be at same
index in both.


EASY EXPLANATION:
Problem: Find the length of the longest subsequence that appears at least twice in a given string.

The Golden Rule:When building the two identical subsequences, a character match is only valid if the characters come from different indices in the original string.

Valid: Subsequence A uses index 1, Subsequence B uses index 2. (1!=2)Invalid: Both subsequences use the exact same character from index 1. (1==2)


str = xx (0)

invalid(lets say output => x)
a-> 0
b-> 0
we can see to make the subsequmec we used the same index from the original string
0th of a and 0th of b -> both uses same 0th index of original


valid(lets say output => x)
a->0
b->1
we can see to make the subsequmec we used the diffrent index from the original string
or we can say
a and b does not have any index common from the original, at thier same index level






