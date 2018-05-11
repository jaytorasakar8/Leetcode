package Question1_7;

import CareerCupLibrary.AssortedMethods;

public class Question {
	public static void setZeros(int[][] matrix) {
		int[] row = new int[matrix.length];	
		int[] column = new int[matrix[0].length];

		// Store the row and column index with value 0
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length;j++) {
				if (matrix[i][j] == 0) {
					row[i] = 1; 
					column[j] = 1;
		 		}
			}
		}

		// Set arr[i][j] to 0 if either row i or column j has a 0
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if ((row[i] == 1 || column[j] == 1)) {
					matrix[i][j] = 0;
				}
			}
		}
	}	
	
	public static void main(String[] args) {
		int M = 3;
		int N = 5;
		int[][] matrix = AssortedMethods.randomMatrix(3, 5, 0, 5);
		AssortedMethods.printMatrix(matrix);
		setZeros(matrix);
		System.out.println();
		System.out.println();
		AssortedMethods.printMatrix(matrix);
	}

}
