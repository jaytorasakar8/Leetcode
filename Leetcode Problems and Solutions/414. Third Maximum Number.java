/*
 *
 * Given a non-empty array of integers, return the third maximum number in this array. If it does not exist, return the maximum number. The time complexity must be in O(n).
 *
 * Example 1:
 * Input: [3, 2, 1]
 *
 * Output: 1
 *
 * Explanation: The third maximum is 1.
 * Example 2:
 * Input: [1, 2]
 *
 * Output: 2
 *
 * Explanation: The third maximum does not exist, so the maximum (2) is returned instead.
 * Example 3:
 * Input: [2, 2, 3, 1]
 *
 * Output: 1
 *
 * Explanation: Note that the third maximum here means the third maximum distinct number.
 * Both numbers with value 2 are both considered as second maximum.
 *
 */

class Solution {

    public int thirdMax(int[] nums) {

        //Solution using Priority Queue similar to Q215
        TreeSet<Integer> s = new TreeSet<Integer>();

        for (int i : nums) {
            s.add(i);
        }

        List<Integer> al = new ArrayList<Integer>(s);

        int k = 3;
        PriorityQueue<Integer> queue = new PriorityQueue();
        if (s.size() == 2) {
            return Math.max(al.get(0), al.get(1));
        }
        if (s.size() == 1) {
            return al.get(0);
        }
        if (s.size() == 0) {
            return 0;
        } else {
            for (int i : s) {
                queue.offer(i);
                if (queue.size() > 3) {
                    queue.poll();
                }
            }
            return queue.peek();

        }

    }

}
