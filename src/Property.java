public class Property extends Tile{

	// Instance Variables
	private int position; // location on board
	private int houses;
	private int hotels;
	private int action;
	private int price; // cost of property
	private int penalty; // rent to pay
	private int owner;

	public Property(String name, int action, int price) {
		super(name);
		this.setAction(0);
		this.price = 100;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public int getAction() {
		return action;
	}

	public void setAction(int action) {
		this.action = action;
	}

	public int getHotels() {
		return hotels;
	}

	public void setHotels(int hotels) {
		this.hotels = hotels;
	}

	public int getHouses() {
		return houses;
	}

	public void setHouses(int houses) {
		this.houses = houses;
	}

	// Price
	public int getPrice() {
		return price;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
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
	
	public void setOwner(int owner){
		this.owner = owner;
	}	
	public void doAction() {}
}
