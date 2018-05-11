package Question4_5;

import CareerCupLibrary.TreeNode;

public class Question {

	public static TreeNode inorderSucc(TreeNode e) { 
		if (e != null) { 
			TreeNode p; 
			// Found right children -> return 1st inorder node on right
			if (e.parent == null || e.right != null) { 
				p = leftMostChild(e.right); 
			} else { 
				// Go up until we’re on left instead of right (case 2b)
				while ((p = e.parent) != null) { 
					if (p.left == e) {
						break; 
					}
					e = p; 
				} 
			} 
			return p; 
		} 
		return null; 
	} 
		
	public static TreeNode leftMostChild(TreeNode e) {
		if (e == null) return null;
		while (e.left != null) e = e.left; 
		return e; 
	}
	
	public static void main(String[] args) {
		int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		TreeNode root = TreeNode.createMinimalBST(array);
		for (int i = 0; i < array.length; i++) {
			TreeNode node = root.find(array[i]);
			TreeNode next = inorderSucc(node);
			if (next != null) {
				System.out.println(node.data + "->" + next.data);
			} else {
				System.out.println(node.data + "->" + null);
			}
		}
	}

}
