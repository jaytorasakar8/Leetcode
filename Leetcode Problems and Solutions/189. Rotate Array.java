/*
 *
 * Given an array, rotate the array to the right by k steps, where k is non-negative.
 *
 * Example 1:
 *
 * Input: [1,2,3,4,5,6,7] and k = 3
 * Output: [5,6,7,1,2,3,4]
 * Explanation:
 * rotate 1 steps to the right: [7,1,2,3,4,5,6]
 * rotate 2 steps to the right: [6,7,1,2,3,4,5]
 * rotate 3 steps to the right: [5,6,7,1,2,3,4]
 * Example 2:
 *
 * Input: [-1,-100,3,99] and k = 2
 * Output: [3,99,-1,-100]
 * Explanation:
 * rotate 1 steps to the right: [99,-1,-100,3]
 * rotate 2 steps to the right: [3,99,-1,-100]
 *
 */

class Solution {

    public void rotate(int[] nums, int k) {

        ArrayList<Integer> al = new ArrayList();
        if (nums.length == 0 || nums.length < k) {
            for (int i = 0; i < nums.length; i++) {
                System.out.print(nums[i]);
            }
        } else {
            int temp = k;
            while (k != 0) {

                al.add(nums[nums.length - k]);
                k--;

            }
            // for(int i=0;i<al.size();i++)
            //System.out.println(al.get(i));

            for (int i = 0; i < nums.length - temp; i++) {
                al.add(nums[i]);
                // System.out.println(nums[i]);
            }
            int a[] = new int[al.size()];
            for (int i = 0; i < al.size(); i++) {
                nums[i] = al.get(i);
            }

        }
        /*
         * if(nums == null || nums.length < 2){ return; }
         *
         * k = k % nums.length; reverse(nums, 0, nums.length - k - 1);//Full
         * array reverse(nums, nums.length - k, nums.length - 1); //Partial,
         * second part of array reverse(nums, 0, nums.length - 1);//first part
         * of the arrya
         *
         * }
         *
         * private void reverse(int[] nums, int i, int j){ int tmp = 0; while(i
         * < j){ tmp = nums[i]; nums[i] = nums[j]; nums[j] = tmp; i++; j--;
    }
         */
    }
}
