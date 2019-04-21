/*
 *
 * Given a positive integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
 *
 * Example:
 *
 * Input: 3
 * Output:
 * [
 * [ 1, 2, 3 ],
 * [ 8, 9, 4 ],
 * [ 7, 6, 5 ]
 * ]
 *
 */

class Solution {

    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];

        int row = n;
        int col = n;

        int left = 0, right = col - 1;
        int top = 0, bottom = row - 1;
        int count = 0;

        while (true) {
            for (int i = left; i <= right; i++) {
                matrix[top][i] = ++count;
            }
            top++;
            if (top > bottom) {
                break;
            }

            for (int i = top; i <= bottom; i++) {
                matrix[i][right] = ++count;
            }
            right--;
            if (right < left) {
                break;
            }

            for (int i = right; i >= left; i--) {
                matrix[bottom][i] = ++count;
            }
            bottom--;
            if (bottom < top) {
                break;
            }

            for (int i = bottom; i >= top; i--) {
                matrix[i][left] = ++count;
            }
            left++;
            if (left > right) {
                break;
            }
        }
        return matrix;

    }
}
