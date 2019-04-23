/*
 *
 * Given a matrix consists of 0 and 1, find the distance of the nearest 0 for each cell.
 *
 * The distance between two adjacent cells is 1.
 *
 *
 *
 * Example 1:
 *
 * Input:
 * [[0,0,0],
 * [0,1,0],
 * [0,0,0]]
 *
 * Output:
 * [[0,0,0],
 * [0,1,0],
 * [0,0,0]]
 * Example 2:
 *
 * Input:
 * [[0,0,0],
 * [0,1,0],
 * [1,1,1]]
 *
 * Output:
 * [[0,0,0],
 * [0,1,0],
 * [1,2,1]]
 *
 *
 * Note:
 *
 * The number of elements of the given matrix will not exceed 10,000.
 * There are at least one 0 in the given matrix.
 * The cells are adjacent in only four directions: up, down, left and right.
 *
 */

public class Solution {

    public int[][] updateMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                } else {
                    matrix[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();

            for (int[] d : dirs) {
                int nx = cell[0] + d[0];
                int ny = cell[1] + d[1];

                if (nx >= 0 && nx < m && ny >= 0 && ny < n
                        && matrix[nx][ny] > matrix[cell[0]][cell[1]] + 1) {
                    queue.add(new int[]{nx, ny});
                    matrix[nx][ny] = matrix[cell[0]][cell[1]] + 1;
                }
            }
        }

        return matrix;
    }
}
