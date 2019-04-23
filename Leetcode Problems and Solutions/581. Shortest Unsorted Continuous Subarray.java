/*
Given an integer array, you need to find one continuous subarray that if you only sort this subarray in ascending order, then the whole array will be sorted in ascending order, too.

You need to find the shortest such subarray and output its length.

Example 1:
Input: [2, 6, 4, 8, 10, 9, 15]
Output: 5
Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.
Note:
Then length of the input array is in range [1, 10,000].
The input array may contain duplicates, so ascending order here means <=.

*/

class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int length = nums.length;
        int start =-1 ;
        int end = -2;
        int min = nums[length-1];
        int max = nums[0];
        
        for(int i=1;i<length;i++){
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[length-i-1]);
            
            if(nums[i] < max){
                end = i;
            }
           
            if(nums[length-1-i] > min){
                start = length-1-i;
            }
        }
        return end-start+1;
    }
}