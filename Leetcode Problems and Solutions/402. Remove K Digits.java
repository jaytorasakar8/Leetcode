/*
 *
 * Given a non-negative integer num represented as a string, remove k digits from the number so that the new number is the smallest possible.
 *
 * Note:
 * The length of num is less than 10002 and will be ≥ k.
 * The given num does not contain any leading zero.
 * Example 1:
 *
 * Input: num = "1432219", k = 3
 * Output: "1219"
 * Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
 * Example 2:
 *
 * Input: num = "10200", k = 1
 * Output: "200"
 * Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.
 * Example 3:
 *
 * Input: num = "10", k = 2
 * Output: "0"
 * Explanation: Remove all the digits from the number and it is left with nothing which is 0.
 *
 */

class Solution {

    public String removeKdigits(String num, int k) {
        Deque<Character> stack = new ArrayDeque<>();
        int n = num.length();
        if (k >= n) {
            return "0";
        }

        for (int i = 0; i < n; i++) {
            while (k > 0 && !stack.isEmpty() && stack.peek() > num.charAt(i)) {
                stack.pop();//Basically we want to check if the value that we have in the stack, is it more than the current value, then just pop the value from the stack till the time you get a value which is less than the current value.  
                k--;
            }
            stack.push(num.charAt(i));
        }

        while (k > 0) {
            stack.pop(); //We want only k characters in our stack
            k--;
        }

        StringBuilder sb = new StringBuilder();

        while (!stack.isEmpty()) {
            sb.append(stack.pop());//Remove all the k characters from the stack
        }
        sb.reverse();//Since Stack is LIFO, we need to reverse the result 

        while (sb.length() > 1 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);//In case we have a leading zero in our result
        }
        return sb.toString();//Return the result string
    }
}
