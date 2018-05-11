package Question10_4;

public class Question {
	/* Flip a positive sign to negative, or a negative sign to pos */
	public static int FnNegate(int a) {
		int neg = 0;
		int d = a < 0 ? 1 : -1;
		while (a != 0) {
			neg += d;
			a += d;
		}
	    return neg;
	}

	/* Subtract two numbers by negating b and adding them */
	public static int FnMinus(int a, int b) {
		return a + FnNegate(b);
	}

	/* Check if a and b are different signs */
	public static boolean DifferentSigns(int a, int b) {
		return ((a < 0 && b > 0) || (a > 0 && b < 0)) ? true : false; 
	}

	/* Return absolute value */
	public static int abs(int a) {
		if (a < 0) return FnNegate(a);
		else return a;
	}

	/* Multiply a by b by adding a to itself b times */
	public static int FnTimes(int a, int b) {
		if (a < b) return FnTimes(b, a); // algo is faster if b < a
		int sum = 0;
		for (int iter = abs(b); iter > 0; --iter) sum += a;
		if (b < 0) sum = FnNegate(sum);
		return sum;
	}

	// returns 1, if a/b >= 0.5, and 0 otherwise
	public static int DefineAndRoundFraction(int a, int b) {
		if(FnTimes(abs(a), 2) >= abs(b)) return 1;
		else return 0;
	}

	/* Divide a by b by literally counting how many times does b go into
	 * a. That is, count how many times you can subtract b from a until
	 * you hit 0. */
	public static int FnDivide(int a, int b) throws java.lang.ArithmeticException {
		if (b == 0) {
			throw new java.lang.ArithmeticException("ERROR: Divide by zero.");
		}
		int quotient = 0;
		int divisor = FnNegate(abs(b));
		int divend; /* dividend */
		for (divend = abs(a); divend >= abs(divisor); divend += divisor) {
			++quotient;
		}
		if (DifferentSigns(a, b)) quotient = FnNegate(quotient);
		return quotient;
	}
	
	public static int randomInt(int n) {
		return (int) (Math.random() * n);
	}
	
	public static void main(String[] args) {
		for (int i = 0; i < 100; i++) {
			int a = randomInt(10);
			int b = randomInt(10);
			int ans = FnMinus(a, b);
			if (ans != a - b) {
				System.out.println("ERROR");
			}
			System.out.println(a + " - " + b + " = " + ans);
		}
		for (int i = 0; i < 100; i++) {
			int a = randomInt(10);
			int b = randomInt(10);
			int ans = FnTimes(a, b);
			if (ans != a * b) {
				System.out.println("ERROR");
			}
			System.out.println(a + " * " + b + " = " + ans);
		}
		for (int i = 0; i < 100; i++) {
			int a = randomInt(10) + 1;
			int b = randomInt(10) + 1;
			System.out.print(a + " / " + b + " = ");
			int ans = FnDivide(a, b);
			if (ans != a / b) {
				System.out.println("ERROR");
			}
			System.out.println(ans);
		}
	}

}
