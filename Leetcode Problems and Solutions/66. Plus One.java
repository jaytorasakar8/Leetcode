/*
 *
 * Given a non-empty array of digits representing a non-negative integer, plus one to the integer.
 *
 * The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit.
 *
 * You may assume the integer does not contain any leading zero, except the number 0 itself.
 *
 * Example 1:
 *
 * Input: [1,2,3]
 * Output: [1,2,4]
 * Explanation: The array represents the integer 123.
 * Example 2:
 *
 * Input: [4,3,2,1]
 * Output: [4,3,2,2]
 * Explanation: The array represents the integer 4321.
 *
 */

public class Solution {

    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) ///Here we are traversing from unit's place to tens or hundreds place.  
        {
            if (digits[i] != 9) {
                digits[i]++;
                break;
            } else {
                digits[i] = 0;
            }
        }
        if (digits[0] == 0) //This means that earlier there was the digit 9 present there. And because of +1, it has become 0 now. So we need to ////add the digit 1 on the left hand side of the current zero. 
        {
            int[] res = new int[digits.length + 1];
            res[0] = 1;
            return res;
        }
        return digits;
    }
}
/*

General description
The meaning of the question: For an n sized array, traverse through each of the array elements, and plus one in it.
So if the digit is 9, then we need to make 0 there. Else just add one to the number. 

*/
