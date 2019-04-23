/*

You need to find the largest value in each row of a binary tree.

Example:
Input: 

          1
         / \
        3   2
       / \   \  
      5   3   9 

Output: [1, 3, 9]

*/

class Solution {

    public List<Integer> largestValues(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<Integer> res = new ArrayList<Integer>();
        queue.add(root);

        int queueSize = root == null ? 0 : 1;

        while (queueSize > 0) {
            int largestElement = Integer.MIN_VALUE;

            for (int i = 0; i < queueSize; i++) {
                TreeNode cur = queue.poll();
                largestElement = Math.max(cur.val, largestElement);

                if (cur.left != null) {
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                }
            }

            res.add(largestElement);
            queueSize = queue.size();
        }

        return res;

    }
}
