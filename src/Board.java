import java.util.ArrayList;
// the board class one of the main components of the monopoly board game

// board class, this is the main class which deals with all the sub classes such as deck, cards, etc
//chance and chest are the child classes of the deck class

public class Board {
	ArrayList<Tile> tileList = new ArrayList<Tile>();
	// initializing the two types of cards in the game
	Deck chanceDeck;
	Deck chestDeck;
	int action;
	
	public void initTiles() {
		
		//brown properties
		tileList.add(new Tile("Mediterranean"));
		tileList.add(new Property());
		
		tileList.add(new Tile("Baltic Avenue"));
		tileList.add(new Property());
		
		
		
		//light blue properties
		tileList.add(new Tile("Oriental Avenue"));
		tileList.add(new Property());
		
		tileList.add(new Tile("Vermont Avenue"));
		tileList.add(new Property());
		
		tileList.add(new Tile("Connecticut"));
		tileList.add(new Property());
		
		
		//magenta properties
		tileList.add(new Tile("St. Charles Place"));
		tileList.add(new Property());
		
		tileList.add(new Tile("Static Avenue"));
		tileList.add(new Property());
		
		tileList.add(new Tile("Virginia Avenue"));
		tileList.add(new Property());
		
		
		
		//orange properties
		tileList.add(new Tile("St. James Place"));
		tileList.add(new Property());
		
		tileList.add(new Tile("Tennessee Avenue"));
		tileList.add(new Property());
		
		tileList.add(new Tile("New York Avenue"));
		tileList.add(new Property());
		
		
		//red properties
		tileList.add(new Tile("Kentucky Avenue"));
		tileList.add(new Property());
		
		tileList.add(new Tile("Indiana Avenue"));
		tileList.add(new Property());
		
		tileList.add(new Tile("Illinois Avenue"));
		tileList.add(new Property());
		
		
		//yellow properties
		tileList.add(new Tile("Atlantic"));
		tileList.add(new Property());
		
		tileList.add(new Tile("Ventnor"));
		tileList.add(new Property());
		
		tileList.add(new Tile("Marvin Gardins"));
		tileList.add(new Property());
		
		
		
		//green properties
		tileList.add(new Tile("Pacific Avenue"));
		tileList.add(new Property());
		
		tileList.add(new Tile("North Carolina"));
		tileList.add(new Property());
		
		tileList.add(new Tile("Pennsylvania"));
		tileList.add(new Property());
		
		
		//dark blue properties
		tileList.add(new Tile("Park Place"));
		tileList.add(new Property());
		
		tileList.add(new Tile("Boardwalk"));
		tileList.add(new Property());
	}
	
	
	// creating and initializing the chance deck of cards
	public void initChanceDeck() {
		chanceDeck = new Deck();
		for(int i = 0; i < 16; i++) {
			chanceDeck.addCard(new Card(i));
		}
		chanceDeck.shuffle();
	}
	
	// creating and initializing the community chest cards
	public void initChestDeck() {
		chestDeck = new Deck();
		for(int i = 0; i < 16; i++) {
			chestDeck.addCard(new Card(i + 16));
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
	// draws a chance card and returns the card drawn by the player
	public Card drawChance() {
		return chanceDeck.draw();
	}
	
	// draws a card from the community chest and returns the card drawn
	public Card drawChest() {
		return chestDeck.draw();
	}
	
	// get action simply reads the card and places the effect into action (ex. lose $100 and the getAction is the getter 
	// for doing the action of the card and returns the action
	public int getAction() {
		return action;
	}
}
