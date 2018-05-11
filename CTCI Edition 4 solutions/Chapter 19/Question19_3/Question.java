package Question19_3;

public class Question {
	public static int numZeros(int num) {
		int count = 0;
		if (num < 0) {
			System.out.println("Factorial is not defined for negative numbers");
			return 0;
		}
		for (int i = 5; num / i > 0; i *= 5) {
			count += num / i;
		}
		return count;
	}
	
	public static int fact1(int num) {
		if (num == 1) {
			return 1;
		} else if (num > 1) {
			return num * fact1(num - 1);
		} else {
			return -1; // Error
		}
	}
	
	public static void main(String[] args) {
		for (int i = 1; i < 12; i++) {
			System.out.println(i + "! (or " + fact1(i) + ") has " + numZeros(i) + " zeros");
		}
	}
}
