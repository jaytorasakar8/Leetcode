package Question8_2;

import java.util.ArrayList;
import java.awt.*;
import CareerCupLibrary.AssortedMethods;

public class Question {
	public static int[][] maze = new int[10][10];
	
	public static boolean is_free(int x, int y) {
		if (maze[x][y] == 0) {
			return false;
		} else {
			return true;
		}
	}

	public static ArrayList<Point> current_path = new ArrayList<Point>();
	public static boolean getPaths(int x, int y) {
		Point p = new Point(x, y);
		current_path.add(p);
		if (0 == x && 0 == y) {
			return true; // current_path;
		}
		boolean success = false;
		if (x >= 1 && is_free(x - 1, y)) { // Try right
			success = getPaths(x - 1, y); // Free!  Go right
		}
		if (!success && y >= 1 && is_free(x, y - 1)) { // Try down
			success = getPaths(x, y - 1); // Free!  Go down
		}
		if (!success) {
			current_path.remove(p); // Wrong way! Better stop going this way
		}
		return success;
	}
	
	public static void main(String[] args) {
		maze = AssortedMethods.randomMatrix(10, 10, 0, 4);
		AssortedMethods.printMatrix(maze);
		getPaths(9, 9);
		String s = AssortedMethods.listOfPointsToString(current_path);
		System.out.println(s);
	}

}
