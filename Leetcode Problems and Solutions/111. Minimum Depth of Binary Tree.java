/*
 *
 * Given a binary tree, find its minimum depth.
 *
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Given binary tree [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9   20
 *  /     \
 * 15      7
 * return its minimum depth = 2.
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

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return helper(root);
    }

    public int helper(TreeNode root) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }

        int depthLeft = helper(root.left);
        int depthRight = helper(root.right);

        return Math.min(depthLeft, depthRight) + 1;
    }
}
