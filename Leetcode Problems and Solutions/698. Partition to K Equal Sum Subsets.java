/*

Given an array of integers nums and a positive integer k, find whether it's possible to divide this array into k non-empty subsets whose sums are all equal.

 

Example 1:

Input: nums = [4, 3, 2, 3, 5, 2, 1], k = 4
Output: True
Explanation: It's possible to divide it into 4 subsets (5), (1, 4), (2,3), (2,3) with equal sums.
 

Note:

1 <= k <= len(nums) <= 16.
0 < nums[i] < 10000.

*/

class Solution {
    public boolean canPartitionKSubsets(int[] A, int k) {
        if (k > A.length) 
            return false;
        
        int sum = 0;
        for (int num : A) 
            sum += num;
        
        if (sum % k != 0) 
            return false;
        
        boolean[] visited = new boolean[A.length];
        //Arrays.sort(A);
        return dfs(A, 0, A.length - 1, visited, sum / k, k);
    }

    public boolean dfs(int[] A, int sum, int lastIndex, boolean[] visited, int target, int round) {
        if (round == 0)
            return true;
        if (sum == target && dfs(A, 0, A.length - 1, visited, target, round - 1))
            return true;
        
        for (int i = lastIndex; i >= 0; --i) {
            if (!visited[i] && sum + A[i] <= target) {
                visited[i] = true;
                if (dfs(A, sum + A[i], i - 1, visited, target, round))
                    return true;
                visited[i] = false;
            }
        }
        return false;
    }
    
    /*
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        //First get the sum of all nums. If sum is not divisible by k then return false.
        for(int num:nums)
            sum += num;
        if(k <= 0 || sum%k != 0)
            return false;
        int[] visited = new int[nums.length];
        return canPartition(nums, visited, 0, k, 0, 0, sum/k);
    }
    
    public boolean canPartition(int[] nums, int[] visited, int start_index, int k, int cur_sum, int cur_num, int target)
    {
        if(k==1)
            return true;
        
        //If one of the subsets equals the target sum of subset, then we return true 
        if(cur_sum == target && cur_num>0)
            return canPartition(nums, visited, 0, k-1, 0, 0, target); 
        
        for(int i = start_index; i<nums.length; i++){
            if(visited[i] == 0){
                visited[i] = 1;
                if(canPartition(nums, visited, i+1, k, cur_sum + nums[i], cur_num++, target))
                    return true;
                visited[i] = 0;
            }
        }
        return false;
    }
*/
}