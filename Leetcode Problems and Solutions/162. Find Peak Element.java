/*
 *
 * A peak element is an element that is greater than its neighbors.
 *
 * Given an input array nums, where nums[i] ≠ nums[i+1], find a peak element and return its index.
 *
 * The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.
 *
 * You may imagine that nums[-1] = nums[n] = -∞.
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,1]
 * Output: 2
 * Explanation: 3 is a peak element and your function should return the index number 2.
 * Example 2:
 *
 * Input: nums = [1,2,1,3,5,6,4]
 * Output: 1 or 5
 * Explanation: Your function can return either index number 1 where the peak element is 2,
 * or index number 5 where the peak element is 6.
 *
 */

class Solution {

    public int findPeakElement(int[] num) {
        if (num.length <= 1) {
            return 0;
        }
        int mid = 0, l = 0, h = num.length - 1;

        while (l < h) {
            mid = (l + h) / 2;
            if (num[mid] > num[mid + 1]) {
                h = mid;
            } else if (num[mid] < num[mid + 1]) {
                l = mid + 1;
            }
        }

        return l;
    }
}
