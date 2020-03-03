public class Card {
	
	private String description;
	private int label;
	private int ID;
	
	// Constructors
	public Card() {
		this.ID = (int)(Math.random()*31) + 1; // Sets to a random ID if none specified
		setup();
	}
	
	public Card(int ID) {
		this.ID = ID;
		setup();
	}
	
	// Sets a description for the card.
	// 0 - 15 	-> Chance card IDs
	// 16 - 31 	-> Community chest card IDs
	private void setup() {
		switch(ID) {
			case 0:
				setDescription("Advance to Go, Collect $200");
				break;
			case 1:
				setDescription("Advance to Illinois Avenue");
				break;
			case 2:
				setDescription("Advance to St. Charles Place");
				break;
			case 3:
				setDescription("Advance token to nearest utility. If unowned, you may buy it from the bank; If owned, throw the dice and pay owner a total of 10 times the amount thrown.");
				break;
			case 4:
				setDescription("Advance token to the nearest Railroad and pay owner twice the rental to which he/she is otherwise entitled. If Railroad is unowned, you may buy it from the Bank.");
				break;
			case 5:
				setDescription("Bank pays you dividend of $50");
				break;
			case 6:
				setDescription("Get out of Jail Free");
				break;
			case 7:
				setDescription("Go Back Three Spaces");
				break;
			case 8:
				setDescription("Go to Jail. Go directly to Jail. Do not pass GO, do not collect $200.");
				break;
			case 9:
				setDescription("Make general repairs on all your property: For each house pay $25, For each hotel $100.");
				break;
			case 10:
				setDescription("Pay poor tax of $15");
				break;
			case 11:
				setDescription("Take a trip to Reading Railroad. If you pass Go, collect $200.");
				break;
			case 12:
				setDescription("Take a walk on the Boardwalk. Advance token to Boardwalk.");
				break;
			case 13:
				setDescription("You have been elected Chairman of the Board. Pay each player $50.");
				break;
			case 14:
				setDescription("Your building loan matures. Receive $150.");
				break;
			case 15:
				setDescription("You have won a crossword competition. Collect $100.");
				break;
			case 16:
				setDescription("Advance to Go, Collect $200");
				break;
			case 17:
				setDescription("Bank error in your favor. Collect $200.");
				break;
			case 18:
				setDescription("Doctor's fees. Pay $50.");
				break;
			case 19:
				setDescription("From sale of stock you get $50.");
				break;
			case 20:
				setDescription("Get out of Jail Free");
				break;
			case 21:
				setDescription("Go to Jail. Go directly to Jail. Do not pass GO, do not collect $200.");
				break;
			case 22:
				setDescription("Grand Opera Night. Collect $50 from every player for opening night seats.");
				break;
			case 23:
				setDescription("Holiday Fund matures. Receive $100.");
				break;
			case 24:
				setDescription("Income tax refund. Collect $20.");
				break;
			case 25:
				setDescription("Life insurance matures �ｿｽC Collect $100");
				break;
			case 26:
				setDescription("Hospital Fees. Pay $50.");
				break;
			case 27:
				setDescription("School fees. Pay $50.");
				break;
			case 28:
				setDescription("Receive $25 consultancy fee.");
				break;
			case 29:
				setDescription("You are assessed for street repairs: Pay $40 per house and $115 per hotel you own.");
				break;
			case 30:
				setDescription("You have won second prize in a beauty contest. Collect $10.");
				break;
			case 31:
				setDescription("You inherit $100.");
				break;
			default:
				break;
		}
	}
	
	// Getters and Setters
	public void setDescription(String s) {
		description = s;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setLabel(int i) {
		label = i;
	}
	
	public int getLabel() {
		return label;
	}
	
	public int getID() {
		return ID;
	}
	
}
