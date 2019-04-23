/*

We are given a binary tree (with root node root), a target node, and an integer value K.

Return a list of the values of all nodes that have a distance K from the target node.  The answer can be returned in any order.

 

Example 1:

Input: root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, K = 2

Output: [7,4,1]

Explanation: 
The nodes that are a distance 2 from the target node (with value 5)
have values 7, 4, and 1.



Note that the inputs "root" and "target" are actually TreeNodes.
The descriptions of the inputs above are just serializations of these objects.
 

Note:

The given tree is non-empty.
Each node in the tree has unique values 0 <= node.val <= 500.
The target node is a node in the tree.
0 <= K <= 1000.

*/

class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K)
    {
         Map<TreeNode, TreeNode> nodeToParentMap = new HashMap();
         populateNodeToParentMap(nodeToParentMap, root, null);
        
         Queue<TreeNode> queue = new LinkedList();
         queue.add(target);

        Set<TreeNode> seen = new HashSet();
        seen.add(target);
        
        List<Integer> result = new ArrayList<Integer>();
         int currentLayer = 0;

        while (!queue.isEmpty()) 
        {

            if (currentLayer == K) 
            {
                for (TreeNode node: queue) {
                    result.add(node.val);
                }
                return result;
            }
        
            int layerSize = queue.size();
            
            for (int i = 0; i < layerSize; i++) 
            {

                 TreeNode currentNode = queue.poll();

                  if (currentNode.left != null && !seen.contains(currentNode.left)) 
                  {
                      seen.add(currentNode.left);
                      queue.offer(currentNode.left);
                  }

                  if (currentNode.right != null && !seen.contains(currentNode.right))
                  {
                     seen.add(currentNode.right);
                     queue.offer(currentNode.right);
                  }

                  TreeNode parentOfCurrentNode = nodeToParentMap.get(currentNode);
                  if (parentOfCurrentNode != null && !seen.contains(parentOfCurrentNode)) 
                  {
                     seen.add(parentOfCurrentNode);
                     queue.offer(parentOfCurrentNode);
                      
                      
                      
                      
                  }

            }

            currentLayer++; 

        }

  return new ArrayList<Integer>();
    }

    
    
    void populateNodeToParentMap(Map<TreeNode, TreeNode> nodeToParentMap,TreeNode root, TreeNode parent)
    {
        if (root == null) 
          return;
  
         nodeToParentMap.put(root, parent);
         populateNodeToParentMap(nodeToParentMap, root.left, root);
         populateNodeToParentMap(nodeToParentMap, root.right, root);

    }
}