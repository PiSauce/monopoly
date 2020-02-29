import java.util.ArrayList;

// board class, this is the main class which deals with all the sub classes such as deck, cards, etc
//chance and chest are the child classes of the deck class

public class Board {
	ArrayList<Property> propertyList = new ArrayList<Property>();
	Deck chanceDeck;
	Deck chestDeck;
	int action;
	
	public void initProperties() {
		// Add properties to propertyList in order 
	}
	
	// creating and initializing the chance deck of cards
	public void initChanceDeck() {
		chanceDeck = new Deck();
		for(int i = 0; i < 15/*The size of the deck we want*/; i++) {
			chanceDeck.addCard(new ChanceCard(i));
		}
		chanceDeck.shuffle();
	}
	
	// creating and initializing the community chest cards
	public void initChestDeck() {
		chestDeck = new Deck();
		for(int i = 0; i < 15/*The size of the deck we want*/; i++) {
			chestDeck.addCard(new ChanceCard(i));
		}
		chestDeck.shuffle();
	}
	
	// gets property a player purchases on the board
	public Property getProperty(int pos) {
		return propertyList.get(pos);
	}
	
	// gets property and assigns a owner to the purchased property
	public void setOwner(int pos, int turn) {
		propertyList.get(pos).setOwner(turn);
	}
	// draws a card from the chance deck
	public Card drawChance() {
		return chanceDeck.draw();
	}
	
	//draw chest is invoked when a player lands on a chest on the board and is made to draw a card
	public Card drawChest() {
		return chestDeck.draw();
	}
	
	// get action simply reads the card and places the effect into action (ex. lose $100 and the getAction is the getter 
	// for doing the action of the card and returns the action
	public int getAction() {
		return action;
	}
}
