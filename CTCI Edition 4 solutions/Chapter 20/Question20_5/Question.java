package Question20_5;

import java.util.Hashtable;

import CareerCupLibrary.AssortedMethods;

public class Question {

	public static int shortest(String[] words, String word1, String word2) {
		int pos = 0;
		int min = Integer.MAX_VALUE / 2;
		int word1_pos = -min;
		int word2_pos = -min;
		for (int i = 0; i < words.length; i++) {
			String current_word = words[i];
			if (current_word.equals(word1)) {
				word1_pos = pos;
				// Comment following 3 lines if word order matters
				int distance = word1_pos - word2_pos;
				if (min > distance) 
					min = distance;
			} else if (current_word.equals(word2)) {
				word2_pos = pos;
				int distance = word2_pos - word1_pos;
				if (min > distance)
					min = distance;
			}
			++pos;
		}
		return min;
	}
	
	public static String wordAtLocation(String[] words, int loc) {
		if (loc < 0 || loc >= words.length) {
			return null;
		}
		return words[loc];
	}
	
	// Method to confirm other result
	public static boolean search_confirm(String[] words, String word1, String word2, int distance) {
		boolean found_at_distance = false;
		for (int i = 0; i < words.length; i++) {
			if (words[i].equals(word1)) {
				for (int j = 1; j < distance; j++) {
					String loc2a = wordAtLocation(words, i - j);
					String loc2b = wordAtLocation(words, i + j);
					if (word2.equals(loc2a) || word2.equals(loc2b)) {
						return false;
					}
				}
				
				String loc2a = wordAtLocation(words, i - distance);
				String loc2b = wordAtLocation(words, i + distance);
				if (word2.equals(loc2a) || word2.equals(loc2b)) {
					found_at_distance = true;
				}
			}
		}
		return found_at_distance;
	}
	
	public static void main(String[] args) {
		String[] wordlist = AssortedMethods.getLongTextBlobAsStringList();
		System.out.println(AssortedMethods.stringArrayToString(wordlist));
		
		String[][] pairs = {{"Lara", "the"}, {"river", "life"}, {"path", "their"}, {"life", "a"}};
		for (String[] pair : pairs) {
			String word1 = pair[0];
			String word2 = pair[1];
			int distance = shortest(wordlist, word1, word2);
			boolean confirm = search_confirm(wordlist, word1, word2, distance);
			System.out.println("Distance between <" + word1 + "> and <" + word2 + ">: " + distance + " (" + confirm + ")");
		}
	}

}
