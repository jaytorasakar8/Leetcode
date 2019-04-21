/*

Given a binary tree

struct Node {
  int val;
  Node *left;
  Node *right;
  Node *next;
}
Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

Example:

Input: {"$id":"1","left":{"$id":"2","left":{"$id":"3","left":null,"next":null,"right":null,"val":4},"next":null,"right":{"$id":"4","left":null,"next":null,"right":null,"val":5},"val":2},"next":null,"right":{"$id":"5","left":null,"next":null,"right":{"$id":"6","left":null,"next":null,"right":null,"val":7},"val":3},"val":1}

Output: {"$id":"1","left":{"$id":"2","left":{"$id":"3","left":null,"next":{"$id":"4","left":null,"next":{"$id":"5","left":null,"next":null,"right":null,"val":7},"right":null,"val":5},"right":null,"val":4},"next":{"$id":"6","left":null,"next":null,"right":{"$ref":"5"},"val":3},"right":{"$ref":"4"},"val":2},"next":null,"right":{"$ref":"6"},"val":1}

Explanation: Given the above binary tree (Figure A), your function should populate each next pointer to point to its next right node, just like in Figure B.

*/

/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val,Node _left,Node _right,Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/
class Solution {
    public Node connect(Node root) {
        /*
            This solution can be used for the same problem Part I. Using level order traversal is going to be very useful.
            What we are doing is processing all the nodes of any particular level.
            We are processing each node without changing the left and right pointers. We are just changing each node's next pointer.
            If it the last node of that level, then make it's next pointer = null
            Otherwise, if it a general node in the level order traversal then we are going to just connect current node to the next node(by peeking in the queue and then using it as next pointer)
            
        */
        if(root == null) 
            return null;
        
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        int len = 1;
        
        while(!q.isEmpty()) {
            Node current = q.poll();
            len--;
            
            if(current.left != null) 
                q.add(current.left);
            if(current.right != null)
                q.add(current.right);
            
            if(len == 0)
            {
                len = q.size();
                current.next = null;
            } 
            else 
                current.next = q.peek();
        }
        return root;
    }
    
}