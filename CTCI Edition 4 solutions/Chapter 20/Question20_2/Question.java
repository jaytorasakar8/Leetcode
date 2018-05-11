package Question20_2;

import CareerCupLibrary.AssortedMethods;

public class Question {

	public static void shuffleArray(int[] cards){ 
		int temp; 
		int index; 
		for (int i = 0; i < cards.length; i++){ 
			index = (int) (Math.random() * (cards.length - i)) + i; 
			temp = cards[i]; 
			cards[i] = cards[index];
			cards[index] = temp; 
		} 
	}
	
	public static void main(String[] args) {
		int[] cards = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
		System.out.println(AssortedMethods.arrayToString(cards));
		shuffleArray(cards);
		System.out.println(AssortedMethods.arrayToString(cards));
	}

}
