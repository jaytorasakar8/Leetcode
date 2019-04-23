/*
 *
 * Write a function that reverses a string. The input string is given as an array of characters char[].
 *
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 *
 * You may assume all the characters consist of printable ascii characters.
 *
 *
 *
 * Example 1:
 *
 * Input: ["h","e","l","l","o"]
 * Output: ["o","l","l","e","h"]
 * Example 2:
 *
 * Input: ["H","a","n","n","a","h"]
 * Output: ["h","a","n","n","a","H"]
 *
 */

class Solution {

    public String reverseString(String s) {
        int len = s.length();
        len = len * 2;
        char[] temp = new char[len];

        for (int i = 0; i < s.length(); i++) {
            temp[i] = s.charAt(i);
        }
        // System.out.println(temp.length);
        int k = s.length() - 1;
        char[] c = new char[s.length()];
        for (int i = 0; i < s.length() && k >= 0; i++) {
            temp[i + s.length()] = temp[k];
            k--;
            c[i] = temp[i + s.length()];
            // System.out.println(c[i]);
        }
        //System.out.println();

        return String.valueOf(c);

    }
}
