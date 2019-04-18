/*
 * Write a program to solve a Sudoku puzzle by filling the empty cells.
 *
 * A sudoku solution must satisfy all of the following rules:
 *
 * Each of the digits 1-9 must occur exactly once in each row.
 * Each of the digits 1-9 must occur exactly once in each column.
 * Each of the the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
 * Empty cells are indicated by the character '.'.
 *
 *
 * A sudoku puzzle...
 *
 *
 * ...and its solution numbers marked in red.
 *
 * Note:
 *
 * The given board contain only digits 1-9 and the character '.'.
 * You may assume that the given Sudoku puzzle will have a single unique solution.
 * The given board size is always 9x9.
 *
 */

class Solution {

    public void solveSudoku(char[][] board) {
        solve(board);
    }

    public boolean solve(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    continue;
                }
                for (int k = 1; k <= 9; k++) {
                    board[i][j] = (char) (k + '0');
                    if (isValid(board, i, j) && solve(board)) {
                        return true;
                    }
                    board[i][j] = '.';
                }
                return false;
            }
        }
        return true;
    }

    public boolean isValid(char[][] board, int i, int j) {
        HashSet<Character> set = new HashSet<Character>();
        for (int k = 0; k < 9; k++) {
            if (set.contains(board[i][k])) {
                return false;
            }
            if (board[i][k] != '.') {
                set.add(board[i][k]);
            }
        }
        set.clear();
        for (int k = 0; k < 9; k++) {
            if (set.contains(board[k][j])) {
                return false;
            }
            if (board[k][j] != '.') {
                set.add(board[k][j]);
            }
        }
        set.clear();
        for (int m = 0; m < 3; m++) {
            for (int n = 0; n < 3; n++) {
                int x = i / 3 * 3 + m;
                int y = j / 3 * 3 + n;
                if (set.contains(board[x][y])) {
                    return false;
                }
                if (board[x][y] != '.') {
                    set.add(board[x][y]);
                }
            }
        }
        return true;
    }
}
