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
		// Brown properties
		tileList.add(new Property("Mediterranean"));
		tileList.add(new Community());
		tileList.add(new Property("Baltic Avenue"));	

		tileList.add(new TaxTile("Income Tax", 200));
		tileList.add(new Railroad("Reading")); // Railroads automatically add Railroad to the end
			
		// Light blue properties
		tileList.add(new Property("Oriental Avenue"));		
		tileList.add(new Chance());	
		tileList.add(new Property("Vermont Avenue"));
		tileList.add(new Property("Connecticut"));
			
		// Magenta properties
		tileList.add(new Property("St. Charles Place"));
		tileList.add(new Utility("Electric company"));			
		tileList.add(new Property("Static Avenue"));			
		tileList.add(new Property("Virginia Avenue"));

		tileList.add(new Railroad("Pensylvannia"));
			
		// Orange properties
		tileList.add(new Property("St. James Place"));	
		tileList.add(new Community());
		tileList.add(new Property("Tennessee Avenue"));			
		tileList.add(new Property("New York Avenue"));
			
		// Red properties
		tileList.add(new Property("Kentucky Avenue"));		
		tileList.add(new Chance());	
		tileList.add(new Property("Indiana Avenue"));			
		tileList.add(new Property("Illinois Avenue"));

		tileList.add(new Railroad("B&O"));
			
		// Yellow properties
		tileList.add(new Property("Atlantic"));			
		tileList.add(new Property("Ventnor"));	
		tileList.add(new Property("Marvin Gardins"));
					
		// Green properties
		tileList.add(new Property("Pacific Avenue"));			
		tileList.add(new Property("North Carolina"));			
		tileList.add(new Property("Pennsylvania"));

		tileList.add(new Railroad("Short Line"));
			
		// Dark blue properties
		tileList.add(new Property("Park Place"));	
		tileList.add(new Property("Boardwalk"));
	}

	// creating and initializing the chance deck of cards
	public void initChanceDeck() {
		chanceDeck = new Deck();
		for (int i = 0; i < 16; i++) {
			chanceDeck.addCard(new Card(i));
		}
		chanceDeck.shuffle();
	}

	// creating and initializing the community chest cards
	public void initChestDeck() {
		chestDeck = new Deck();
		for (int i = 0; i < 16; i++) {
			chestDeck.addCard(new Card(i + 16));
		}
		chestDeck.shuffle();
	}

	// gets property a player purchases on the board
	public Tile getTile(int pos) {
		Object t = tileList.get(pos);
		if(t instanceof Property){
			return (Property) t;
		} else if(t instanceof TaxTile){
			return (TaxTile) t;
		} else { // Should not happen
			return (Tile) t;
		}
	}

	// gets property and assigns a owner to the purchased property
	public void setOwner(int pos, int turn) {
		((Property) tileList.get(pos)).setOwner(turn);
	}

	// draws a chance card and returns the card drawn by the player
	public Card drawChance() {
		return chanceDeck.draw();
	}

	// draws a card from the community chest and returns the card drawn
	public Card drawChest() {
		return chestDeck.draw();
	}

	// get action simply reads the card and places the effect into action (ex. lose
	// $100 and the getAction is the getter
	// for doing the action of the card and returns the action
	public int getAction() {
		return action;
	}
}
