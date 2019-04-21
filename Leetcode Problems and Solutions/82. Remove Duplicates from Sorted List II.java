/*
 *
 * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
 *
 * Example 1:
 *
 * Input: 1->2->3->3->4->4->5
 * Output: 1->2->5
 * Example 2:
 *
 * Input: 1->1->1->2->3
 * Output: 2->3
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

    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode prev = dummy;
        ListNode current = head;

        while (current != null) {
            //We have a duplicate
            if (current.next != null && current.val == current.next.val) {
                //Repeat till the time you remove all the duplicates
                while (current.next != null && current.val == current.next.val) {
                    current = current.next;
                }
            } else {
                //If the 2 consecutive nodes are having different values, then just append the current element to the resultant list
                prev.next = current;
                prev = prev.next;
            }

            current = current.next;
        }

        prev.next = null;
        return dummy.next;
    }
}
