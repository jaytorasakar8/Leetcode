/*

Given two strings s1, s2, find the lowest ASCII sum of deleted characters to make two strings equal.

Example 1:
Input: s1 = "sea", s2 = "eat"
Output: 231
Explanation: Deleting "s" from "sea" adds the ASCII value of "s" (115) to the sum.
Deleting "t" from "eat" adds 116 to the sum.
At the end, both strings are equal, and 115 + 116 = 231 is the minimum sum possible to achieve this.
Example 2:
Input: s1 = "delete", s2 = "leet"
Output: 403
Explanation: Deleting "dee" from "delete" to turn the string into "let",
adds 100[d]+101[e]+101[e] to the sum.  Deleting "e" from "leet" adds 101[e] to the sum.
At the end, both strings are equal to "let", and the answer is 100+101+101+101 = 403.
If instead we turned both strings into "lee" or "eet", we would get answers of 433 or 417, which are higher.
Note:

0 < s1.length, s2.length <= 1000.
All elements of each string will have an ASCII value in [97, 122].

*/

class Solution {
    public int minimumDeleteSum(String s1, String s2) {
       int m = s1.length();
        int n = s2.length();
        
        int[][] dp = new int[m+1][n+1];
        dp[0][0] = 0;
        
       for (int i = 1; i < m + 1; ++i) 
		    dp[i][0] = dp[i - 1][0] + s1.charAt(i - 1);
	    
	for (int j = 1; j < n + 1; ++j) 
		    dp[0][j] = dp[0][j - 1] + s2.charAt(j - 1);
	
    char[] w1 = s1.toCharArray();
    char[] w2 = s2.toCharArray();
        
	for (int i = 1; i < m + 1; ++i) {
		char c1 = s1.charAt(i - 1);
		for (int j = 1; j < n + 1; ++j) {
			char c2 = s2.charAt(j - 1);
			int a = c1 == c2 ? dp[i - 1][j - 1] : Integer.MAX_VALUE;
			int b = dp[i - 1][j] + c1;
			int c = dp[i][j - 1] + c2;
			dp[i][j] = Math.min(a, Math.min(b, c));
		}
	}
        return dp[m][n];
    }
}