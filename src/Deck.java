import java.util.ArrayList;

//deck class
public class Deck {
	private ArrayList<Card> cards = new ArrayList<Card>(); //creating new array of cards
	
	public void shuffle() { //shuffle method
		for(int i = 0; i < 50; i++) {
			int r1 = (int)Math.random()*cards.size(); //randomizes cards
			int r2 = (int)Math.random()*cards.size();
			Card temp = cards.get(r1);
			cards.remove(r1);
			cards.add(r1, cards.get(r2));
			cards.remove(r2);
			cards.add(r2, temp);
		}
	}
	
	public void addCard(Card c) { //adds cards to the deck
		cards.add(c);
	}
	
	public Card draw() { //returns card drawn
		Card card = cards.get(0);
		cards.remove(0);
		cards.add(cards.size(), card);
		return card;
	}
}
