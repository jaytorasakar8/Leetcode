/*

Sort a linked list using insertion sort.

Algorithm of Insertion Sort:

Insertion sort iterates, consuming one input element each repetition, and growing a sorted output list.
At each iteration, insertion sort removes one element from the input data, finds the location it belongs within the sorted list, and inserts it there.
It repeats until no input elements remain.

Example 1:

Input: 4->2->1->3
Output: 1->2->3->4
Example 2:

Input: -1->5->3->4->0
Output: -1->0->3->4->5

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

    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(0); // use dummyHead to create the resultant list
        ListNode cur = head;

        while (cur != null) {
            ListNode p = dummy; // find the correct insertion point starting from the resultant list first node! 

            //Move to the node which will be less than the current node. Skip nodes in the current iteration which are less than the current node. Once you get a value which is more than the current node then add that node to the resultant list!    
            while (p.next != null && p.next.val < cur.val) {
                p = p.next;
            }

            //Inserting the current node to the resultant list
            ListNode next = cur.next;
            cur.next = p.next;
            p.next = cur;
            cur = next;
        }
        return dummy.next;
    }
    
    /*
    Eg: Input: 4 -> 2 -> 3 -> 1
    Initially: Resultant list = 0 -> null
                                |
                              dummy
               List = 4 -> 2 -> 1 -> 3
                      |    |
                    curr  next
                    
    Iteration 1: We are going to directly insert into to our resultant list since the while loop isn't true 
                So we get 
                Resultant list = 0 -> 4 -> null
                                 |
                                 p
               List = 2 -> 3 -> 1
                      |    |
                    curr  next

    Iteration 2: Now here we check:
                i) Compare p.next(4) < curr(2) is false, so we are going to skip that while loop and directly insert in between the nodes 0 and 4 in the resultant list
               Resultant list = 0 -> 2 -> 4 -> null
                                |
                                p
               List = 3 -> 1
                      |    |
                    curr  next
    Iteration 3: Now we check:
                i) Compare p.next(2) < curr(3) is true so we are going to move to the next node in the resultant list. 
                ii) Compare p.next(4) < curr(3) is false, so now we are going to skip the while loop and insert the current node in between the node = 2 and node = 4
                Resultant list = 0 -> 2 -> 3 -> 4 -> null
                                 |
                                 p
                List = 1 -> null
                       |    |
                     curr  next
    Iteration 4:  Now here we check:
                i) Compare p.next(2) < curr(1) is false, so we are going to skip that while loop and directly insert in between the nodes 0 and 2 in the resultant list
                Resultant list = 0 -> 1 -> 2 -> 3 -> 4 -> null
                                 |
                                 p
                List = null
                        |    
                      curr 
                      
            Now list has nothing so we are going to end the iteration and we have our final resultant list as well
    
    */
    
}