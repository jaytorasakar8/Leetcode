package Question19_7;

public class Question {
	
	public static int getMaxSum(int[] a) {
		int maxsum = 0;
		int sum = 0;
		for (int i = 0; i < a.length; i++) {
			sum += a[i];
			if (maxsum < sum) {
				maxsum = sum;
			} else if (sum < 0) {
				sum = 0;
			}
		}
		return maxsum;
	}
	
	public static void main(String[] args) {
		int[] a = {2, -8, 3, -2, 4, -10};
		System.out.println(getMaxSum(a));
	}
}
