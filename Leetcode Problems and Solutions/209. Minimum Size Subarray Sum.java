/*
 *
 * Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.
 *
 * Example:  
 * Input: s = 7, nums = [2,3,1,2,4,3]
 * Output: 2
 * Explanation: the subarray [4,3] has the minimal length under the problem constraint.
 * Follow up:
 * If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n).  *
 */

class Solution {

    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int i = 0;
        int j = 0;
        int sum = 0;

        int minLen = Integer.MAX_VALUE;

        while (j < nums.length) {
            if (sum < s) {
                sum += nums[j];
                j++;
            } else {
                minLen = Math.min(minLen, j - i);
                if (i == j - 1) {
                    return 1;
                }

                sum -= nums[i];
                i++;
            }
        }

        while (sum >= s) {
            minLen = Math.min(minLen, j - i);

            sum -= nums[i++];
        }

        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}
