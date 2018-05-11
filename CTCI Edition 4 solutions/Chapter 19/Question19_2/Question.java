package Question19_2;

import CareerCupLibrary.AssortedMethods;

public class Question {

	enum Piece { Empty, Red, Blue };
	
	public static Piece hasWon(Piece[][] board) {
		int N = board.length;
		int num_diagonal_matches1 = 0;
		int num_diagonal_matches2 = 0;
		for (int i = 0; i < N; i++) { // for each row and column
			int num_row_matches = 0;
			int num_col_matches = 0;
			if (board[i][i] == board[0][0]) {
				num_diagonal_matches1++; /* Check first diagonal. */
			}
			if (board[i][N-i-1] == board[0][N-1]) {
				num_diagonal_matches2++; /* Check second diagonal. */
			}
			for (int j = 0; j < N; j++) {
				if (board[i][j] == board[i][0] && 
					board[i][0] != Piece.Empty) {
					num_row_matches++; /* Check next cell in the row. */
				}
				if (board[j][i] == board[0][i]) { 
					/* Check next cell in the column. */
					num_col_matches++;
				}	
				/* Allow breaking early if you know no one can win this 
				 * row or col. */
				if (num_row_matches != j+1 && num_col_matches != j+1) {
					break;
				}
			}
			/* Check for a win. */
			if (num_row_matches == N) {
				return board[i][0]; /* There’s a match on the ith row. */
			}
			
			if (num_col_matches == N) {
				return board[0][i]; /* There’s a match on ith column. */
			}
		}
		if (num_diagonal_matches1 == N) {
			/* There’s a match on the downward diagonal */
			return board[0][0];
	 	}
		if (num_diagonal_matches2 == N) {
			/* There’s a match on the upward diagonal. */
			return board[N-1][0]; 
		} 
		return Piece.Empty;
	}
	
	public enum Check {
		Row,
		Column,
		Diagonal,
		ReverseDiagonal
	}
	
	public static Piece getIthColor(Piece[][] board, int index, int var, Check check) {
		int N = board.length;
		if (check == Check.Row) {
			return board[index][var];
		} else if (check == Check.Column) {
			return board[var][index];
		} else if (check == Check.Diagonal) {
			return board[var][var];
		} else if (check == Check.ReverseDiagonal) {
			return board[N - 1 - var][var];
		}
		return Piece.Empty;
	}
	
	public static Piece getWinner(Piece[][] board, int fixed_index, Check check) {
		Piece color = getIthColor(board, fixed_index, 0, check);
		if (color == Piece.Empty) {
			return Piece.Empty;
		}
		for (int var = 1; var < board.length; var++) { 
			if (color != getIthColor(board, fixed_index, var, check)) {
				return Piece.Empty;
			}  
		}
		return color;
	}
	
	public static Piece hasWon2(Piece[][] board) {
		int N = board.length;
		Piece winner = Piece.Empty;
		
		// Check rows and columns
		for (int i = 0; i < N; i++) {
			winner = getWinner(board, i, Check.Row);
			if (winner != Piece.Empty) {
				return winner;
			}
			
			winner = getWinner(board, i, Check.Column);
			if (winner != Piece.Empty) {
				return winner;
			}
		}	
		
		winner = getWinner(board, -1, Check.Diagonal);
		if (winner != Piece.Empty) {
			return winner;
		}
		
		// Check diagonal
		winner = getWinner(board, -1, Check.ReverseDiagonal);
		if (winner != Piece.Empty) {
			return winner;
		}	
		
		return Piece.Empty;
	}
	
	public static Piece convertIntToPiece(int i) {
		if (i == 1) {
			return Piece.Blue;
		} else if (i == 2) {
			return Piece.Red;
		} else {
			return Piece.Empty;
		}
	}
	
	public static void main(String[] args) {
		int N = 3;
		int[][] board_t = AssortedMethods.randomMatrix(N, N, 0, 2);
		Piece[][] board = new Piece[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				board[i][j] = convertIntToPiece(board_t[i][j]);
			}
		}
		AssortedMethods.printMatrix(board_t);
		Piece p = hasWon2(board);
		System.out.println(p);
	}

}
