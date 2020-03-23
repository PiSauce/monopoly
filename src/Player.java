import java.util.ArrayList;

public class Player {
	private int money;
	private int turnNum;
	private int piece;
	private int position;
	private boolean jailed;
	private ArrayList<Integer> properties = new ArrayList<Integer>();
	private ArrayList<Card> cards = new ArrayList<Card>();
	
	public Player(int turnNum, int piece) {
		this.turnNum = turnNum;
		this.piece = piece;
		this.money = 2000; // Default number
		this.position = 0; // Starting position
		this.jailed = false;
	}
	
	public int getMoney() {
		return money;
	}
	
	public void setMoney(int m) {
		this.money = m;
	}
	
	public void changeMoney(int m) {
		this.money += m;
	}
	
	public int[] roll() {
		int[] dice = {(int)Math.round(Math.random()*5) + 1, (int)Math.round(Math.random()*5) + 1};
		return dice;
	}
	
	public int getPosition() {
		return position;
	}

	public void setPosition(int pos) {
		this.position = pos;
	}
	
	public void move(int pos) {
		this.position += pos;
	}
	
	public void addProperty(int prop) {
		properties.add(prop);
	}
	
	public void removeProperty(int prop) {
		properties.remove(prop);
	}
	
	public void addCard(Card card) {
		cards.add(card);
	}
	
	public void setPiece(int p) {
		this.piece = p;
	}
	
	public int getTurnNum() {
		return turnNum;
	}

	public int getPiece(){
		return piece;
	}

	public boolean isJailed() {
		return jailed;
	}

	public void setJailed(boolean jailed) {
		this.jailed = jailed;
	}

	public ArrayList<Integer> getProperties() {
		return properties;
	}

	public void setProperties(ArrayList<Integer> properties) {
		this.properties = properties;
	}
}
