/*
 *
 * You are given two non-empty linked lists representing two non-negative integers. The most significant digit comes first and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Follow up:
 * What if you cannot modify the input lists? In other words, reversing the lists is not allowed.
 *
 * Example:
 *
 * Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 8 -> 0 -> 7
 *
 */

//Approach 1: Using Stack

import java.math.BigDecimal;



class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null;
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        while (l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        }

        while (l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }

        int carry = 0;
        while (!s1.isEmpty() || !s2.isEmpty() || carry != 0) {
            int a = s1.isEmpty() ? 0 : s1.pop();
            int b = s2.isEmpty() ? 0 : s2.pop();
            int sum = a + b + carry;
            carry = sum / 10;

            ListNode node = new ListNode(sum % 10);
            node.next = head;
            head = node;

        }

        return head;
    }
}

//Approach 2: Using BigDecimal Class

public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1==null) return l2;
        if (l2==null) return l1;
        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();
        while (l1 != null) {
            s1.append(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            s2.append(l2.val);
            l2 = l2.next;
        }
        
        BigDecimal b1 = new BigDecimal(s1.toString());
        BigDecimal b2 = new BigDecimal(s2.toString());
        BigDecimal add = b1.add(b2);
        String str = String.valueOf(add.toString());
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;

        for (int i = 0; i < str.length(); i++) {
            cur.next = new ListNode(Integer.valueOf(Character.toString(str.charAt(i))));
            cur = cur.next;
        }
        return dummy.next;
    }
