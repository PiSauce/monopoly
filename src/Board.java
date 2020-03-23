import java.util.ArrayList;
// the board class one of the main components of the monopoly board game

// board class, this is the main class which deals with all the sub classes such as deck, cards, etc
//chance and chest are the child classes of the deck class

public class Board {
	ArrayList<Tile> tileList = new ArrayList<Tile>();

	// Creating tile groupings
	ArrayList<Integer> railroads = new ArrayList<Integer>();
	ArrayList<Integer> brown = new ArrayList<Integer>();
	ArrayList<Integer> lightBlue = new ArrayList<Integer>();
	ArrayList<Integer> magenta = new ArrayList<Integer>();
	ArrayList<Integer> orange = new ArrayList<Integer>();
	ArrayList<Integer> red = new ArrayList<Integer>();
	ArrayList<Integer> yellow = new ArrayList<Integer>();
	ArrayList<Integer> green = new ArrayList<Integer>();
	ArrayList<Integer> darkBlue = new ArrayList<Integer>();

	// initializing the two types of cards in the game
	Deck chanceDeck;
	Deck chestDeck;
	int action;

	// TODO: Add prices and rent to each property
	public void initTiles() {
		tileList.add(new Go());

		// Brown properties
		Property mediterranean = new Property("Mediterranean");
		Property balticAve = new Property("Baltic Avenue");

		// Light blue properties
		Property orientalAve = new Property("Oriental Avenue");
		Property vermontAve = new Property("Vermont Avenue");
		Property connecticutAve = new Property("Connecticut Avenue")

		// Magenta properties
		Property stCharles = new Property("St. Charles Place");
		Property statesAve = new Property("States Avenue");
		Property virginiaAve = new Property("Virginia Avenue");

		// Orange properties
		Property stJames = new Property("St. James Place");
		Property tennesseeAve = new Property("Tennessee Avenue");
		Property newYorkAve = new Property("New York Avenue");

		// Red properties
		Property kentuckyAve = new Property("Kentucky Avenue");
		Property indianaAve = new Property("Indiana Avenue");
		Property illinoisAve = new Property("Illinois Avenue");

		// Yellow Properties
		Property atlanticAve = new Property("Atlantic Avenue");
		Property ventnorAve = new Property("Ventnor Avenue");
		Property marvinGard = new Property("Marvin Gardins");


		tileList.add(new Property("Mediterranean"));
		tileList.add(new Community());
		tileList.add(new Property("Baltic Avenue"));	
		tileList.add(new TaxTile("Income Tax", 200));
		tileList.add(new Railroad("Reading")); // Railroads automatically add Railroad to the end
		tileList.add(new Property("Oriental Avenue"));		
		tileList.add(new Chance());	
		tileList.add(new Property("Vermont Avenue"));
		tileList.add(new Property("Connecticut"));

		tileList.add(new Jail());
			
		tileList.add(new Property("St. Charles Place"));
		tileList.add(new Utility("Electric company"));			
		tileList.add(new Property("Static Avenue"));			
		tileList.add(new Property("Virginia Avenue"));
		tileList.add(new Railroad("Pensylvannia"));
		tileList.add(new Property("St. James Place"));	
		tileList.add(new Community());
		tileList.add(new Property("Tennessee Avenue"));			
		tileList.add(new Property("New York Avenue"));

		tileList.add(new FreeParking());
			
		tileList.add(new Property("Kentucky Avenue"));		
		tileList.add(new Chance());	
		tileList.add(new Property("Indiana Avenue"));			
		tileList.add(new Property("Illinois Avenue"));
		tileList.add(new Railroad("B&O"));
			
		// Yellow properties
		tileList.add(new Property("Atlantic Avenue"));			
		tileList.add(new Property("Ventnor Avenue"));
		tileList.add(new Utility("Water Works"));
		tileList.add(new Property("Marvin Gardins"));

		tileList.add(new GoToJail());
					
		// Green properties
		tileList.add(new Property("Pacific Avenue"));			
		tileList.add(new Property("North Carolina"));
		tileList.add(new Community());			
		tileList.add(new Property("Pennsylvania"));

		tileList.add(new Railroad("Short Line"));
		tileList.add(new Chance());
			
		// Dark blue properties
		tileList.add(new Property("Park Place"));
		tileList.add(new TaxTile("Luxury Tax", 100));
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

	public ArrayList<Integer> getRailroads() {
		return railroads;
	}

	public void setRailroads(ArrayList<Integer> railroads) {
		this.railroads = railroads;
	}

	public ArrayList<Integer> getBrown() {
		return brown;
	}

	public void setBrown(ArrayList<Integer> brown) {
		this.brown = brown;
	}

	public ArrayList<Integer> getLightBlue() {
		return lightBlue;
	}

	public void setLightBlue(ArrayList<Integer> lightBlue) {
		this.lightBlue = lightBlue;
	}

	public ArrayList<Integer> getMagenta() {
		return magenta;
	}

	public void setMagenta(ArrayList<Integer> magenta) {
		this.magenta = magenta;
	}

	public ArrayList<Integer> getOrange() {
		return orange;
	}

	public void setOrange(ArrayList<Integer> orange) {
		this.orange = orange;
	}

	public ArrayList<Integer> getRed() {
		return red;
	}

	public void setRed(ArrayList<Integer> red) {
		this.red = red;
	}

	public ArrayList<Integer> getYellow() {
		return yellow;
	}

	public void setYellow(ArrayList<Integer> yellow) {
		this.yellow = yellow;
	}

	public ArrayList<Integer> getGreen() {
		return green;
	}

	public void setGreen(ArrayList<Integer> green) {
		this.green = green;
	}

	public ArrayList<Integer> getDarkBlue() {
		return darkBlue;
	}

	public void setDarkBlue(ArrayList<Integer> darkBlue) {
		this.darkBlue = darkBlue;
	}
}
