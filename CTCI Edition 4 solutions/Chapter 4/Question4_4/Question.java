package Question4_4;

import CareerCupLibrary.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class Question {

	public static ArrayList<LinkedList<TreeNode>> findLevelLinkList(TreeNode root) {
		int level = 0;
		ArrayList<LinkedList<TreeNode>> result = new ArrayList<LinkedList<TreeNode>>();
		LinkedList<TreeNode> list = new LinkedList<TreeNode>();
		list.add(root);
		result.add(level, list);
		while (true) {
			list = new LinkedList<TreeNode>();
			for(int i = 0; i < result.get(level).size(); i++){
				TreeNode n = (TreeNode) result.get(level).get(i);
				if(n != null) {
					if(n.left != null) list.add(n.left);
					if(n.right!= null) list.add(n.right);
				}
			}
			if (list.size() > 0) {
				result.add(level + 1, list);
			}
			else { 
				break;
			}
			level++;
		}
		return result;
	}
	
	public static void printResult(ArrayList<LinkedList<TreeNode>> result){
		int depth = 0;
		for(LinkedList<TreeNode> entry : result) {
			Iterator<TreeNode> i = entry.listIterator();
			System.out.print("Link list at depth " + depth + ":");
			while(i.hasNext()){
				System.out.print(" " + ((TreeNode)i.next()).data);
			}
			System.out.println();
			depth++;
		}
	}
	

	public static void main(String[] args) {
		int[] nodes_flattened = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		TreeNode root = AssortedMethods.createTreeFromArray(nodes_flattened);
		ArrayList<LinkedList<TreeNode>> list = findLevelLinkList(root);
		printResult(list);
	}

}
