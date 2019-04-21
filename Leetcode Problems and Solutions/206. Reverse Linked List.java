/*
 *
 * Reverse a singly linked list.
 *
 * Example:
 *
 * Input: 1->2->3->4->5->NULL
 * Output: 5->4->3->2->1->NULL
 * Follow up:
 *
 * A linked list can be reversed either iteratively or recursively. Could you implement both?
 *
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

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode prev = null;
        ListNode current = head;
        ListNode next = null;

        //Basically we are kind of creating a new list using the prev pointer. 
        //We are starting to point the current node to the new list(null)
        //Iterate and make each node point to it's prev node
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        head = prev;
        return head;

        /*
         * ListNode p1 = head; ListNode p2 = p1.next;
         *
         * head.next = null; while(p1!=null&& p2!=null){ ListNode t = p2.next;
         * p2.next = p1; p1 = p2; p2 = t; }
         *
         * return p1;
         */
    }
}
