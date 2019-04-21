/*
 *
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 *
 * Example:
 *
 * Input: n = 4, k = 2
 * Output:
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 *
 */

class Solution {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<Integer>(), 1, n, k);
        return result;
    }

    public void backtrack(List<List<Integer>> result, ArrayList<Integer> comb, int start, int n, int k) {
        if (k == 0) {
            result.add(new ArrayList<>(comb));
        }

        for (int i = start; i <= n; i++) {
            comb.add(i);
            backtrack(result, comb, i + 1, n, k - 1);
            comb.remove(comb.size() - 1);
        }
    }
}

/*
 * Similar approach to the Backtracking question of Subsets I & II, Combination
 * Sum questions https://leetcode.com/problems/subsets-ii/description/
 */
