/*
 * Given a binary tree, find its maximum depth.
 *
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Given binary tree [3,9,20,null,null,15,7],
 *
 *      3
 *     / \
 *    9  20
 *   /    \
 *  15     7
 * return its depth = 3.
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

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = maxDepth(root.left);// This will give me the left "subtree", not just the left node value
        int right = maxDepth(root.right); //This will give me the right "subtree", not just the right node value

        return Math.max(left, right) + 1;
    }
}
