/*
 *
 * Let's play the minesweeper game (Wikipedia, online game)!
 *
 * You are given a 2D char matrix representing the game board. 'M' represents an unrevealed mine, 'E' represents an unrevealed empty square, 'B' represents a revealed blank square that has no adjacent (above, below, left, right, and all 4 diagonals) mines, digit ('1' to '8') represents how many mines are adjacent to this revealed square, and finally 'X' represents a revealed mine.
 *
 * Now given the next click position (row and column indices) among all the unrevealed squares ('M' or 'E'), return the board after revealing this position according to the following rules:
 *
 * If a mine ('M') is revealed, then the game is over - change it to 'X'.
 * If an empty square ('E') with no adjacent mines is revealed, then change it to revealed blank ('B') and all of its adjacent unrevealed squares should be revealed recursively.
 * If an empty square ('E') with at least one adjacent mine is revealed, then change it to a digit ('1' to '8') representing the number of adjacent mines.
 * Return the board when no more squares will be revealed.
 *
 *
 * Example 1:
 *
 * Input:  *
 * [['E', 'E', 'E', 'E', 'E'],
 * ['E', 'E', 'M', 'E', 'E'],
 * ['E', 'E', 'E', 'E', 'E'],
 * ['E', 'E', 'E', 'E', 'E']]
 *
 * Click : [3,0]
 *
 * Output:  *
 * [['B', '1', 'E', '1', 'B'],
 * ['B', '1', 'M', '1', 'B'],
 * ['B', '1', '1', '1', 'B'],
 * ['B', 'B', 'B', 'B', 'B']]
 *
 * Explanation:
 *
 * Example 2:
 *
 * Input:  *
 * [['B', '1', 'E', '1', 'B'],
 * ['B', '1', 'M', '1', 'B'],
 * ['B', '1', '1', '1', 'B'],
 * ['B', 'B', 'B', 'B', 'B']]
 *
 * Click : [1,2]
 *
 * Output:  *
 * [['B', '1', 'E', '1', 'B'],
 * ['B', '1', 'X', '1', 'B'],
 * ['B', '1', '1', '1', 'B'],
 * ['B', 'B', 'B', 'B', 'B']]
 *
 * Explanation:
 *
 *
 *
 * Note:
 *
 * The range of the input matrix's height and width is [1,50].
 * The click position will only be an unrevealed square ('M' or 'E'), which also means the input board contains at least one clickable square.
 * The input board won't be a stage when game is over (some mines have been revealed).
 * For simplicity, not mentioned rules should be ignored in this problem. For example, you don't need to reveal all the unrevealed mines when the game is over, consider any cases that you will win the game or flag any squares.
 *
 */

public class Solution {

    public char[][] updateBoard(char[][] board, int[] click) {
        int m = board.length, n = board[0].length;
        Queue<int[]> q = new LinkedList<>();

        if (board[click[0]][click[1]] == 'M') {
            board[click[0]][click[1]] = 'X';
            return board;
        } else {
            board[click[0]][click[1]] = 'B';
        }

        int[] dx = {1, 1, 0, -1, -1, -1, 0, 1};
        int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

        q.offer(click);

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            int count = 0;

            for (int k = 0; k < 8; k++) {
                int i = cur[0] + dx[k], j = cur[1] + dy[k];
                if (i < 0 || i >= m || j < 0 || j >= n) {
                    continue;
                }
                if (board[i][j] == 'M') {
                    count++;
                }
            }

            if (count != 0) {
                board[cur[0]][cur[1]] = (char) ('0' + count);
            } else {
                for (int k = 0; k < 8; k++) {
                    int i = cur[0] + dx[k], j = cur[1] + dy[k];

                    if (i < 0 || i >= m || j < 0 || j >= n) {
                        continue;
                    }
                    if (board[i][j] == 'E') {
                        board[i][j] = 'B';
                        q.offer(new int[]{i, j});
                    }
                }
            }
        }

        return board;
    }
}
