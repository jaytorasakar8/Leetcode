/*
 *
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Given the below binary tree and sum = 22,
 *
 *        5
 *       / \
 *      4   8
 *     /   / \
 *    11  13  4
 *   /  \    / \
 *  7    2  5   1
 * Return:
 *
 * [
 * [5,4,11,2],
 * [5,8,4,5]
 * ]
 *
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    private List<List<Integer>> result = new ArrayList<List<Integer>>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        helper(new ArrayList<Integer>(), root, sum);
        return result;
    }

    private void helper(List<Integer> list, TreeNode root, int sum) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        sum -= root.val;
        if (root.left == null && root.right == null) {
            if (sum == 0) {
                result.add(list);
            }
            return;
        }
        helper(new ArrayList<Integer>(list), root.left, sum);
        helper(new ArrayList<Integer>(list), root.right, sum);
    }
}
