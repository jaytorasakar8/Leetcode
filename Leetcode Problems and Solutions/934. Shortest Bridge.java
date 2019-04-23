/*

In a given 2D binary array A, there are two islands.  (An island is a 4-directionally connected group of 1s not connected to any other 1s.)

Now, we may change 0s to 1s so as to connect the two islands together to form 1 island.

Return the smallest number of 0s that must be flipped.  (It is guaranteed that the answer is at least 1.)

 

Example 1:

Input: [[0,1],[1,0]]
Output: 1
Example 2:

Input: [[0,1,0],[0,0,0],[0,0,1]]
Output: 2
Example 3:

Input: [[1,1,1,1,1],[1,0,0,0,1],[1,0,1,0,1],[1,0,0,0,1],[1,1,1,1,1]]
Output: 1
 

Note:

1 <= A.length = A[0].length <= 100
A[i][j] == 0 or A[i][j] == 1
 

*/

class Solution {
  
    class Pos
    {
      int x;
      int y;
      public Pos(int x, int y)
      {
        this.x = x;
        this.y = y;
      }
    }   
  
public int shortestBridge(int[][] A) 
{
    // find one island
    boolean found = false;
    Queue<Pos> q = new LinkedList<>();
    
    for(int i = 0; i < A.length; i++)
    {
        if(found) 
            break;
        for(int j = 0; j < A[0].length; j++)
        {
            if(A[i][j] == 1)
            {
                dfs(A, i, j, q);  // find one island, use dfs to find connected conponent
                found = true;
                break;
            }
        }
    }
    
    
    // use bfs to find the shortest path
    int steps = 0;
    int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    
    while(!q.isEmpty())
    {
        int size = q.size();
       
        //extend boundary until we find the other island
        while(size-- != 0)
        {
            Pos p = q.poll();
            int x = p.x;
            int y = p.y;
           
            for(int i = 0; i < 4; i++)
            {
                int tx = x+dirs[i][0];
                int ty = y+dirs[i][1];
                
                if(tx < 0 || tx >= A.length || ty < 0 || ty >= A[0].length || A[tx][ty] == 2)
                    continue;
                
                if(A[tx][ty] == 1)
                    return steps;
                
                A[tx][ty] = 2;
                q.offer(new Pos(tx, ty));
            }
        }
        
        steps++;
    }
    
    return -1;
}

private void dfs(int[][] A, int x, int y, Queue<Pos> q){
    if(x < 0 || y < 0 || x >= A.length || y >= A[0].length || A[x][y] != 1)
        return;
    
    A[x][y] = 2;
    
    q.offer(new Pos(x, y));
    dfs(A, x+1, y, q);
    dfs(A, x-1, y, q);
    dfs(A, x, y+1, q);
    dfs(A, x, y-1, q);
}

}