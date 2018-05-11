package Question7_1;

public class BlackJackCard extends Card {
	public BlackJackCard(int r, Suit s) {
		super(r, s);
	}
	
	public int value() {
		int r = super.value();
		if (r == 1) return 11; // aces are 11
		if (r < 10) return r;
		return 10;
	}
	
	boolean isAce() { 
		return super.value() == 1; 
	} 
}
