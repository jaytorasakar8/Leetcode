/*
 *
 * Given an m x n matrix of non-negative integers representing the height of each unit cell in a continent, the "Pacific ocean" touches the left and top edges of the matrix and the "Atlantic ocean" touches the right and bottom edges.
 *
 * Water can only flow in four directions (up, down, left, or right) from a cell to another one with height equal or lower.
 *
 * Find the list of grid coordinates where water can flow to both the Pacific and Atlantic ocean.
 *
 * Note:
 * The order of returned grid coordinates does not matter.
 * Both m and n are less than 150.
 * Example:
 *
 * Given the following 5x5 matrix:
 *
 * Pacific ~   ~   ~   ~   ~
 * ~  1   2   2   3  (5) *
 * ~  3   2   3  (4) (4) *
 * ~  2   4  (5)  3   1  *
 * ~ (6) (7)  1   4   5  *
 * ~ (5)  1   1   2   4  *
 *   *   *   *   * Atlantic
 *
 * Return:
 *
 * [[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]] (positions with parentheses in above matrix).
 *
 */

public class Solution {

    int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> res = new LinkedList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }

        int m = matrix.length, n = matrix[0].length;

        //One visited map for each ocean
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        Queue<int[]> pQueue = new LinkedList<>();
        Queue<int[]> aQueue = new LinkedList<>();

        //We are given tht vertical border on left and right are Pacific and Atlantic oceans respectively 
        for (int i = 0; i < m; i++) {
            pQueue.offer(new int[]{i, 0});
            aQueue.offer(new int[]{i, n - 1});
            pacific[i][0] = true;
            atlantic[i][n - 1] = true;
        }

        //Similarly we are given tht horizontal border on top and bottom are Pacific and Atlantic oceans respectively 
        for (int i = 0; i < n; i++) {
            pQueue.offer(new int[]{0, i});
            aQueue.offer(new int[]{m - 1, i});
            pacific[0][i] = true;
            atlantic[m - 1][i] = true;
        }

        bfs(matrix, pQueue, pacific);
        bfs(matrix, aQueue, atlantic);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    res.add(new int[]{i, j});
                }
            }
        }

        return res;
    }

    public void bfs(int[][] matrix, Queue<int[]> queue, boolean[][] visited) {
        int m = matrix.length, n = matrix[0].length;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int[] d : dir) {
                int x = cur[0] + d[0];
                int y = cur[1] + d[1];
                if (x >= 0 && x < m && y >= 0 && y < n && !visited[x][y] && matrix[x][y] >= matrix[cur[0]][cur[1]]) {
                    visited[x][y] = true;
                    queue.offer(new int[]{x, y});
                }
            }
        }
    }
}
