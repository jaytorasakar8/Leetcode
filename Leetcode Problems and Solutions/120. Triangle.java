/*

Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

For example, given the following triangle

[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

Note:

Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.

*/

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
    int size = triangle.size();
    int[] results = new int[size+1];
    
    for(int i=size-1; i>=0; i--) {
        List<Integer> tmp = triangle.get(i);
        
        for(int j=0; j<tmp.size(); j++) {
            results[j] = Math.min(results[j], results[j+1]) + tmp.get(j);
        }
    }
    return results[0];
}

}