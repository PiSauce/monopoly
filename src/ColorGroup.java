import javafx.scene.paint.Color;

//extension of landmark, mainly deals with getting building costs and-
//total number of available houses/hotels
public class ColorGroup extends Landmark {
	
	//instance variables
	private int price;
	private boolean toBeImproved = true;
	private int buildingCost;
	private static int availableHouseNumber = 32;
	private static int availableHotelNumber = 12;
	private int buildingNumber = 0;
	private int[] rents;
	private boolean toBeUnimproved = false;
	private boolean mortgaged = false;
	private int ownerID = -1;
	private static int[] groupOwnerIDs = {-1, -1, -1, -1, -1, -1, -1, -1};
	private final int[][] groupLocations = {{1, 3}, {6, 8, 9}, {11, 13, 14}, {16, 18, 19}, {21, 23, 24}, {26, 27, 29}, {31, 32, 34}, {37, 39}};
	
	public ColorGroup(String aDescription, Color aColor, int aPrice, int someBuildingCost, int[] someRents) {
		super(aDescription, aColor);
		setPrice(aPrice);
		setBuildingCost(someBuildingCost);
		setRents(someRents);
	}
	
	//setter and getter for price
	public void setPrice(int aPrice) {
		price = aPrice;
	}
	
	public int getPrice() {
		return price;
	}
	
	//setter and getter for improvement
	public void setToBeImproved(boolean whetherToBeImproved) {
		toBeImproved = whetherToBeImproved;
	}
	
	public boolean getToBeImproved() {
		return toBeImproved;
	}
	
	//setter and getter for building costs
	public void setBuildingCost(int someBuildingCost) {
		buildingCost = someBuildingCost;
	}
	
	public int getBuildingCost() {
		return buildingCost;
	}
	
	//adds to total number of available houses
	//an exmaple of when this method is applicable is when a player sells a house, then the total number of available houses increases
	public void addAvailableHouseNumber() { 
		availableHouseNumber++;
	}
	
	//reduced total number of houses available
	//an example would be if a player purchases a house then the total number of houses decreases
	public void reduceAvailableHouseNumber() {
		availableHouseNumber--;
	}
	
	//gets the available number of houses a player can purchase
	public int getAvailableHouseNumber() {
		return availableHouseNumber;
	}
	
	//adds to total number of available hotel numbers
	public void addAvailableHotelNumber() {
		availableHotelNumber++;
	}
	
	//reduces the available number of hotels
	public void reduceAvailableHotelNumber() {
		availableHotelNumber--;
	}
	
	//gets the total number of hotels available to purchase
	public int getAvailableHotelNumber() {
		return availableHotelNumber;
	}
	
	//add building number adds the number of building owned by a player
	public void addBuildingNumber() {
		buildingNumber++;
	}
	
	//reduce building number reduces the number of building owned by a player
	public void reduceBuildingNumber() {
		buildingNumber--;
	}
	
	public int getBuildingNumber() {
		return buildingNumber;
	}
	
	//setter and getter for rent
	public void setRents(int[] someRents) {
		rents = someRents;
	}
	
	public int[] getRents() {
		return rents;
	}
	
	public void setToBeUnimproved(boolean whetherToBeUnimproved) {
		toBeUnimproved = whetherToBeUnimproved;
	}
	
	public boolean getToBeUnimproved() {
		return toBeUnimproved;
	}
	
	//checks if a player has a property on mortgage
	public void setMortgaged(boolean whetherMortgaged) {
		mortgaged = whetherMortgaged;
	}
	
	//bool; so if true that means the player mortgaged their porpoerty and false otherwise
	public boolean getMortgaged() {
		return mortgaged;
	}
	
	//setter and getter for retrieving owner ID
	public void setOwnerID(int anOwnerID) {
		ownerID = anOwnerID;
	}
	
	public int getOwnerID() {
		return ownerID;
	}
	
	//group ID referes to a group of property owned by a single player
	public void setGroupOwnerID(int aLocation, int aGroupOwnerID) {
		groupOwnerIDs[getGroupID(aLocation)] = aGroupOwnerID;
	}
	
	//setter and getter for group owner
	public int getGroupOwnerID(int aLocation) {
		return groupOwnerIDs[getGroupID(aLocation)];
	}
	
	public int[] getGroupLocations(int aLocation) {
		return groupLocations[getGroupID(aLocation)];
	}
	
	//Name: getGroupID
	//Parameters (int aLocation)
	//What it Does: retrieves a group ID when taking an instance of their location, loops through various locations and if 
	public int getGroupID(int aLocation) {
		int groupID = 0;
		loop:
		for(int i = 0; i < groupLocations.length; i++) {
				for(int j = 0; j < groupLocations[i].length; j++) {
					if(groupLocations[i][j] == aLocation) {
						groupID = i;
						break loop;
					}
				}
		}
		return groupID;
	}
}
