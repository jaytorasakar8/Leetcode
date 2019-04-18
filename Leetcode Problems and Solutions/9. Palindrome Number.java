/*
 *
 * Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.
 *
 * Example 1:
 *
 * Input: 121
 * Output: true
 * Example 2:
 *
 * Input: -121
 * Output: false
 * Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
 * Example 3:
 *
 * Input: 10
 * Output: false
 * Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 */

class Solution {

    public boolean isPalindrome(int x) {
        /*
         * First we check for the false cases. i) if the number is negative then
         * it is not possible for palindrome ii) if the number is zero, then it
         * not a palindrome(the terminating condition also) iii) if the last
         * digit is zero, then it can't be palindrome
         *
         * Then we just are doing reverse of half of the numbers. So that's why
         * we have taken the reverse, and the comparision x > rev tells us that
         * we need to do stop at the half way mark. This is done to prevent the
         * overflow, which may happen for long integers.
         */
        if (x < 0 || (x != 0 && x % 10 == 0)) {
            return false;
        }
        int rev = 0;

        /*
         * Here we are just doing half of the actual work, since we are just
         * calculating the half part of the given integer.
         *
         */
        while (x > rev) {
            rev = rev * 10 + x % 10;
            x = x / 10;
        }
        return (x == rev || x == rev / 10);
    }
}
