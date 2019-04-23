/*

Given an integer array with no duplicates. A maximum tree building on this array is defined as follow:

The root is the maximum number in the array.
The left subtree is the maximum tree constructed from left part subarray divided by the maximum number.
The right subtree is the maximum tree constructed from right part subarray divided by the maximum number.
Construct the maximum tree by the given array and output the root node of this tree.

Example 1:
Input: [3,2,1,6,0,5]
Output: return the tree root node representing the following tree:

      6
    /   \
   3     5
    \    / 
     2  0   
       \
        1
Note:
The size of the given array will be in the range [1,1000].

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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        
        return helper(nums, 0, nums.length);
    }
    
    TreeNode helper(int[] nums, int left, int right)
    {
        //Incase we have only single element in the subarray
        if (left == right)
            return null;
        
        int maxIndex = left;
        //Get the maxIndex from our subarray of [left, right] index limit
        for (int i = left; i < right; i++) {
            maxIndex = (nums[i] > nums[maxIndex]) ? i : maxIndex;
        }
        
        //Create a root node using the maximum node from the given subarray of [left, right] limit
        TreeNode root = new TreeNode(nums[maxIndex]);
        
        root.left = helper(nums, left, maxIndex);
        root.right = helper(nums, maxIndex + 1, right);
       
        return root;
    }
}