/*
 *
 * Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
 *
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
 *
 * Example 1:
 *
 * Input: root = [3,1,4,null,2], k = 1
 *    3
 *   / \
 *  1   4
 *   \
 *    2
 * Output: 1
 * Example 2:
 *
 * Input: root = [5,3,6,2,4,null,null,1], k = 3
 *      5
 *     / \
 *    3   6
 *   / \
 *  2   4
 * /
 * 1
 * Output: 3
 *
 */

class Solution {

    ArrayList<Integer> list = new ArrayList<>();

    public int kthSmallest(TreeNode root, int k) {

        inorder(root);
        int result = -1;

        for (int i = 0; i < k; i++) {
            if (i == k - 1) {
                result = list.get(i);
            }
        }

        return result;
    }

    void inorder(TreeNode root) {

        if (root == null) {
            return;
        }

        inorder(root.left);
        list.add(root.val);
        inorder(root.right);
    }
}

/*
 * We can optimize the above solution. When we are doing the inorder traversal
 * and trying to add nodes to the list, we can check whether we reach K nodes
 * while traversing. So this will make sure that we don't do unnecessary
 * calculations. Like for example, if there are 100 nodes in a tree and most of
 * the nodes are on the right side of the tree, and K = 1, then we are doing
 * unnecessary computations of getting the inorder traversal, while our result
 * lies on the left side by only doing a few computations. The code is:
 *
 * int count = 0; int result = Integer.MIN_VALUE;
 *
 * public int kthSmallest(TreeNode root, int k){ 
        inorder(root, k); return
 *      result; 
    }
 *
 * public void inorder(TreeNode root, int k) { 
        if(root == null) return;
 *
 *      inorder(root.left, k); 
        count ++;//Increment counter after we are going to theleft subtree, to skip the parent root.val of the subtree
 *
 *      if(count == k)//If we are at K, then that is the answer 
            result = root.val;
 *
 *      traverse(root.right, k); 
    }
 */
