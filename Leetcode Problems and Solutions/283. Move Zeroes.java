/*
 *
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 *
 * Example:
 *
 * Input: [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 * Note:
 *
 * You must do this in-place without making a copy of the array.
 * Minimize the total number of operations.
 *
 */

class Solution {

    public void moveZeroes(int[] nums) {
        int i = 0;
        int j = 0;

        while (j < nums.length) {
            if (nums[j] == 0) {
                j++;
            } else {
                nums[i] = nums[j];
                i++;
                j++;
            }
        }

        while (i < nums.length) {
            nums[i] = 0;
            i++;
        }
    }
}
