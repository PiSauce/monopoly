import java.util.ArrayList;
// the board class one of the main components of the monopoly board game

public class Board {
	ArrayList<Property> propertyList = new ArrayList<Property>();
	// initializing the two types of cards in the game
	Deck chanceDeck;
	Deck chestDeck;
	int action;
	
	public void initProperties() {
		// Add properties to propertyList in order 
	}
	
	// creates the chance deck
	public void initChanceDeck() {
		chanceDeck = new Deck();
		for(int i = 0; i < 15/*The size of the deck we want*/; i++) {
			chanceDeck.addCard(new ChanceCard(i));
		}
		chanceDeck.shuffle();
	}
	
	// creates the community chest deck
	public void initChestDeck() {
		chestDeck = new Deck();
		for(int i = 0; i < 15/*The size of the deck we want*/; i++) {
			chestDeck.addCard(new ChanceCard(i));
		}
		chestDeck.shuffle();
	}
	
	// getter method for grabbing a list of the peoperties and returns the list
	public Property getProperty(int pos) {
		return propertyList.get(pos);
	}
	
	// allocates purchased property to its owner
	public void setOwner(int pos, int turn) {
		propertyList.get(pos).setOwner(turn);
	}
	
	// draws a chance card and returns the card drawn by the player
	public Card drawChance() {
		return chanceDeck.draw();
	}
	
	// draws a card from the community chest and returns the card drawn
	public Card drawChest() {
		return chestDeck.draw();
	}
	
	// getter for the action done by tbe player and returns the action
	public int getAction() {
		return action;
	}
}
