/*

Design a class to find the kth largest element in a stream. Note that it is the kth largest element in the sorted order, not the kth distinct element.

Your KthLargest class will have a constructor which accepts an integer k and an integer array nums, which contains initial elements from the stream. For each call to the method KthLargest.add, return the element representing the kth largest element in the stream.

Example:

int k = 3;
int[] arr = [4,5,8,2];
KthLargest kthLargest = new KthLargest(3, arr);
kthLargest.add(3);   // returns 4
kthLargest.add(5);   // returns 5
kthLargest.add(10);  // returns 5
kthLargest.add(9);   // returns 8
kthLargest.add(4);   // returns 8

*/

class KthLargest {

    Queue<Integer> pq;
    int capacity;
    public KthLargest(int k, int[] nums) {
        capacity = k;
        pq = new PriorityQueue<Integer>();
        for(int i : nums) {
            add(i);
        }
    }
    
    public int add(int val) {
        // cannot directly do following
        // pq.offer(val)
        // return pq.peek()
        if(pq.size() < capacity)
            pq.offer(val);
        else {
            pq.offer(val); 
            pq.poll();
        }
        return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */