/*
 *
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 *
 * Each element in the array represents your maximum jump length at that position.
 *
 * Determine if you are able to reach the last index.
 *
 * Example 1:
 *
 * Input: [2,3,1,1,4]
 * Output: true
 * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * Example 2:
 *
 * Input: [3,2,1,0,4]
 * Output: false
 * Explanation: You will always arrive at index 3 no matter what. Its maximum
 * jump length is 0, which makes it impossible to reach the last index.
 *
 */

class Solution {

    /*
     * The basic idea is this: at each step, we keep track of the furthest
     * reachable index. The nature of the problem (eg. maximal jumps where you
     * can hit a range of targets instead of singular jumps where you can only
     * hit one target) is that for an index to be reachable, each of the
     * previous indices have to be reachable.
     *
     * Hence, it suffices that we iterate over each index, and If we ever
     * encounter an index that is not reachable, we abort and return false. By
     * the end, we will have iterated to the last index. If the loop finishes,
     * then the last index is reachable.
     */

    public boolean canJump(int[] nums) {
        int reachable = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (i > reachable) {
                return false;
            }
            reachable = Math.max(reachable, i + nums[i]);
        }
        return true;
    }
}
