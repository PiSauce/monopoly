import java.util.ArrayList;

public class Board {
	ArrayList<Property> propertyList = new ArrayList<Property>();
	Deck chanceDeck;
	Deck chestDeck;
	
	public void initProperties() {
		// Add properties to propertyList in order
	}
	
	public void initChanceDeck() {
		chanceDeck = new Deck();
		for(int i = 0; i < 15/*The size of the deck we want*/; i++) {
			chanceDeck.addCard(new ChanceCard(i));
		}
		chanceDeck.shuffle();
	}
	
	public void initChestDeck() {
		chestDeck = new Deck();
		for(int i = 0; i < 15/*The size of the deck we want*/; i++) {
			chestDeck.addCard(new ChanceCard(i));
		}
		chestDeck.shuffle();
	}
	
	public Property getProperty(int pos) {
		return propertyList.get(pos);
	}
	
	public void setOwner(int pos, int turn) {
		propertyList.get(pos).setOwner(turn);
	}
	
	public Card drawChance() {
		return chanceDeck.draw();
	}
	
	public Card drawChest() {
		return chestDeck.draw();
	}
}
