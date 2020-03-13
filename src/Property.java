public class Property extends Tile{

	// Instance Variables
	private int houses;
	private int hotels;
	private int price; // cost of property
	private int penalty; // rent to pay
	private int owner = -1;

	public Property(){
		super("blank");
		this.price = 1;
		this.penalty = 1;
	}

	public Property(String name){
		super(name);
		this.price = 1;
		this.penalty = 1;
	}

	public Property(String name, int price, int penalty) {
		super(name);
		this.price = price;
		this.penalty = penalty;
	}

	public void setHotels(int hotels) {
		this.hotels = hotels;
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

	public int getHouses() {
		return houses;
	}

	public int getHotels() {
		return hotels;
	}
}
