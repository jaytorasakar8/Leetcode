package Question9_1;

import CareerCupLibrary.AssortedMethods;

public class Question {


	/** Merges array
	 * @param a first array
	 * @param b second array
	 * @param n number of "real" elements in a
	 * @param m number of "real" elements in b
	 */
	public static void merge(int[] a, int[] b, int n, int m) {
		int k = m + n - 1; // Index of last location of array b
		int i = n - 1; // Index of last element in array b
		int j = m - 1; // Index of last element in array a
	
		// Start comparing from the last element and merge a and b
		while (i >= 0 && j >= 0) {
			if (a[i] > b[j]) {
				a[k--] = a[i--];
			} else {
				a[k--] = b[j--];
			}
		}
		while (j >= 0) {
			a[k--] = b[j--];
		}
	}
	
	public static void main(String[] args) {
		int[] a = {1, 3, 4, 5, 6, 8, 10, 0, 0, 0, 0, 0};
		int[] b = {4, 7, 9, 10, 12};
		merge(a, b, 7, 5);
		System.out.println(AssortedMethods.arrayToString(a));
	}

}
