/*
Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

Example:

Given this linked list: 1->2->3->4->5

For k = 2, you should return: 2->1->4->3->5

For k = 3, you should return: 3->2->1->4->5

Note:

Only constant extra memory is allowed.
You may not alter the values in the list's nodes, only nodes itself may be changed.

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

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        int i = 0;

        ListNode p = head;
        while (p != null) {
            i++;
            if (i % k == 0) {
                pre = reverse(pre, p.next);
                p = pre.next;
            } else {
                p = p.next;
            }
        }

        return dummy.next;
    }
 
/*
 * 0->1->2->3->4->5->6
 * |           |   
 * pre        next
 *
 * after calling pre = reverse(pre, next)
 * 
 * 0->3->2->1->4->5->6
 *          |  |
 *          pre next 
 */
    public ListNode reverse(ListNode start, ListNode end) {
        ListNode prev = start.next;
        ListNode curr = prev.next;

        while (curr != end) {
            prev.next = curr.next;
            curr.next = start.next;
            start.next = curr;
            curr = prev.next;
        }

        return prev;
    }

    /*
    In the reverse function we are going to have the following iterations. 
    First we get this as input:
          0 -> 1-> 2-> 3-> 4-> 5-> 6
          |    |   |       |   
        pre  last curr    next
    After Iteration 1: 
          0 -> 2-> 1-> 3->  4-> 5-> 6
          |        |   |    |   
         pre     last curr next
    
    After Iteration 2: 
          0 -> 3-> 2-> 1-> 4-> 5-> 6
          |            |   |   
         pre         last next
   
    
    */
}