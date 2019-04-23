/*

You are asked to cut off trees in a forest for a golf event. The forest is represented as a non-negative 2D map, in this map:

0 represents the obstacle can't be reached.
1 represents the ground can be walked through.
The place with number bigger than 1 represents a tree can be walked through, and this positive number represents the tree's height.
 

You are asked to cut off all the trees in this forest in the order of tree's height - always cut off the tree with lowest height first. And after cutting, the original place has the tree will become a grass (value 1).

You will start from the point (0, 0) and you should output the minimum steps you need to walk to cut off all the trees. If you can't cut off all the trees, output -1 in that situation.

You are guaranteed that no two trees have the same height and there is at least one tree needs to be cut off.

Example 1:

Input: 
[
 [1,2,3],
 [0,0,4],
 [7,6,5]
]
Output: 6
 

Example 2:

Input: 
[
 [1,2,3],
 [0,0,0],
 [7,6,5]
]
Output: -1
 

Example 3:

Input: 
[
 [2,3,4],
 [0,0,5],
 [8,7,6]
]
Output: 6
Explanation: You started from the point (0,0) and you can cut off the tree in (0,0) directly without walking.

*/

class Solution {
    int[][] dirs = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
    public int cutOffTree(List<List<Integer>> forest) {
        
        //create a list of int[] {x, y, Height}
        List<int[]> trees = new ArrayList<>();
        for (int i = 0; i < forest.size(); i++) {
            for (int j = 0; j < forest.get(0).size(); j++) {
                int height = forest.get(i).get(j);
                if (height > 1)
                    trees.add(new int[]{i, j, height});
            }
        }
        
        //Sort all the trees based on their height
        Collections.sort(trees, (a, b)->(a[2]-b[2]));
        
        //Run thru each test tree given to us
        int res = 0, x = 0, y = 0;
        for (int[] tree: trees) {
        //Do a BFS traversal from current location(x,y) to that tree location(tree[0], tree[1])
            int dist = bfs(forest, x, y, tree[0], tree[1]);
            if (dist < 0) 
                return -1;
            else
            {
                res = res + dist;
                x = tree[0];
                y = tree[1];
            }
        }
        return res;
    }
    
    private int bfs(List<List<Integer>> forest, int x, int y, int tx, int ty) 
    {
        //A typical BFS approach that we use
        int m = forest.size(), n = forest.get(0).size();
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];
        
        //Add the current source coordinates to the queue and mark it as visited
        queue.add(new int[]{x, y});
        visited[x][y] = true;
        
        int dist = 0;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
           
            for (int j = 0; j < size; j++) {
                int[] cur = queue.poll();
                
//If we have reached the tree at (tx,ty) through traversal then that means we can return the distance covered from (x,y) to (tx,ty)
                if (cur[0] == tx && cur[1] == ty) 
                    return dist;
                
                //Traverse in all 4 directions and then process it if it meets the conditions
                for (int i = 0; i < 4; i++) 
                {
                    int nx = cur[0]+dirs[i][0];
                    int ny = cur[1]+dirs[i][1];
                    
                    if (nx >= 0 && nx < m && ny >= 0 && ny < n && 
                        !visited[nx][ny] && forest.get(nx).get(ny) >= 1)
                    {
                      visited[nx][ny] = true;
                      queue.add(new int[]{nx, ny});
                   }
                }
            }
            dist++;
        }
        return -1;
    }
}
