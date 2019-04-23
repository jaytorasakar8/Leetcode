/*
 *
 * Given a List of words, return the words that can be typed using letters of alphabet on only one row's of American keyboard like the image below.
 *
 * Example:
 *
 * Input: ["Hello", "Alaska", "Dad", "Peace"]
 * Output: ["Alaska", "Dad"]
 *
 *
 * Note:
 *
 * You may use one character in the keyboard more than once.
 * You may assume the input string will only contain letters of alphabet.
 *
 */

public class Solution {

    public static String[] findWords(String[] words) {
        String s1 = "qwertyuiop", s2 = "asdfghjkl", s3 = "zxcvbnm";
        List<String> list = new ArrayList<String>();
        int count1 = 0, count2 = 0, count3 = 0;
        for (int i = 0; i != words.length; i++) {
            for (int j = 0; j != words[i].length(); j++) {
                if (s1.indexOf(words[i].toLowerCase().charAt(j)) != -1) {
                    count1++;
                }
                if (s2.indexOf(words[i].toLowerCase().charAt(j)) != -1) {
                    count2++;
                }
                if (s3.indexOf(words[i].toLowerCase().charAt(j)) != -1) {
                    count3++;
                }
            }
            if (count1 == words[i].length() || count2 == words[i].length() || count3 == words[i].length()) {
                list.add(words[i]);
            }
            count1 = 0;
            count2 = 0;
            count3 = 0;
        }
        return list.toArray(new String[0]);
    }

}
