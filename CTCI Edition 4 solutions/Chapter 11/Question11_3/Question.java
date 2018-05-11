package Question11_3;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Question {

	static byte[] bitfield2 = new byte [0xFFFFFFF/8];
	
	public static void findOpenNumber2() throws FileNotFoundException {
		Scanner in = new Scanner(new FileReader("input_file_q11_4.txt"));
		while (in.hasNextInt()) {
			int n = in.nextInt ();
			/* Finds the corresponding number in the bitfield by using the 
			 * OR operator to set the nth bit of a byte (e.g.. 10 would
			 * correspond to the 2nd bit of index 2 in the byte array). */
			bitfield2 [n / 8] |= 1 << (n % 8);
		}

		for (int i = 0 ; i < bitfield2.length; i++) {
			for (int j = 0; j < 8; j++) {
				/* Retrieves the individual bits of each byte. When 0 bit
				 * is found, finds the corresponding value. */
				if ((bitfield2[i] & (1 << j)) == 0) {
					System.out.println (i * 8 + j);
					return;
				}
			}
		}		
	}
	
	static int bitsize = 1048576; // 2^20 bits (2^17 bytes)
	static int blockNum = 4096; // 2^12
	static byte[] bitfield = new byte[bitsize/8];
	static int[] blocks = new int[blockNum];
	
	public static void findOpenNumber() throws FileNotFoundException {
		int starting = -1;
		Scanner in = new Scanner (new FileReader ("input_file_q11_4.txt"));
		while (in.hasNextInt()) {
		    int n = in.nextInt();
		    blocks[n / (bitfield.length * 8)]++;
		}
		
		for (int i = 0; i < blocks.length; i++) {
			if (blocks[i] < bitfield.length * 8){
				/* if value < 2^20, then at least 1 number is missing in
				 * that section. */
				starting = i * bitfield.length * 8;
				break;
			}
		}

		in = new Scanner(new FileReader("input_file_q11_4.txt"));
		while (in.hasNextInt()) {
		    int n = in.nextInt();
		    /* If the number is inside the block that’s missing numbers,
			 * we record it */
		    if( n >= starting && n < starting + bitfield.length * 8){
		    	bitfield [(n-starting) / 8] |= 1 << ((n - starting) % 8);
		    }
		}

		for (int i = 0 ; i < bitfield.length; i++) {
		    for (int j = 0; j < 8; j++) {
		    	/* Retrieves the individual bits of each byte. When 0 bit 
				 * is found, finds the corresponding value. */
				if ((bitfield[i] & (1 << j)) == 0) {
					System.out.println(i * 8 + j + starting);
					return;
				}
		    }
		}		
	}

	public static void main(String[] args)  throws IOException {
		findOpenNumber2();
		findOpenNumber();
	}

}
