
public class Property {
	
	//Instance Variables
	private String name; // properties names
	private int position; // location on board
	private int houses;	
	private int hotels;
	private int action;
	private int price; // cost of property
	private int penalty; // rent to pay
	private int owner;
	
	

	//Price
	public int getPrice() {
		return price;
	}
	
	public void setPrice() {
		this.price = 100;
	}
	/**
	set default price of any property to 100
	**/
	
	
	//Penalty
	public int getPenalty() {
		return penalty;
	}
	
	public void setPenalty(int penalty) {
		this.penalty = penalty;
	}
	/**
	rent a player will be paying if the property slot is already owned
	**/
	
	
	//Owner of the property
	public int getOwner() {
		return owner;
	}
	
	public int setOwner(int player) {
		this.owner = player;
	}
	
	public void getAction() {}
}
