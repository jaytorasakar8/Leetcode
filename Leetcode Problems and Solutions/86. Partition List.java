/*
 *
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
 *
 * You should preserve the original relative order of the nodes in each of the two partitions.
 *
 * Example:
 *
 * Input: head = 1->4->3->2->5->2, x = 3
 * Output: 1->2->2->4->3->5
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
class Solution {

    public ListNode partition(ListNode head, int x) {
        ListNode dummyLeft = new ListNode(42);
        ListNode dummyRight = new ListNode(42);
        ListNode nodeLeft = dummyLeft;
        ListNode nodeRight = dummyRight;
        while (head != null) {
            if (head.val < x) {
                nodeLeft.next = head;
                nodeLeft = nodeLeft.next;
            } else {
                nodeRight.next = head;
                nodeRight = nodeRight.next;
            }
            head = head.next;
        }
        nodeLeft.next = dummyRight.next;
        nodeRight.next = null;
        return dummyLeft.next;

    }
}
