/*
 *
 * Count the number of segments in a string, where a segment is defined to be a contiguous sequence of non-space characters.
 *
 * Please note that the string does not contain any non-printable characters.
 *
 * Example:
 *
 * Input: "Hello, my name is John"
 * Output: 5
 *
 */

class Solution {

    public int countSegments(String s) {
        s = s.trim();

        if (s.length() == 0) //everything was just space then return 0
        {
            return 0;
        }

        return s.split("\\s+").length;
    }
}
