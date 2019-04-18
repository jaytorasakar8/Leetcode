/*
 * Given two integers dividend and divisor, divide two integers without using multiplication, division and mod operator.
 *
 * Return the quotient after dividing dividend by divisor.
 *
 * The integer division should truncate toward zero.
 *
 * Example 1:
 *
 * Input: dividend = 10, divisor = 3
 * Output: 3
 * Example 2:
 *
 * Input: dividend = 7, divisor = -3
 * Output: -2
 * Note:
 *
 * Both dividend and divisor will be 32-bit signed integers.
 * The divisor will never be 0.
 * Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. For the purpose of this problem, assume that your function returns 231 − 1 when the division result overflows.
 *
 */

class Solution {

    public int divide(int dividend, int divisor) {
        long divid = 0, divis = 0;
        long count = 0;

        int sign = ((dividend < 0) ^ (divisor < 0)) ? -1 : 1;
        divid = Math.abs((long) dividend);
        divis = Math.abs((long) divisor);

        while (divid >= divis) {
            divid -= divis;
            count++;
        }

        int ans;
        if (count > Integer.MAX_VALUE) { //Handle overflow.
            ans = (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        } else {
            ans = (int) (sign * count);
        }
        return ans;
    }
}
