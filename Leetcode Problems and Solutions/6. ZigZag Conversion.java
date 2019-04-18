/*
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 *
 * Write the code that will take a string and make this conversion given a number of rows:
 *
 * string convert(string s, int numRows);
 * Example 1:
 *
 * Input: s = "PAYPALISHIRING", numRows = 3
 * Output: "PAHNAPLSIIGYIR"
 * Example 2:
 *
 * Input: s = "PAYPALISHIRING", numRows = 4
 * Output: "PINALSIGYAHRPI"
 * Explanation:
 *
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 *
 */

public class Solution {

    public String convert(String s, int rows) {

        if (rows == 1) {
            return s;
        }

        char[] c = s.toCharArray();

        StringBuffer[] sb = new StringBuffer[rows];

        for (int i = 0; i < sb.length; i++) {
            sb[i] = new StringBuffer();
        }

        int ar = 0;
        boolean direction = true;//True means going down
        for (int i = 0; i < s.length(); i++) {
            if (rows == 1) {
                return s;
            }

            char temp = c[i];
            // System.out.println(ar);

            sb[ar].append(temp);

            if (ar == 0) {
                direction = true;
            } else {
                if (ar == rows - 1) {
                    direction = false;
                }
            }

            if (direction == true) {
                ar++;
            } else {
                ar--;
            }

        }

        for (int i = 1; i < rows; i++) {
            sb[0].append(sb[i]);
        }
        System.out.println(sb[0].toString());
        return sb[0].toString();

    }
}
