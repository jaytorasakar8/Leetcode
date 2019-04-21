/*
 *
 * Given a binary tree, return the postorder traversal of its nodes' values.
 *
 * Example:
 *
 * Input: [1,null,2,3]
 * 		1
 * 		 \
 *        2
 *       /
 *	    3
 *
 * Output: [3,2,1]
 *
 */

class Solution {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if (root != null) {
            result.addAll(postorderTraversal(root.left));

            result.addAll(postorderTraversal(root.right));
            result.add(root.val);
        }
        return result;
    }
}
