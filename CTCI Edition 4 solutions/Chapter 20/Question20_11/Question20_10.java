package Question20_11;

import CareerCupLibrary.AssortedMethods;

public class Question20_10 {
	public static Subsquare findSquare(int[][] matrix){
		assert(matrix.length > 0);
		for (int row = 0; row < matrix.length; row++){
			assert(matrix[row].length == matrix.length);
		}
		
		int N = matrix.length;
		
		int currentMaxSize = 0;
		Subsquare sq = null;
		int col = 0;
		
		// Iterate through each column from left to right
		while (N - col > currentMaxSize) { // See step 4 above 
			for (int row = 0; row < matrix.length; row++){
				// starting from the biggest
				int size = N - Math.max(row, col);
				while (size > currentMaxSize){
					if (isSquare(matrix, row, col, size)){
						currentMaxSize = size;
						sq = new Subsquare(row, col, size);
						break; // go to next (full) column 
					}
					size--;
				}
			}
			col++;
		}
		return sq;
	}

	private static boolean isSquare(int[][] matrix, int row, int col, 
									 int size) {
		// Check top and bottom border.
		for (int j = 0; j < size; j++){
			if (matrix[row][col+j] == 1) {
				return false;
			}
			if (matrix[row+size-1][col+j] == 1){
				return false;
			}
		}
		
		// Check left and right border.
		for (int i = 1; i < size - 1; i++){
			if (matrix[row+i][col] == 1){
				return false;
			}
			if (matrix[row+i][col+size-1] == 1){
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		int[][] matrix = AssortedMethods.randomMatrix(30, 30, 0, 1);
		AssortedMethods.printMatrix(matrix);
		Subsquare square = findSquare(matrix);
		square.print();
	}
}
