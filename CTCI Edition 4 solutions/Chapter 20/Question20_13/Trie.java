package Question20_13;

import java.util.LinkedList;

/* Implements a trie. We store the input list of words in tries so
 * that we can efficiently find words with a given prefix. 
 */ 
public class Trie
{
    // The root of this trie.
    private TrieNode root;

    /* The only constructor for the Trie class. Takes a list of strings
     * as an argument, and constructs a trie that stores these strings.
     */
    public Trie(LinkedList<String> list)
    {
        root = new TrieNode();
        for (String word : list) 
            root.addWord(word);
    }

    /* Checks whether this trie contains a string with the prefix passed
     * in as argument.
     */
    public boolean contains (String prefix)
    {
        TrieNode lastNode = root;
        for (int i = 0; i< prefix.length(); i++) {
            lastNode = lastNode.getNode(prefix.charAt(i));
            if (lastNode == null) 
                return false;	 
        }
        return true;
    }

}
