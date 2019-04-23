/*
 *
 * Find the length of the longest substring T of a given string (consists of lowercase letters only) such that every character in T appears no less than k times.
 *
 * Example 1:
 *
 * Input:
 * s = "aaabb", k = 3
 *
 * Output:
 * 3
 *
 * The longest substring is "aaa", as 'a' is repeated 3 times.
 * Example 2:
 *
 * Input:
 * s = "ababbc", k = 2
 *
 * Output:
 * 5
 *
 * The longest substring is "ababb", as 'a' is repeated 2 times and 'b' is repeated 3 times.
 *
 */

class Solution {

    public int longestSubstring(String s, int k) {
        HashMap<Character, Integer> counter = new HashMap<Character, Integer>();

        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);
            if (counter.containsKey(c)) {
                counter.put(c, counter.get(c) + 1);
            } else {
                counter.put(c, 1);
            }

        }

        HashSet<Character> splitSet = new HashSet<Character>();
        for (char c : counter.keySet()) {
            if (counter.get(c) < k) {
                splitSet.add(c);
            }
        }

        if (splitSet.isEmpty()) {
            return s.length();
        }

        int max = 0;
        int i = 0, j = 0;
        while (j < s.length()) {
            char c = s.charAt(j);
            if (splitSet.contains(c)) {
                if (j != i) {
                    max = Math.max(max, longestSubstring(s.substring(i, j), k));
                }
                i = j + 1;
            }
            j++;
        }

        if (i != j) {
            max = Math.max(max, longestSubstring(s.substring(i, j), k));
        }

        return max;
    }
}
