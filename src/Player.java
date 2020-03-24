import java.util.ArrayList;
//player class
public class Player {
	//instance variable
	private int money;
	private int turnNum;
	private int piece;
	private int position;
	private boolean jailed;
	private ArrayList<Integer> properties = new ArrayList<Integer>();
	private ArrayList<Card> cards = new ArrayList<Card>();
	
	//constructor
	public Player(int turnNum, int piece) {
		this.turnNum = turnNum;
		this.piece = piece;
		this.money = 2000; // Default number
		this.position = 0; // Starting position
		this.jailed = false;
	}
	//getter for players money
	public int getMoney() {
		return money;
	}
	//sets money for the player
	public void setMoney(int m) {
		this.money = m;
	}
	//changes money of a player (increases or decreases)
	public void changeMoney(int m) {
		this.money += m;
	}
	//rolls dice and returns dice after roll
	public int[] roll() {
		int[] dice = {(int)Math.round(Math.random()*5) + 1, (int)Math.round(Math.random()*5) + 1};
		return dice;
	}
	//returns position of player on board
	public int getPosition() {
		return position;
	}
	//sets position of player on board
	public void setPosition(int pos) {
		this.position = pos;
	}
	
	//moves a player based on position and adds roll to current position
	public void move(int pos) {
		this.position += pos;
	}
	
	//adds property to a players property
	public void addProperty(int prop) {
		properties.add(prop);
	}
	//removes property
	public void removeProperty(int prop) {
		properties.remove(prop);
	}
	//adds card 
	public void addCard(Card card) {
		cards.add(card);
	}
	
	//sets player piece
	public void setPiece(int p) {
		this.piece = p;
	}
	
	//gets the turn number of player
	public int getTurnNum() {
		return turnNum;
	}
	
	//gets the piece of the player
	public int getPiece(){
		return piece;
	}
	
	//checks if a player is jailed or not (true or false)
	public boolean isJailed() {
		return jailed;
	}

	//if isJailed() is true then player is jailed
	public void setJailed(boolean jailed) {
		this.jailed = jailed;
	}

	//returns an arraylist of properties
	public ArrayList<Integer> getProperties() {
		return properties;
	}
	
	//sets arraylist of properties
	public void setProperties(ArrayList<Integer> properties) {
		this.properties = properties;
	}
}
