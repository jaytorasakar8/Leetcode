/*

Given a string S of digits, such as S = "123456579", we can split it into a Fibonacci-like sequence [123, 456, 579].

Formally, a Fibonacci-like sequence is a list F of non-negative integers such that:

0 <= F[i] <= 2^31 - 1, (that is, each integer fits a 32-bit signed integer type);
F.length >= 3;
and F[i] + F[i+1] = F[i+2] for all 0 <= i < F.length - 2.
Also, note that when splitting the string into pieces, each piece must not have extra leading zeroes, except if the piece is the number 0 itself.

Return any Fibonacci-like sequence split from S, or return [] if it cannot be done.

Example 1:

Input: "123456579"
Output: [123,456,579]
Example 2:

Input: "11235813"
Output: [1,1,2,3,5,8,13]
Example 3:

Input: "112358130"
Output: []
Explanation: The task is impossible.
Example 4:

Input: "0123"
Output: []
Explanation: Leading zeroes are not allowed, so "01", "2", "3" is not valid.
Example 5:

Input: "1101111"
Output: [110, 1, 111]
Explanation: The output [11, 0, 11, 11] would also be accepted.
Note:

1 <= S.length <= 200
S contains only digits.

*/

class Solution {
    public List<Integer> splitIntoFibonacci(String S) {
    List<Integer> ans = new ArrayList<>();
    helper(S, ans, 0);
    return ans;
}

public boolean helper(String s, List<Integer> ans, int idx) {
    if (idx == s.length() && ans.size() >= 3) {
        return true;
    }
    for (int i=idx; i<s.length(); i++) {
        if (s.charAt(idx) == '0' && i > idx) {
            break;
        }
        long num = Long.parseLong(s.substring(idx, i+1));
        if (num > Integer.MAX_VALUE) {
            break;
        }
        int size = ans.size();
        // early termination
        if (size >= 2 && num > ans.get(size-1)+ans.get(size-2)) {
            break;
        }
        if (size <= 1 || num == ans.get(size-1)+ans.get(size-2)) {
            ans.add((int)num);
            // branch pruning. if one branch has found fib seq, return true to upper call
            if (helper(s, ans, i+1)) {
                return true;
            }
            ans.remove(ans.size()-1);
        }
    }
    return false;
}
}