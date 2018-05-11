package Question20_4;

public class Question {	
	public static int count2sI(int num) {
		int countof2s = 0, digit = 0;
		int j = num, seendigits=0, position=0, pow10_pos = 1;
		/* maintaining this value instead of calling pow() is an 6x perf 
		 * gain (48s -> 8s) pow10_posMinus1. maintaining this value
		 * instead of calling Numof2s is an 2x perf gain (8s -> 4s). 
		 * overall > 10x speedup */
		while (j > 0) {
			digit = j % 10;
			int pow10_posMinus1 = pow10_pos / 10;
			countof2s += digit * position * pow10_posMinus1;
			/* we do this if digit <, >, or = 2
			 * Digit < 2 implies there are no 2s contributed by this 	
			 * digit. 
	  		 * Digit == 2 implies there are 2 * numof2s contributed by
			 * the previous position + num of 2s contributed by the 
			 * presence of this 2 */
			if (digit == 2) {
				countof2s += seendigits + 1;
			}
			/* Digit > 2 implies there are digit * num of 2s by the prev. 
			 * position + 10^position */
			else if(digit > 2) {
				countof2s += pow10_pos;
			}
			seendigits = seendigits + pow10_pos * digit;
			pow10_pos *= 10;
			position++;
			j = j / 10;
		}
		return(countof2s);
	}
	
	public static int count2sR(int n) {	
		// Example: n = 513
		
		// Base case
		if (n == 0) {
			return 0;
		}
		
		// Split apart 513 into 5 * 100 + 13.
		// [Power = 100; First = 5; Remainder = 13]
		int power = 1;
		while (10 * power < n) {
			power *= 10;
		}
		int first = n / power;
		int remainder = n % power;
		
		// Counts 2s from first digit
		int nTwosFirst = 0;
		if (first > 2) {
			nTwosFirst += power; 
		} else if (first == 2) {
			nTwosFirst += remainder + 1;
		}
		
		// Count 2s from all other digits
		int nTwosOther = first * count2sR(power - 1) + count2sR(remainder);
		
		return nTwosFirst + nTwosOther;
	}
	
	public static void main(String[] args) {
		for (int i = 0; i < 1000; i++) {
			int v1 = count2sR(i);
			int v2 = count2sI(i);
			System.out.println("Between 0 and " + i + ": " + v1 + " " + v2);
		}
	}

}