/*
 *
 * Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.
 *
 * Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.
 *
 * Example:  *
 * You may serialize the following tree:
 *
 * 1
 * / \
 * 2   3
 * / \
 * 4   5
 *
 * as "[1,2,3,null,null,4,5]"
 * Clarification: The above format is the same as how LeetCode serializes a binary tree. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.
 *
 * Note: Do not use class member/global/static variables to store states. Your serialize and deserialize algorithms should be stateless.
 *
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    private final static String NULL = "null";
    private final static String SEP = ",";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeHelper(root, sb);

        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    private void serializeHelper(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append(NULL);
            sb.append(SEP);
            return;
        }
        sb.append(String.valueOf(node.val));
        sb.append(SEP);

        serializeHelper(node.left, sb);
        serializeHelper(node.right, sb);
    }

    private int index;

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] ss = data.split(",");//split on comma
        index = 0;
        return deserializeHelper(ss);
    }

    private TreeNode deserializeHelper(String[] ss) {
        if (ss[index].equals(NULL)) {
            index++;
            return null;
        } else {
            TreeNode node = new TreeNode(Integer.parseInt(ss[index]));
            index++;
            node.left = deserializeHelper(ss);
            node.right = deserializeHelper(ss);
            return node;
        }
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
