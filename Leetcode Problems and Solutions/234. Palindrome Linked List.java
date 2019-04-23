/*
 *
 * Given a singly linked list, determine if it is a palindrome.
 *
 * Example 1:
 *
 * Input: 1->2
 * Output: false
 * Example 2:
 *
 * Input: 1->2->2->1
 * Output: true
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

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode tmp = new ListNode(0);
        tmp.next = head;
        Stack<ListNode> stack = new Stack<>();
        ListNode slow = tmp, fast = tmp;
        // 1 1   1 0 1 
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            stack.push(slow);

        }
        if (fast != null && fast.next == null) {
            slow = slow.next;
        }
        while (!stack.isEmpty()) {
            if (stack.pop().val != slow.val) {
                return false;
            }
            slow = slow.next;
        }
        return true;
    }
}
