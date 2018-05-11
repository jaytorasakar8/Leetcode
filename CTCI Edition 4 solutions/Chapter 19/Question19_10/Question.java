package Question19_10;

public class Question {
	public static int rand7() {
		while (true) {
			int num = 5 * (rand5() - 1) + (rand5() - 1);
			if (num < 21) return (num % 7 + 1);
		}
	}

	public static int rand5() {
		return (int) (Math.random() * 100) % 5 + 1;
	}

	public static void main(String[] args) {
		/* Test: call rand7 many times and inspect the results. */
		int[] arr = new int[7];
		int test_size = 1000000;
		for(int k = 0; k < test_size; k++){
			arr[rand7() - 1]++;
		}
		
		int expected = test_size / 7;

		for (int i = 0; i < 7; i++) {
			int k = i + 1;
			int diff = arr[i] - expected;
			double percent = 100.0 * arr[i] / test_size;
			System.out.println(k + " appeared " + percent + "% of the time.");
		}
	}
}
