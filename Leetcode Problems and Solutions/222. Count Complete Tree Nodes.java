/*
 *
 * Given a complete binary tree, count the number of nodes.
 *
 * Note:
 *
 * Definition of a complete binary tree from Wikipedia:
 * In a complete binary tree every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.
 *
 * Example:
 *
 * Input:
 * 1
 * / \
 * 2   3
 * / \  /
 * 4  5 6
 *
 * Output: 6
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

    public int countNodes(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();

        if (root == null) {
            return 0;
        }

        queue.offer(root);
        int count = 0;

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            count++;

            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        return count;
    }
}
