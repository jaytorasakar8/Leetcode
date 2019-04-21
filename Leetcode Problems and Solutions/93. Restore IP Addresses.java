/*
 *
 * Given a string containing only digits, restore it by returning all possible valid IP address combinations.
 *
 * Example:
 *
 * Input: "25525511135"
 * Output: ["255.255.11.135", "255.255.111.35"]
 *
 */

public class Solution {

    public List<String> restoreIpAddresses(String s) {

        List<String> res = new ArrayList<String>();
        int len = s.length();

        for (int i = 1; i < 4 && i < len - 2; i++) {
            for (int j = i + 1; j < i + 4 && j < len - 1; j++) {
                for (int k = j + 1; k < j + 4 && k < len; k++) {
                    String s1 = s.substring(0, i),
                            s2 = s.substring(i, j),
                            s3 = s.substring(j, k),
                            s4 = s.substring(k, len);

                    if (isValid(s1) && isValid(s2) && isValid(s3) && isValid(s4)) {
                        res.add(s1 + "." + s2 + "." + s3 + "." + s4);
                    }
                }
            }
        }
        return res;
    }

    public boolean isValid(String s) {
        if (s.length() > 3 || s.length() == 0 || (s.charAt(0) == '0' && s.length() > 1) || Integer.parseInt(s) > 255) {
            return false;
        }
        return true;
    }
}


/*
For an input = "25525511135"

The Strings evaluated are: 
Evaluated: 2  5  5  25511135  
Evaluated: 2  5  52  5511135  
Evaluated: 2  5  525  511135  
Evaluated: 2  55  2  5511135  
Evaluated: 2  55  25  511135  
Evaluated: 2  55  255  11135  
Evaluated: 2  552  5  511135  
Evaluated: 2  552  55  11135  
Evaluated: 2  552  551  1135  
Evaluated: 25  5  2  5511135  
Evaluated: 25  5  25  511135  
Evaluated: 25  5  255  11135  
Evaluated: 25  52  5  511135  
Evaluated: 25  52  55  11135  
Evaluated: 25  52  551  1135  
Evaluated: 25  525  5  11135  
Evaluated: 25  525  51  1135  
Evaluated: 25  525  511  135  
Evaluated: 255  2  5  511135  
Evaluated: 255  2  55  11135  
Evaluated: 255  2  551  1135  
Evaluated: 255  25  5  11135  
Evaluated: 255  25  51  1135  
Evaluated: 255  25  511  135  
Evaluated: 255  255  1  1135  
Evaluated: 255  255  11  135  <--- Correct IP address
Evaluated: 255  255  111  35  <--- Correct IP address

Result = ["255.255.11.135","255.255.111.35"]

Remaining are wrong IP addresses for given input conditions
*/
