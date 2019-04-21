/*
 *
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 *
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * Given a non-empty string containing only digits, determine the total number of ways to decode it.
 *
 * Example 1:
 *
 * Input: "12"
 * Output: 2
 * Explanation: It could be decoded as "AB" (1 2) or "L" (12).
 * Example 2:
 *
 * Input: "226"
 * Output: 3
 * Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
 *
 */

class Solution {

    public int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }

        int[] dp = new int[s.length()];
        dp[0] = 1;
        if (Integer.parseInt(s.substring(0, 2)) > 26) {
            if (s.charAt(1) != '0') {
                dp[1] = 1;
            } else {
                dp[1] = 0;
            }
        } else if (s.charAt(1) != '0') {
            dp[1] = 2;
        } else {
            dp[1] = 1;
        }

        for (int i = 2; i < s.length(); i++) {
            if (s.charAt(i) != '0') {
                dp[i] += dp[i - 1];
            }

            int val = Integer.parseInt(s.substring(i - 1, i + 1));
            if (val <= 26 && val >= 10) {
                dp[i] += dp[i - 2];
            }
        }

        return dp[s.length() - 1];
    }
}
