/*
 *
 * Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
 *
 * Find all the elements of [1, n] inclusive that do not appear in this array.
 *
 * Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.
 *
 * Example:
 *
 * Input:
 * [4,3,2,7,8,2,3,1]
 *
 * Output:
 * [5,6]
 *
 */

class Solution {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        int[] lookup = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            lookup[nums[i]]++;
        }

        ArrayList ret = new ArrayList();
        for (int i = 0; i < lookup.length; i++) {
            if (lookup[i] == 0 && i != 0) {
                ret.add(i);
            }
        }
        return ret;
    }
}
