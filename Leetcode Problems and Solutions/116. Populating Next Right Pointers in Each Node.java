/*

You are given a perfect binary tree where all leaves are on the same level, and every parent has two children. The binary tree has the following definition:

struct Node {
  int val;
  Node *left;
  Node *right;
  Node *next;
}
Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

Example:

Input: {"$id":"1","left":{"$id":"2","left":{"$id":"3","left":null,"next":null,"right":null,"val":4},"next":null,"right":{"$id":"4","left":null,"next":null,"right":null,"val":5},"val":2},"next":null,"right":{"$id":"5","left":{"$id":"6","left":null,"next":null,"right":null,"val":6},"next":null,"right":{"$id":"7","left":null,"next":null,"right":null,"val":7},"val":3},"val":1}

Output: {"$id":"1","left":{"$id":"2","left":{"$id":"3","left":null,"next":{"$id":"4","left":null,"next":{"$id":"5","left":null,"next":{"$id":"6","left":null,"next":null,"right":null,"val":7},"right":null,"val":6},"right":null,"val":5},"right":null,"val":4},"next":{"$id":"7","left":{"$ref":"5"},"next":null,"right":{"$ref":"6"},"val":3},"right":{"$ref":"4"},"val":2},"next":null,"right":{"$ref":"7"},"val":1}

Explanation: Given the above perfect binary tree (Figure A), your function should populate each next pointer to point to its next right node, just like in Figure B.
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
    public Node connect(Node root) 
    {
         if(root == null) 
            return null;
        
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        int len = 1;
        
        while(!q.isEmpty()) {
            Node tmp = q.poll();
            len--;
            
            if(tmp.left != null) 
                q.add(tmp.left);
            if(tmp.right != null)
                q.add(tmp.right);
            
            if(len == 0)
            {
                len = q.size();
                tmp.next = null;
            } 
            else 
                tmp.next = q.peek();
        }
        return root;
        /*
        Node level_start = root;
        while(level_start!=null)
        {
            Node cur = level_start;
            while(cur!=null)
            {
                if(cur.left!=null)
                    cur.left.next = cur.right;
                if(cur.right!=null && cur.next!=null)
                    cur.right.next = cur.next.left;
                cur = cur.next;
            }
            
            level_start = level_start.left;
        }
        return root;*/
    }
}