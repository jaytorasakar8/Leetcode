package Question4_8;

import java.util.ArrayList;
import CareerCupLibrary.TreeNode;

public class Question {
	public static void findSum(TreeNode head, int sum, ArrayList<Integer> buffer, int level) {
		if (head == null) {
			return;
		}
		int tmp = sum;
		buffer.add(head.data);
		for (int i = level;i >- 1; i--){
			tmp -= buffer.get(i);
			if (tmp == 0) {
				print(buffer, i, level);
			}
		}
		ArrayList<Integer> c1 = (ArrayList<Integer>) buffer.clone();
		ArrayList<Integer> c2 = (ArrayList<Integer>) buffer.clone();
		findSum(head.left, sum, c1, level + 1);
		findSum(head.right, sum, c2, level + 1);
	}

	private static void print(ArrayList<Integer> buffer, int level, int i2) {
		for (int i = level; i <= i2; i++) {
			System.out.print(buffer.get(i) + " ");
		}
		System.out.println();
	}

	public static void main(String [] args){
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(3);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(8);
		root.right.left = new TreeNode(2);
		root.right.right = new TreeNode(6);
		findSum(root, 8, new ArrayList<Integer>(), 0);
	}
}

