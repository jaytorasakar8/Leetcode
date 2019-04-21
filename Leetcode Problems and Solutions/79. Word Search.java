/*
 *
 * Given a 2D board and a word, find if the word exists in the grid.
 *
 * The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.
 *
 * Example:
 *
 * board =
 * [
 * ['A','B','C','E'],
 * ['S','F','C','S'],
 * ['A','D','E','E']
 * ]
 *
 * Given word = "ABCCED", return true.
 * Given word = "SEE", return true.
 * Given word = "ABCB", return false.
 *
 */

//Explanation: Given word = SEE. WE are allowed to search for the alphabets from the word in teh horizontal or vertical direction only. SO we need to search 4 directions that's why do DFS 
//in the given array -> S is available at index= arr[1][3], then E is available down at index = arr[2][3] and last E is available at index = arr[2][2]
class Solution {

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean result = false;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, word, i, j, 0)) {
                    result = true;
                }
            }
        }
        return result;
    }

//i and j are the indexes of the array of characters
//k is the index of the character in the given word. EG: k will be index of S or E or E in our pursuit to find if the characters are available in the grid
    public boolean dfs(char[][] board, String word, int i, int j, int k) {
        int m = board.length;
        int n = board[0].length;
        if (i < 0 || j < 0 || i >= m || j >= n) {
            return false;
        }
        if (board[i][j] == word.charAt(k)) {
            char temp = board[i][j];
            board[i][j] = '#';
            if (k == word.length() - 1) {
                return true;
            } else if (dfs(board, word, i - 1, j, k + 1)
                    || dfs(board, word, i + 1, j, k + 1)
                    || dfs(board, word, i, j - 1, k + 1)
                    || dfs(board, word, i, j + 1, k + 1)) {
                return true;
            }
            board[i][j] = temp;
        }
        return false;
    }
}
