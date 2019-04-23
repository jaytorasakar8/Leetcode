/*
Given a binary tree, find the leftmost value in the last row of the tree.

Example 1:
Input:

    2
   / \
  1   3

Output:
1
Example 2: 
Input:

        1
       / \
      2   3
     /   / \
    4   5   6
       /
      7

Output:
7
Note: You may assume the tree (i.e., the given root node) is not NULL.


*/

class Solution {

    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode n = null;

        while (!queue.isEmpty()) {
            n = queue.poll();
            if (n.right != null) {
                queue.offer(n.right);
            }
            if (n.left != null) {
                queue.offer(n.left);
            }
        }
        return n.val;

    }
}
