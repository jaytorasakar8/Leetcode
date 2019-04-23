/*
 *
 * Given a binary tree, return all root-to-leaf paths.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Input:
 *
 * 1
 * /   \
 * 2     3
 * \
 * 5
 *
 * Output: ["1->2->5", "1->3"]
 *
 * Explanation: All root-to-leaf paths are: 1->2->5, 1->3
 *
 */

class Solution {

    public List<String> binaryTreePaths(TreeNode root) {
        ArrayList<String> res = new ArrayList<String>();
        helper(root, "", res);
        return res;
    }

    void helper(TreeNode root, String path, ArrayList<String> res) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            res.add(path + root.val);
        }
        helper(root.left, path + root.val + "->", res);
        helper(root.right, path + root.val + "->", res);
    }
}
