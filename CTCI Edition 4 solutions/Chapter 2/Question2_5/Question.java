package Question2_5;

import CareerCupLibrary.LinkedListNode;

public class Question {

	public static LinkedListNode FindBeginning(LinkedListNode head) {
		LinkedListNode n1 = head;
		LinkedListNode n2 = head; 
		
		// Find meeting point
		while (n2.next != null) { 
			n1 = n1.next; 
			n2 = n2.next.next; 
			if (n1 == n2) { 
				break; 
			}
		}

		// Error check - there is no meeting point, and therefore no loop
		if (n2.next == null) {
			return null;
		}

		/* Move n1 to Head. Keep n2 at Meeting Point.  Each are k steps
		/* from the Loop Start. If they move at the same pace, they must
		 * meet at Loop Start. */
		n1 = head; 
		while (n1 != n2) { 
			n1 = n1.next; 
			n2 = n2.next; 
		}
		// Now n2 points to the start of the loop.
		return n2;
	}
	
	public static void main(String[] args) {
		LinkedListNode[] nodes = new LinkedListNode[10];
		
		for (int i = 0; i < 10; i++) {
			nodes[i] = new LinkedListNode(i, null, i > 0 ? nodes[i - 1] : null);
		}
		
		// Create loop;
		nodes[9].next = nodes[3];
		
		LinkedListNode loop = FindBeginning(nodes[0]);
		System.out.println(loop.data);
	}

}
