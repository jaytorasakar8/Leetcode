/*
 *
 * Given an encoded string, return it's decoded string.
 *
 * The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.
 *
 * You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.
 *
 * Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].
 *
 * Examples:
 *
 * s = "3[a]2[bc]", return "aaabcbc".
 * s = "3[a2[c]]", return "accaccacc".
 * s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
 *
 */

class Solution {

    private int i = 0;

    public String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        int num = 0;

        while (i < s.length()) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            } else if (c == '[') {
                i++;
                String str = decodeString(s);
                for (int k = 0; k < num; k++) {
                    sb.append(str);
                }
                num = 0;
            } else if (c == ']') {
                return sb.toString();
            } else {
                sb.append(c);
            }
            i++;
        }

        return sb.toString();
    }
}
