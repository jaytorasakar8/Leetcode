package Question8_4;

import java.util.*;

public class Question {

	public static ArrayList<String> getPerms(String s) {
		ArrayList<String> permutations = new ArrayList<String>();

		if (s == null) { // error case
			return null;
		} else if (s.length() == 0) { // base case
			permutations.add("");
			return permutations;
		}
	            
		char first = s.charAt(0); // get the first character
		String remainder = s.substring(1); // remove the first character
		ArrayList<String> words = getPerms(remainder);
		for (String word : words) {
			for (int j = 0; j <= word.length(); j++) {
				permutations.add(insertCharAt(word, first, j));
			}
		}
		return permutations;
	}
	
	public static String insertCharAt(String word, char c, int i) {
		String start = word.substring(0, i);
		String end = word.substring(i);
		return start + c + end;
	}
	
	public static void main(String[] args) {
		ArrayList<String> list = getPerms("abcde");
		System.out.println("There are " + list.size() + " permutations.");
		for (String s : list) {
			System.out.println(s);
		}
	}

}
