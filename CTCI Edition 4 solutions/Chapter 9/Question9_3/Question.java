package Question9_3;

public class Question {

	public static int search(int a[], int l, int u, int x) { 
		while (l <= u) { 
			int m = (l + u) / 2; 
			if (x == a[m]) {
				return m; 
			} else if (a[l] <= a[m]) {
				if (x > a[m]) {
					l = m+1; 
				} else if (x >=a [l]) {
					u = m-1; 
				} else {
					l = m+1;
				}
			} 
			else if (x < a[m]) u = m-1; 
			else if (x <= a[u]) l = m+1; 
			else u = m - 1; 
		} 
		return -1; 
	}

	public static int search(int a[], int x) {
		return search(a, 0, a.length - 1, x);
	}
	
	public static void main(String[] args) {
		int[] a = {4, 5, 6, 7, 8, 9, 1, 2, 3};
		for (int x : a) {
			System.out.println(x + " is at position " + search(a, x));
		}
	}

}
