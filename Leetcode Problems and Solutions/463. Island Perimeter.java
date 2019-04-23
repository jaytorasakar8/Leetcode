/*
 *
 * You are given a map in form of a two-dimensional integer grid where 1 represents land and 0 represents water.
 *
 * Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water, and there is exactly one island (i.e., one or more connected land cells).
 *
 * The island doesn't have "lakes" (water inside that isn't connected to the water around the island). One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100. Determine the perimeter of the island.
 *
 *
 *
 * Example:
 *
 * Input:
 * [[0,1,0,0],
 * [1,1,1,0],
 * [0,1,0,0],
 * [1,1,0,0]]
 *
 * Output: 16
 *
 */

class Solution {

    public int islandPerimeter(int[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) { //If it is an island then do a DFS
                    return dfs(grid, visited, i, j);
                }
            }
        }
        return 0;
    }

    public int dfs(int[][] grid, boolean[][] visited, int r, int c) {
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length) {
            return 1;//If it is out of boundary then add one edge
        }

        if (grid[r][c] == 0) {
            return 1;//If is a water then add one 
        }

        if (visited[r][c]) {
            return 0;//If it already visited island, no need to add it one more time
        }
        visited[r][c] = true;

        return dfs(grid, visited, r + 1, c) + dfs(grid, visited, r - 1, c) + dfs(grid, visited, r, c + 1) + dfs(grid, visited, r, c - 1); //Recursively go in the 4 directions

    }
}
