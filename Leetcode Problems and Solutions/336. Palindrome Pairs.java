/*
 *
 * Given a list of unique words, find all pairs of distinct indices (i, j) in the given list, so that the concatenation of the two words, i.e. words[i] + words[j] is a palindrome.
 *
 * Example 1:
 *
 * Input: ["abcd","dcba","lls","s","sssll"]
 * Output: [[0,1],[1,0],[3,2],[2,4]]
 * Explanation: The palindromes are ["dcbaabcd","abcddcba","slls","llssssll"]
 * Example 2:
 *
 * Input: ["bat","tab","cat"]
 * Output: [[0,1],[1,0]]
 * Explanation: The palindromes are ["battab","tabbat"]
 *
 */

class Solution {

    public List<List<Integer>> palindromePairs(String[] words) {

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j != i && j < words.length; j++) {
                StringBuilder sb1 = new StringBuilder(words[i]);
                sb1.append(words[j]);
                if (isPalindrome(sb1.toString())) {
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    result.add(list);
                }

                StringBuilder sb2 = new StringBuilder(words[j]);
                sb2.append(words[i]);
                if (isPalindrome(sb2.toString())) {
                    List<Integer> list = new ArrayList<>();
                    list.add(j);
                    list.add(i);
                    result.add(list);
                }

            }
        }

        return result;
    }

    public boolean isPalindrome(String text) {
        StringBuilder plain = new StringBuilder(text);
        StringBuilder reverse = plain.reverse();
        return (reverse.toString()).equals(text);
    }
}
