/*
 *
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 *
 * Note: For the purpose of this problem, we define empty string as valid palindrome.
 *
 * Example 1:
 *
 * Input: "A man, a plan, a canal: Panama"
 * Output: true
 * Example 2:
 *
 * Input: "race a car"
 * Output: false
 *
 */

class Solution {

    public boolean isPalindrome(String s) {

        /*
         * Approach 1: Simple Solution by combining strings StringBuilder
         *
         * for(int i =0;i<s.length();i++) {
         * if(Character.isLetterOrDigit(s.charAt(i))) sb.append(s.charAt(i)); }
         *
         * String input = sb.toString().toLowerCase(); int start = 0, end =
         * input.length()-1;
         *
         * while(start <= end) { if(input.charAt(start)!=input.charAt(end))
         * return false; start++; end--; }
         *
         * return true;
         */
        
        // Approach 2:
        if (s.isEmpty()) {
            return true;
        }

        int start = 0, end = s.length() - 1;
        char cHead, cTail;

        while (start <= end) {
            cHead = s.charAt(start);
            cTail = s.charAt(end);

            if (!Character.isLetterOrDigit(cHead)) {
                start++;
            } else if (!Character.isLetterOrDigit(cTail)) {
                end--;
            } else {
                if (Character.toLowerCase(cHead) != Character.toLowerCase(cTail)) {
                    return false;
                }

                start++;
                end--;
            }
        }

        return true;
    }
}
