/*
 *
 * Given a sorted integer array without duplicates, return the summary of its ranges.
 *
 * Example 1:
 *
 * Input:  [0,1,2,4,5,7]
 * Output: ["0->2","4->5","7"]
 * Explanation: 0,1,2 form a continuous range; 4,5 form a continuous range.
 * Example 2:
 *
 * Input:  [0,2,3,4,6,8,9]
 * Output: ["0","2->4","6","8->9"]
 * Explanation: 2,3,4 form a continuous range; 8,9 form a continuous range.
 *
 */

class Solution {

    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<String>();
        int start = 0, end = 0;

        for (int i = 0; i < nums.length; i++) {
            while (i < nums.length - 1 && (1 + nums[i] == nums[i + 1])) {
                end++;
                i++;
            }

            String s = null;
            if (start == end) {
                s = "" + nums[start];
            } else {
                s = "" + nums[start] + "->" + nums[end];
            }

            if (end + 1 < nums.length) {
                start = end + 1;
                end = end + 1;
            }

            result.add(s);

        }
        return result;

    }
}
