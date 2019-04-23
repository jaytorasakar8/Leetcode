/*

Given an integer array, return the k-th smallest distance among all the pairs. The distance of a pair (A, B) is defined as the absolute difference between A and B.

Example 1:
Input:
nums = [1,3,1]
k = 1
Output: 0 
Explanation:
Here are all the pairs:
(1,3) -> 2
(1,1) -> 0
(3,1) -> 2
Then the 1st smallest distance pair is (1,1), and its distance is 0.
Note:
2 <= len(nums) <= 10000.
0 <= nums[i] < 1000000.
1 <= k <= len(nums) * (len(nums) - 1) / 2.

*/

class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        // nlog(n)
        Arrays.sort(nums);
        PriorityQueue<Node> heap = new PriorityQueue<>();
        // nlog(n)
        for(int i = 0; i < nums.length - 1; i++) {
            heap.offer(new Node(i, i+1, nums[i+1] - nums[i]));
        }
        int cnt = 0;
        Node node = null;
        // klog(n)
        while(cnt < k && !heap.isEmpty()) {
            node = heap.poll();
            if (node.end < nums.length - 1) {
                heap.offer(new Node(node.start, node.end + 1, nums[node.end + 1] - nums[node.start]));
            }
            cnt++;
        }
        if (node != null) {
            return node.dist;
        }
        return -1;
    }
    
    private static class Node implements Comparable<Node> {
        int start;
        int end;
        int dist;
        public Node(int start, int end, int dist) {
            this.start = start;
            this.end = end;
            this.dist = dist;
        }
        public int compareTo(Node n) {
            return this.dist - n.dist;
        }
    }
    
}