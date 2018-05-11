package Question2_4;

import CareerCupLibrary.AssortedMethods;
import CareerCupLibrary.LinkedListNode;

public class Question {

	private static LinkedListNode addLists(LinkedListNode l1, LinkedListNode l2, int carry) {
		LinkedListNode result = new LinkedListNode(carry, null, null);
		int value = carry;
		if (l1 != null) {
			value += l1.data;
		}
		if (l2 != null) {
			value += l2.data;
		}
		result.data = value % 10;
		if (l1 != null || l2 != null || value >= 10) {
			LinkedListNode more = addLists(l1 == null ? null : l1.next, 
										   l2 == null ? null : l2.next, 
										   value >= 10 ? 1 : 0);
			result.setNext(more);
		}
		return result;
	}
	
	public static int linkedListToInt(LinkedListNode node) {
		int value = 0;
		if (node.next != null) {
			value = 10 * linkedListToInt(node.next);
		}
		return value + node.data;
	}
	
	public static void main(String[] args) {
		LinkedListNode list1 = AssortedMethods.randomLinkedList(5, 0, 9);
		LinkedListNode list2 = AssortedMethods.randomLinkedList(5, 0, 9);
		LinkedListNode list3 = addLists(list1, list2, 0);
		System.out.println("  " + list1.printForward());		
		System.out.println("+ " + list2.printForward());			
		System.out.println("= " + list3.printForward());	
		
		int l1 = linkedListToInt(list1);
		int l2 = linkedListToInt(list2);
		int l3 = linkedListToInt(list3);
		
		System.out.print(l1 + " + " + l2 + " = " + l3 + "\n");
		System.out.print(l1 + " + " + l2 + " = " + (l1 + l2));
	}
}
