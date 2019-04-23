/*
 *
 * You are given two integer arrays nums1 and nums2 sorted in ascending order and an integer k.
 *
 * Define a pair (u,v) which consists of one element from the first array and one element from the second array.
 *
 * Find the k pairs (u1,v1),(u2,v2) ...(uk,vk) with the smallest sums.
 *
 * Example 1:
 *
 * Input: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
 * Output: [[1,2],[1,4],[1,6]]
 * Explanation: The first 3 pairs are returned from the sequence:
 * [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
 * Example 2:
 *
 * Input: nums1 = [1,1,2], nums2 = [1,2,3], k = 2
 * Output: [1,1],[1,1]
 * Explanation: The first 2 pairs are returned from the sequence:
 * [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
 * Example 3:
 *
 * Input: nums1 = [1,2], nums2 = [3], k = 3
 * Output: [1,3],[2,3]
 * Explanation: All possible pairs are returned from the sequence: [1,3],[2,3]
 *
 */

public class Solution {

    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> result = new LinkedList<int[]>();
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0 || k == 0) {
            return result;
        }

        PriorityQueue<Triple> queue = new PriorityQueue<Triple>(nums1.length, new Comparator<Triple>() {
            public int compare(Triple a, Triple b) {
                return Integer.compare(a.sum, b.sum);
            }
        });

// add the first column
        for (int i = 0; i < nums1.length; i++) {
            queue.add(new Triple(nums1[i] + nums2[0], i, 0));
        }

        while (k-- > 0 && !queue.isEmpty()) {
            Triple current = queue.poll();
            result.add(new int[]{nums1[current.index1], nums2[current.index2]});
            // if the current one has a right candidate, add it to the queue. 
            if (current.index2 + 1 < nums2.length) {
                queue.add(new Triple(nums1[current.index1] + nums2[current.index2 + 1], current.index1, current.index2 + 1));
            }
        }

        return result;
    }

// Triple is used to store the sum, the index in nums1 and the index in nums2.
    class Triple {

        int sum;
        int index1;
        int index2;

        Triple(int sum, int index1, int index2) {
            this.sum = sum;
            this.index1 = index1;
            this.index2 = index2;
        }
    }
}


/*
    It is actually the same as how we merge k sorted list, in this question, the following are the k sorted list(each number in nums1[] full-mesh with the numbers in nums2[].

(1,2) -> (1,9) -> (1,10) -> (1,15)
(7,2) -> (7,9) -> (7,10) -> (7,15)
(11,2) -> (11,9) -> (11,10) -> (11,15)
(16,2) -> (16,9) -> (16,10) -> (16,15)

Remember how we do in "merge k sorted list"? We simply add the head of the list into the heap and when a node is poll(), we just add the node.next
    */
    
    /*public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> que = new PriorityQueue<>((a,b)->a[0]+a[1]-b[0]-b[1]);
        List<int[]> res = new ArrayList<>();
        
        if(nums1.length==0 || nums2.length==0 || k==0) 
            return res;
        
        //In the Priority Queue we maintain only k elements! 
        //Those k elements we are getting by traversing the nums1 array, and only considering j=0
        for(int i=0; i<nums1.length && i<k; i++)
            que.offer(new int[]{nums1[i], nums2[0], 0});
        //In the integer array we are storing the element from array1, array2, and index where we are in array2 
        
        //We will add elements to the queue only if we don't have k elements in our final list
        while(k-- > 0 && !que.isEmpty()){
            int[] cur = que.poll();
            res.add(new int[]{cur[0], cur[1]});
            
            if(cur[2] == nums2.length-1) 
                continue;//If we have reached the end of the nums2 array then skip the current iteration
            
            que.offer(new int[]{cur[0],nums2[cur[2]+1], cur[2]+1});
        }
        return res;
    }*/