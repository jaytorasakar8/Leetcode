/*

Given string S and a dictionary of words words, find the number of words[i] that is a subsequence of S.

Example :
Input: 
S = "abcde"
words = ["a", "bb", "acd", "ace"]
Output: 3
Explanation: There are three words in words that are a subsequence of S: "a", "acd", "ace".
Note:

All words in words and S will only consists of lowercase letters.
The length of S will be in the range of [1, 50000].
The length of words will be in the range of [1, 5000].
The length of words[i] will be in the range of [1, 50].

*/

class Solution {
    public int numMatchingSubseq(String S, String[] words) {
        int count = 0;
        for (String w : words) {
            int i = 0;   // word index
            int j = 0;   // S index
            while (j < S.length() && i < w.length()) {
                if (S.charAt(j) == w.charAt(i)) {
                    i ++;
                } 
               j ++;
                
            }
            if (i == w.length()) 
                count ++;
        }
        return count;
    }
}