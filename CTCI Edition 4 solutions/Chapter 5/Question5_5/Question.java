package Question5_5;

import CareerCupLibrary.AssortedMethods;

public class Question {
	public static int bitSwapRequired(int a, int b) {
		int count = 0;
		for (int c = a ^ b; c != 0; c = c >> 1) { 
			count += c & 1;
		}
		return count;
	}
	
	public static void main(String[] args) {
		int a = 217;
		int b = 532;
		System.out.println(a + ": " + AssortedMethods.toFullBinaryString(a));
		System.out.println(b + ": " + AssortedMethods.toFullBinaryString(b));
		int nbits = bitSwapRequired(a, b);
		System.out.println("Required number of bits: " + nbits);
	}
}
