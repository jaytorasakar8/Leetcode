package Question20_8;

import java.util.ArrayList;

public class SuffixTree {
	SuffixTreeNode root = new SuffixTreeNode();
	
	public SuffixTree(String s) {
		for (int i = 0; i < s.length(); i++) {
	    	String suffix = s.substring(i);
	    	root.insertString(suffix, i);
		}
	}
	
	public ArrayList<Integer> getIndexes(String s) {
		return root.getIndexes(s);
	}
}
