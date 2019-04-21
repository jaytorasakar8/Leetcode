/*
 * Example 1:
 * Input: 4
 * Output: 2
 *
 *
 * Example 2:
 *
 * Input: 8
 * Output: 2
 * Explanation: The square root of 8 is 2.82842..., and since
 * the decimal part is truncated, 2 is returned.
 *
 */

class Solution {

    public int mySqrt(int x) {
        Double y = Math.sqrt(x);
        return (int) Math.floor(y);
    }
}
