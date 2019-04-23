/*
 *
 * Given an unsorted array of integers, find the length of longest increasing subsequence.
 *
 * Example:
 *
 * Input: [10,9,2,5,3,7,101,18]
 * Output: 4
 * Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
 * Note:
 *
 * There may be more than one LIS combination, it is only necessary for you to return the length.
 * Your algorithm should run in O(n2) complexity.
 * Follow up: Could you improve it to O(n log n) time complexity?
 *
 */

class Solution {

    public int lengthOfLIS(int[] nums) {
        //Explanation: Tushar Roy -> https://www.youtube.com/watch?v=CE2b_-XfVDk

        // Base case
        if (nums.length <= 1) {
            return nums.length;
        }

        // This will be our array to track longest sequence length
        int T[] = new int[nums.length];

        // Fill each position with value 1 in the array
        for (int i = 0; i < nums.length; i++) {
            T[i] = 1;
        }

        // Mark one pointer at i. For each i, start from j=0.
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                // It means next number contributes to increasing sequence.
                if (nums[j] < nums[i]) {
                    // But increase the value only if it results in a larger value of the sequence than T[i]
                    // It is possible that T[i] already has larger value from some previous j'th iteration
                    if (T[j] + 1 > T[i]) {
                        T[i] = T[j] + 1;
                    }
                }
            }
        }

        // Find the maximum length from the array that we just generated 
        int maxLength = 0;
        for (int i = 0; i < T.length; i++) {
            maxLength = Math.max(maxLength, T[i]);
        }

        return maxLength;
    }
}
