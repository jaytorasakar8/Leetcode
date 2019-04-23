/*
 *
 * Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.
 *
 * Example:
 * Given a binary tree
 *     1
 *    / \
 *   2   3
 *  / \
 * 4   5
 * Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].
 *
 * Note: The length of path between two nodes is represented by the number of edges between them.
 *
 *
 */

class Solution {

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        /*
         * Get the left and right height of the tree.
         */
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);

        /*
         * Get the left and right diameter of the tree.
         */
        int leftDiameter = diameterOfBinaryTree(root.left);
        int rightDiameter = diameterOfBinaryTree(root.right);

        return Math.max(leftHeight + rightHeight, Math.max(leftDiameter, rightDiameter));
    }

    public int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }

        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }
}
