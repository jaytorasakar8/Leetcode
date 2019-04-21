/*
 *
 * Given a set of distinct integers, nums, return all possible subsets (the power set).
 *
 * Note: The solution set must not contain duplicate subsets.
 *
 * Example:
 *
 * Input: nums = [1,2,3]
 * Output:
 * [
 * [3],
 * [1],
 * [2],
 * [1,2,3],
 * [1,3],
 * [2,3],
 * [1,2],
 * []
 * ]
 *
 */

 /*
 * This is a typical Backtracking problem. In case you wish to look at generic Backtracking problems and solutions, then:
 *
 * Reference solution here: https://leetcode.com/problems/subsets/discuss/27281/A-general-approach-to-backtracking-questions-in-Java-(Subsets-Permutations-Combination-Sum-Palindrome-Partitioning)
 */
class Solution {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        //Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, 0);
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int start) {
        list.add(new ArrayList<>(tempList));

        //System.out.println("Resultant list: " + list);
        for (int i = start; i < nums.length; i++) {
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }
}

/*
The way we are performing operations is:
1. Sort the given array. 
2. Then call the function of backtracking with an empty set, since empty set is also also a subset of the given array
3. The back track function is basically to make sure that we traverse every possible combination available from our input array
    i) First we start with an empty list, which is also an subset of any given array
    ii) Then we take the first element i.e. 1, and proceed to get all combinations possible with by recursively calling the function
    iii) Once all combinations of first element are done, then we take the next element i.e. 2, and then get all the combinations starting with the number 2. 
    iv) We are automatically eliminating subsets with same values i.e [1,2] and [2,1] is same. The duplicates are automatically handled by the for loop since we are starting from element start is incrementing as we go on traversing
    
    
    The output looks like this: 
    1. Resultant list: [[]]   <----- The empty subset
    ----------------All combinations starting from 1 are explored ---------------------
    2. Resultant list: [[], [1]]
    3. Resultant list: [[], [1], [1, 2]]
    4. Resultant list: [[], [1], [1, 2], [1, 2, 3]]
    5. Resultant list: [[], [1], [1, 2], [1, 2, 3], [1, 3]]
    ----------------All combinations with 1 are done and now starting from 2 are explored ---------------------
    6. Resultant list: [[], [1], [1, 2], [1, 2, 3], [1, 3], [2]]
    7. Resultant list: [[], [1], [1, 2], [1, 2, 3], [1, 3], [2], [2, 3]]
    ----------------All combinations with 2 are done and now starting from 3 are explored ---------------------
    8. Resultant list: [[], [1], [1, 2], [1, 2, 3], [1, 3], [2], [2, 3], [3]]
*/
