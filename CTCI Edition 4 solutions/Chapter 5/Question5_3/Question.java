package Question5_3;

import CareerCupLibrary.AssortedMethods;

public class Question {

	public static int countOnes(int i) {
		int count = 0;
		while(i > 0) {
			if((i & 1) == 1) {
				count++;
			}
			i=i>>1;
		}
		return count;
	}

	public static int GetNext_BF(int i) {
		int num_ones = countOnes(i);
		i++;
		while (countOnes(i) != num_ones) {
			i++;
		}
		return i;
	}

	public static int GetPrevious_BF(int i) {
		int num_ones = countOnes(i);
		i--;
		while (countOnes(i) != num_ones) {
			i--;
		}
		return i;
	}
	
	public static boolean GetBit(int n, int index) {
		return ((n & (1 << index)) > 0);
	}
		
	public static int SetBit(int n, int index, boolean b) {
		if (b) {
			return n | (1 << index);
		} else {
			int mask = ~(1 << index);
			return n & mask;
		}
	}
		
	public static int GetNext_NP(int n) {
		if (n <= 0) return -1;
		
		int index = 0;
		int countOnes = 0;
		
		// Find first one.
		while (!GetBit(n, index)) index++;
			
		// Turn on next zero.
		while (GetBit(n, index)) {
			index++;
			countOnes++;
		}
		n = SetBit(n, index, true);
		
		// Turn off previous one
		index--;
		n = SetBit(n, index, false);
		countOnes--;
				
		// Set zeros
		for (int i = index - 1; i >= countOnes; i--) {
			n = SetBit(n, i, false);
		}
		
		// Set ones
		for (int i = countOnes - 1; i >= 0; i--) {
			n = SetBit(n, i, true);
		}
			
		return n;
	}
		
	public static int GetPrevious_NP(int n) {
		if (n <= 0) return -1; // Error
			
		int index = 0;
		int countZeros = 0;
			
		// Find first zero.
		while (GetBit(n, index)) index++;
			
		// Turn off next 1.
		while (!GetBit(n, index)) {
			index++;
			countZeros++;
		}
		n = SetBit(n, index, false);
		
		// Turn on previous zero
		index--;
		n = SetBit(n, index, true);
		countZeros--;
				
		// Set ones
		for (int i = index - 1; i >= countZeros; i--) {
			n = SetBit(n, i, true);
		}
		
		// Set zeros
		for (int i = countZeros - 1; i >= 0; i--) {
			n = SetBit(n, i, false);
		}
		
		return n;
	}
	
	public static void main(String[] args) {
		int a = 27;
		System.out.println(a + ": " + AssortedMethods.toFullBinaryString(a));
		int b = GetNext_NP(a);
		System.out.println(b + ": " + AssortedMethods.toFullBinaryString(b));		
		int c = GetPrevious_NP(a);
		System.out.println(c + ": " + AssortedMethods.toFullBinaryString(c));	
	}

}
