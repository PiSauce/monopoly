import java.util.ArrayList;

public class Deck {
	private ArrayList<Card> cards = new ArrayList<Card>();
	
	private void shuffle() {
		for(int i = 0; i < 50; i++) {
			int r1 = (int)Math.random()*cards.size();
			int r2 = (int)Math.random()*cards.size();
			Card temp = cards.get(r1);
			cards.remove(r1);
			cards.add(r1, cards.get(r2));
			cards.remove(r2);
			cards.add(r2, temp);
		}
	}
	
	private void addCard(Card c) {
		cards.add(c);
	}
	
	private Card draw() {
		Card card = cards.get(0);
		cards.remove(0);
		cards.add(cards.size(), card);
		return card;
	}
}
