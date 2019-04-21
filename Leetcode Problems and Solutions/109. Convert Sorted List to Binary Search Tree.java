/*
 *
 * Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
 *
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 *
 * Example:
 *
 * Given the sorted linked list: [-10,-3,0,5,9],
 *
 * One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
 *
 *      0
 *     / \
 *   -3   9
 *   /   /
 * -10  5
 *
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
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

    public TreeNode sortedListToBST(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        return helper(list, 0, list.size() - 1);
    }

    private TreeNode helper(List<Integer> list, int low, int high) {

        if (low > high || list.isEmpty()) {
            return null;
        }
        int mid = low + (high - low) / 2;
        TreeNode root = new TreeNode(list.get(mid));
        root.left = helper(list, low, mid - 1);
        root.right = helper(list, mid + 1, high);
        return root;
    }
}
