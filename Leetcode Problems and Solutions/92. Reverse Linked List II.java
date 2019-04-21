/*
 *
 * Reverse a linked list from position m to n. Do it in one-pass.
 *
 * Note: 1 ≤ m ≤ n ≤ length of list.
 *
 * Example:
 *
 * Input: 1->2->3->4->5->NULL, m = 2, n = 4
 * Output: 1->4->3->2->5->NULL
 *
 */


 /*
 * Method 1: First traveling m nodes ahead and then reversing the sublist of length (n - m) nodes.
 */
class Solution {

    public ListNode reverseBetween(ListNode head, int m, int n) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        for (int i = 1; i < m; i++) {
            prev = prev.next;               // Node pointing to a subList 
        }
        ListNode current = prev.next;       // First node of a sub-list

        //Basically swapping the nodes so that finally the result is reversed list
        for (int i = 0; i < n - m; i++) {
            // Node that will be reversed, temp node will become sub-list head in each iteration
            ListNode temp = current.next;
            current.next = temp.next;
            temp.next = prev.next;
            prev.next = temp;
        }

        return dummy.next;
    }
}

/*
 * Method 2: First traverse and mark mth and nth node. Then reverse the sublist
 * based on the mth and nth node marking
 */
class Solution {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == n) {
            return head;
        }

        ListNode prev = null;//track (m-1)th node
        ListNode first = new ListNode(0);//first's next points to mth
        ListNode second = new ListNode(0);//second's next points to (n+1)th

        int i = 0;
        ListNode p = head;

        while (p != null) {
            i++;
            if (i == m - 1) {
                prev = p;
            }

            if (i == m) {
                first.next = p;
            }

            if (i == n) {
                second.next = p.next;
                p.next = null;
            }

            p = p.next;
        }

        if (first.next == null) {
            return head;
        }

        // reverse list [m, n]    
        ListNode p1 = first.next;
        ListNode p2 = p1.next;
        p1.next = second.next;

        while (p1 != null && p2 != null) {
            ListNode t = p2.next;
            p2.next = p1;
            p1 = p2;
            p2 = t;
        }

        //connect to previous part
        if (prev != null) {
            prev.next = p1;
        } else {
            return p1;
        }

        return head;
    }
}
