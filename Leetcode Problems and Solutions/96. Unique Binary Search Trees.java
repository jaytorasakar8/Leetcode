/*
 * Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?
 *
 * Example:
 *
 * Input: 3
 * Output: 5
 * Explanation:
 * Given n = 3, there are a total of 5 unique BST's:
 *
 * 1         3     3      2      1
 *  \       /     /      / \      \
 *   3     2     1      1   3      2
 *  /     /       \                 \
 * 2     1         2                 3
 *
 */

class Solution {

    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; ++i) {
            for (int j = 1; j <= i; ++j) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }

        return dp[n];
    }
}

/*
Solution taken from: https://github.com/bephrem1/backtobackswe/blob/master/Dynamic%20Programming%2C%20Recursion%2C%20%26%20Backtracking/countUniqueBinarySearchTrees.java

Reference video: https://www.youtube.com/watch?v=GgP75HAvrlY

For n = 3
Initial -> dp[0] = 1, dp[1] = 1

1. Iteration 1: i = 2, means we have a total of 2 nodes in our BST. 
    i)  dp[2] = dp[2] + dp[0]*dp[1] = 0 + 1*1 = 1 <-- We have 0 node on left and 1 node on right subtree out of the total 2 nodes, bcoz one node is going to be the root node so that's why 0 nodes on left and 1 node on right.
    ii) dp[2] = dp[2] + dp[1]*dp[0] = 1 + 1*1 = 2 <-- We are having 1 node on left and 0 node on the right subtree of 2 nodes.
    The cases of the above one are: 
    i)     1            ii)      2
            \                   /
             2                 1
    
2. Iteration 2: i = 3, means we have a total of 3 nodes in our BST.
    i)  dp[3] = dp[3] + dp[0]*dp[2] = 0 + 1*2 = 2 <-- We have 0 nodes on the left and 2 nodes on the right. Final answer is 2 which means that we have 2 combinations available for 0 nodes on left and 2 nodes on right. 
    ii) dp[3] = dp[3] + dp[1]*dp[1] = 2 + 1*1 = 3 <-- We have 1 nodes on the left and 1 nodes on the right. Final answer is 3 which means that we have 1 combinations available for 1 nodes on left and 1 nodes on right, with addition of 2 previous combinations
    iii)  dp[3] = dp[3] + dp[2]*dp[0] = 3 + 2*1 = 5 <-- We have 2 nodes on the left and 0 nodes on the right. Final answer is 5 which means that we have total 2 combinations available for 2 nodes on left and 0 nodes on right, with addition of 3 previous combinations
    
     The cases of the above one are: 
    i) 0 nodes on the left and 2 nodes on the right = 2 combinations
           1                   1
            \                   \
             2                   3
              \                 /
               3               2
    ii) 1 nodes on the left and 1 nodes on the right = 1 combination
                 2
                / \
               1   3
    iii) 2 nodes on the left and 0 nodes on the right = 2 combination
              3                   3
             /                   /
             1                  2
              \                /
               2              1

*/
