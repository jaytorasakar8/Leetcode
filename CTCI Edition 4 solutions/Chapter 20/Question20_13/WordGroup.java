package Question20_13;

import java.util.Hashtable;
import java.util.LinkedList;

/* A container for a group of words of the same length. */
public class WordGroup {
	private Hashtable<String, Boolean> lookup = new Hashtable<String, Boolean>();
    private LinkedList<String> group;
    
    public WordGroup() {
        group = new LinkedList<String>();
        for (String s : group) {
        	lookup.put(s, true);
        }
    }
    
    public boolean containsWord(String s) {
        if (lookup.containsKey(s)) {
        	return lookup.get(s);
        } else {
        	return false;
        }
    }
    
    public void addWord (String s) {
        group.add(s);
        lookup.put(s, true);
    }
    
    public int length() {
        return group.size();
    }
    
    public String getWord(int i){
        return group.get(i);
    }
    
    public LinkedList<String> getWords(){ 
        return group;
    }
    
    public static WordGroup[] createWordGroups(String[] list) {
    	WordGroup[] groupList;
    	int maxWordLength = 0;
		// Find out the length of the longest word
		for (int i = 0; i < list.length; i++) {
			if (list[i].length() > maxWordLength) {
				maxWordLength = list[i].length();
			}
		}

		// Group the words in the dictionary into lists of words of 
		// same length.groupList[i] will contain a list of words, each 
		// of length (i+1).
		groupList = new WordGroup[maxWordLength];
		for (int i = 0; i < list.length; i++) {
			if (groupList[list[i].length()-1] == null) {
				groupList[list[i].length()-1] = new WordGroup();
			}
			groupList[list[i].length()-1].addWord(list[i] );
		}
		return groupList;
    }
}
