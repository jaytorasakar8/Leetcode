package Question19_1;

public class Question {

	public static void swap(int a, int b) {
		a = b - a; // 9 - 5 = 4
		b = b - a; // 9 - 4 = 5
		a = a + b; // 4 + 5 = 9
		
		System.out.println("a: " + a);
		System.out.println("b: " + b);
	}
	
	public static void swap_opt(int a, int b) {
		a = a^b; 
		b = a^b; 
		a = a^b; 
		
		System.out.println("a: " + a);
		System.out.println("b: " + b);
	}
	
	public static void main(String[] args) {
		int a = 1672;
		int b = 9332;
		
		System.out.println("a: " + a);
		System.out.println("b: " + b);
		
		swap(a, b);
		swap_opt(a, b);
	}

}
