/*
 * Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.
 *
 * Note:
 *
 * The length of both num1 and num2 is < 5100.
 * Both num1 and num2 contains only digits 0-9.
 * Both num1 and num2 does not contain any leading zero.
 * You must not use any built-in BigInteger library or convert the inputs to integer directly.
 *
 */

class Solution {

    public String addStrings(String num1, String num2) {
        if (num1 == null || num2 == null) {
            return null;
        }

        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int l1 = num1.length() - 1;
        int l2 = num2.length() - 1;

        while (l1 >= 0 || l2 >= 0) {
            int n1 = l1 >= 0 ? num1.charAt(l1) - '0' : 0;
            int n2 = l2 >= 0 ? num2.charAt(l2) - '0' : 0;
            int sum = n1 + n2 + carry;
            carry = sum > 9 ? 1 : 0;
            sb.insert(0, sum % 10);
            l1--;
            l2--;
        }

        if (carry == 1) {
            sb.insert(0, 1);
        }

        return sb.toString();
    }
}
