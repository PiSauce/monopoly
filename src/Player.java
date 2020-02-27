import java.util.ArrayList;

public class Player {
	private int money;
	private int turnNum;
	private int piece;
	private int position;
	private ArrayList<Integer> properties = new ArrayList<Integer>();
	private ArrayList<Integer> cards = new ArrayList<Integer>();
	
	public int getMoney() {
		return money;
	}
	
	public void setMoney(int m) {
		this.money = m;
	}
	
	public int roll() {
		return (int)Math.round(Math.random()*6);
	}
	
	public int getPosition() {
		return position;
	}
	
	public void setPosition(int pos) {
		this.position = pos;
	}
	
	public void addProperty(int prop) {
		properties.add(prop);
	}
	
	public void removeProperty(int prop) {
		properties.remove(prop);
	}
	
	public void setPiece(int p) {
		this.piece = p;
	}
	
	public void setTurnNum(int n) {
		this.turnNum = n;
	}
}
