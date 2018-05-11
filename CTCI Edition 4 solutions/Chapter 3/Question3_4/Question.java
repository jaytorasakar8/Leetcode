package Question3_4;

public class Question {
	public static void main(String[] args) {
		// Set up code.
		int n = 5;
		Tower[] towers = new Tower[n];
		for (int i = 0; i < 3; i++) towers[i] = new Tower(i);
		for (int i = n - 1; i >= 0; i--) towers[0].add(i);
		towers[0].moveDisks(n, towers[2], towers[1]);
	}
}
