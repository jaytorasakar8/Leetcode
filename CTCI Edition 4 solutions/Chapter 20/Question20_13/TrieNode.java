package Question20_13;

import java.util.LinkedList;

/* One node in the trie. Most of the logic of the trie is implemented
 * in this class.
 */
public class TrieNode
{
    // The children of this node in the trie.
    public LinkedList<TrieNode> childNodes;

    // The character stored in this node as data.
    public char character;	

    /* Constructs an empty trie node and initializes the list of its
     * children to an empty list. Used only to construct the root node
     * of the trie.
     */
    public TrieNode()
    {
        childNodes = new LinkedList<TrieNode>();
    }

    /* Constructs a trie node and stores in the node the char passed in
     * as the argument. Initializes the list of child nodes of this
     * node to an empty list.
     */
    public TrieNode(char character)
    {
        this();
        this.character = character;
    }

    /* Getter for the character data stored in this node.
     */
    public char getChar()
    {
        return character;
    }

    /* Add the String passed in as argument to the trie, starting at a
     * child node of this node. If any prefix of this String is already
     * present in the trie starting from a child node of this node, only
     * add the remaining part of the String to the trie, at the
     * appropriate position in the trie.
     */
    public void addWord(String word)
    {
        TrieNode child;
        char firstChar = word.charAt(0);

        TrieNode t = getNode(firstChar);

        if (t == null) {
            child = new TrieNode(firstChar);
            childNodes.add(child);
        } else {
            child = t;
        }

        if (word.length() > 1) {
            child.addWord(word.substring(1));
        } 
    }

    /* Find a child node of this node that has the char argument as its
     * data. Return null if no such child node is present in the trie.
     */
    TrieNode getNode(char c)
    {
        for (TrieNode t : childNodes)
            if (t.getChar() == c)
                return t;
        return null;
    }

}
