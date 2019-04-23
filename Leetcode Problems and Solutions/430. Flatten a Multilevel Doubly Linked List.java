/*

You are given a doubly linked list which in addition to the next and previous pointers, it could have a child pointer, which may or may not point to a separate doubly linked list. These child lists may have one or more children of their own, and so on, to produce a multilevel data structure, as shown in the example below.

Flatten the list so that all the nodes appear in a single-level, doubly linked list. You are given the head of the first level of the list.

 

Example:

Input:
 1---2---3---4---5---6--NULL
         |
         7---8---9---10--NULL
             |
             11--12--NULL

Output:
1-2-3-7-8-11-12-9-10-4-5-6-NULL

*/


class Solution {

    public Node flatten(Node head) {
        if (head == null) {
            return head;
        }

        // Pointer
        Node p = head;
        while (p != null) {
            /*
             * CASE 1: if no child, proceed
             */
            if (p.child == null) {
                p = p.next;
                continue; //Skip forward since there is no child  
            }

            /*
             * CASE 2: got child, find the tail of the child and link it to
             * p.next
             */
            Node temp = p.child;

            // Find the tail of the child
            while (temp.next != null) {
                temp = temp.next;
            }
            // Connect tail with p.next, if it is not null
            temp.next = p.next;

            if (p.next != null) {
                p.next.prev = temp;
            }

            // Connect p with p.child, and remove p.child
            p.next = p.child;
            p.child.prev = p;
            p.child = null;
        }
        return head;
    }
}



/*

Iteration 1,2 will be skipped since they don't have any children
Iteration 3: We have p = 3, which has a child, so we are going to connect our child list to the current node = p
    So we are going to have a list like this: 
            1---2---3(p)         4---5---6--NULL
                    |            |
           (temp)-> 7---8---9---10
                        |
                        11--12--NULL
                        
Iteration 4 will be skipped since we have p = 7, and it doesn't have child so skip it
Iteration 5: When we have p = 8, we will be traversing the whole child list and just go on and change the tail node pointer of the child list! 
             1---2----3               4---5---6--NULL
                      |               |
                      7---8(p)    9---10
                           |      |
                 (temp)->  11----12
                 
Rest of the iterations don't have any children so need to do anything else. They will just go on skipping the iterations till the end of the list! 

*/