/*

Given two non-empty binary trees s and t, check whether tree t has exactly the same structure and node values with a subtree of s. A subtree of s is a tree consists of a node in s and all of this node's descendants. The tree s could also be considered as a subtree of itself.

Example 1:
Given tree s:

     3
    / \
   4   5
  / \
 1   2
Given tree t:
   4 
  / \
 1   2
Return true, because t has the same structure and node values with a subtree of s.
Example 2:
Given tree s:

     3
    / \
   4   5
  / \
 1   2
    /
   0
Given tree t:
   4
  / \
 1   2
Return false.

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
class Solution {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s==null) 
            return t == null; //If source tree is null then see target is also null
        
    	return isSame(s, t) || isSubtree(s.left,t) || isSubtree(s.right,t); 
        //Check if current subtree starting with s is equal to target tree t
        //It may or may be the equal
        //So we are also calling the left subtree as well as right subtree to see if there is a match with the target tree! 
        //We are having OR condition because we can get same subtree at current node or at the left subtree or at the right subtree  
    }
	
    private boolean isSame(TreeNode s, TreeNode t){
    	if(s==null || t == null) 
            return t == s; //This is there to avoid a scenario like in above Example 2, wheere node 2 last a left child in source tree 
        
        //Check if the current source tree's root value is equal to target tree's root value
        //Simultaneously we also need to check the left node of S and T, as well as right node of S and T, are they equal
        //If all three are equal then only we return that we have found the subtree
    	return s.val == t.val && isSame(s.left, t.left) && isSame(s.right, t.right);
    }
}