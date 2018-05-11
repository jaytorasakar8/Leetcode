package Question7_8;

import java.io.*;
import java.util.*;
import java.awt.Point;

public class Question {
	private final int white = 1;
	private final int black = 2;
	private int[][] board;
	/* Sets up the board in the standard othello starting positions,
	 * and starts the game */
	public void start () {
		board = new int [8] [8];
		board[3][3] = white;
		board[4][4] = white;
		board[3][4] = black;
		board[4][3] = black;
		game();
	}
	/* Prints an ascii art representation of the board. */
	private void printBoard () {
		System.out.println ("-----------------");
		for (int i = 0; i < 8; i++) {
			System.out.print("|");
			for (int j = 0; j < 8; j++) {
				switch (board [j] [i]) {
				case white:
					System.out.print("O|");
					break;
				case black:
					System.out.print("@|");
					break;
				default:
					System.out.print(" |");
					break;
				}
			}
			System.out.println("\n-----------------");
		}
		System.out.println("");
	}
	/* Returns the winner, if any. If there are no winners, returns
	 * 0 */
	private int won() {
		if (!canGo (white) && !canGo (black)) {
			int count = 0;
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8; j++) {
					if (board [i] [j] == white) {
						count++;
					}
					if (board [i] [j] == black) {
						count--;
					}
				}
			}
			if (count > 0) return white;
			if (count < 0) return black;
			return 3;
		}
		return 0;
	}
	/* Returns whether the player of the specified color has a valid
	 * move in his turn. This will return false when
	 * 1. none of his pieces are present
	 * 2. none of his moves result in him gaining new pieces
	 * 3. the board is filled up
	 */
	private boolean canGo(int color) {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (isValid(color, i, j))
					return true;
			}
		}
		return false;
	}
	/* Returns if a move at coordinate (x,y) is a valid move for the
	 * specified player */
	private boolean isValid(int color, int x, int y) {
		int opponent = 3 - color;
		if (x < 0 || x > 7 || y < 0 || y > 7) {
			return false;
		}
		if (board [x] [y] != 0) {
			return false; // The space is already occupied
		} else {
			// Check in all 8 directions
			for (int dx = -1; dx < 2; dx++) {
				for (int dy = -1; dy < 2; dy++) {
					if (x + dx < 0 || x + dx > 7 ||
							y + dy < 0 || y + dy > 7) {
						continue;
					}
					if (board [x + dx] [y + dy] == opponent) {
						// Found opponent piece
						int tempX = x;
						int tempY = y;
						while (true) {
							tempX += dx;
							tempY += dy;
							if (board[tempX][tempY] == 0) {
								break;
							}
							if (tempX < 0 || tempX > 7 ||
									tempY < 0 || tempY > 7) {
								break;
							}
							if (board [tempX] [tempY] == color) {
								return true;
							}
						}
					}
				}
			}
			return false;
		}
	}
	/* Prompts the player for a move and the coordinates for the move.
	 * Throws an exception if the input is not valid or if the entered
	 * coordinates do not make a valid move. */
	private void getMove (int color) throws Exception {
		BufferedReader br = new BufferedReader(
				new InputStreamReader (System.in));
		if (canGo(color)) {
			System.out.println ("It’s " + (color == 1 ?
					"white" : "black") + "’s turn:");
			int x, y;
			System.out.print ("Enter an x coordinate: ");
			x = Integer.parseInt (br.readLine ());
			System.out.print ("Enter an y coordinate: ");
			y = Integer.parseInt (br.readLine ());
			if (!isValid (color, x, y)) {
				throw new Exception ();
			} else {
				add (x, y, color);
			}
		} else {
			System.out.println((color== 1 ? "white": "black") +
			" doesn’t have any possible moves this turn, skipping.");
		}
	}
	/* Adds the move onto the board, and the pieces gained from that
	 * move. Assumes the move is valid. */
	private void add (int x, int y, int color) {
		List<Point> endPoints = new ArrayList<Point>();
		board[x][y] = color;
		int opponent = 3 - color;
		//check in all 8 directions
		for (int dx = -1; dx < 2; dx++) {
			for (int dy = -1; dy < 2; dy++) {
				if (x + dx < 0 || x + dx > 7 ||
						y + dy < 0 || y + dy > 7) {
					continue;
				}
				if (board[x + dx][y + dy] == opponent) {
					// Found opponent piece
					int tempX = x;
					int tempY = y;
					while (true) {
						tempX += dx;
						tempY += dy;
						if (board[tempX][tempY] == 0) {
							break;
						}
						if (tempX < 0 || tempX > 7 ||
								tempY < 0 || tempY > 7) {
							break;
						}
						if (board[tempX][tempY] == color) {
							endPoints.add(new Point(tempX, tempY));
						}
					}
				}
			}
		}
		for (int i = 0; i < endPoints.size(); i++) {
			Point p = endPoints.get(i);
			int dx = p.x - x;
			int dy = p.y - y;
			if (dx != 0) {
				dx = p.x - x > 0 ? 1:- 1;
			}
			if (dy != 0) {
				dy = p.y - y > 0 ? 1 : -1;
			}
			int tempX = x;
			int tempY = y;
			while (!(tempX == p.x && tempY == p.y)) {
				tempX += dx;
				tempY += dy;
				board[tempX][tempY] = color;
			}
		}
	}
	/* The actual game: runs continuously until a player wins */
	private void game() {
		printBoard();
		while (won() == 0) {
			boolean valid = false;
			while (!valid) {
				try {
					getMove(black);
					valid = true;
				} catch (Exception e) {
					System.out.println ("Please enter a valid coordinate!");
				}
			}
			valid = false;
			printBoard();
			while (!valid) {
				try {
					getMove(white);
					valid = true;
				} catch (Exception e) {
					System.out.println ("Please enter a valid coordinate!");
				}
			}
			printBoard ();
		}
		if(won()!=3) {
			System.out.println (won () == 1 ? "white" : "black" + " won!");
		} else {
			System.out.println("It’s a draw!");
		}
	}
	public static void main(String[] args) {
		Question o = new Question();
		o.start ();
	}
}
