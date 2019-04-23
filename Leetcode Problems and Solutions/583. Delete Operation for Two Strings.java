/*

Given two words word1 and word2, find the minimum number of steps required to make word1 and word2 the same, where in each step you can delete one character in either string.

Example 1:
Input: "sea", "eat"
Output: 2
Explanation: You need one step to make "sea" to "ea" and another step to make "eat" to "ea".
Note:
The length of given words won't exceed 500.
Characters in given words can only be lower-case letters.

*/

class Solution {
    //This solution is similar to 72. Edit Distance question
    //The only difference from there is here we are converting word1 and word2 into two equal matching words. That is word1 is becoming from sea -> ea and word2 is becoming from eat -> ea. So basically we can't take value from the diagonal, just take value from the top and the left. Since we are just supporting deleting a character, and no insertion, we are taking the values from the top and the left!   
    
    public int minDistance(String word1, String word2) {
        int m = word2.length();
        int n = word1.length();
        
        int[][] dp = new int[m+1][n+1];
        for(int i=0;i<m+1;i++)
            dp[i][0] = i;
        for(int i=0;i<n+1;i++)
            dp[0][i] = i;
        
        char[] w1 = word1.toCharArray();
        char[] w2 = word2.toCharArray();
        
        for(int i=1;i<m+1;i++)
            for(int j=1;j<n+1;j++)
            {
                if(w2[i-1] == w1[j-1])
                    dp[i][j] = dp[i-1][j-1];
                else
                    dp[i][j] = 1+  Math.min(dp[i-1][j], dp[i][j-1]);
            }
        
        return dp[m][n];
    }
}