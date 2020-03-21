import javafx.scene.paint.Color;
import javafx.scene.image.ImageView;

public class ColorGroup extends Landmark {
	
	private int price;
	private int buildingCost;
	private int houseNumber = 0;
	private int hotelNumber = 0;
	private int[] rents;
	private boolean mortgaged = false;
	private int ownerID = -1;
	private static int[] groupOwnerIDs = {-1, -1, -1, -1, -1, -1, -1, -1};
	private final int[][] groupLocations = {{1, 3}, {6, 8, 9}, {11, 13, 14}, {16, 18, 19}, {21, 23, 24}, {26, 27, 29}, {31, 32, 34}, {37, 39}};
	
	public ColorGroup(String aDescription, Color aColor, ImageView aLandmark, int aPrice, int someBuildingCost, int[] someRents) {
		super(aDescription, aColor, aLandmark);
		setPrice(aPrice);
		setBuildingCost(someBuildingCost);
		setRents(someRents);
	}
	
	public void setPrice(int aPrice) {
		price = aPrice;
	}
	
	public int getPrice() {
		return price;
	}
	
	public void setBuildingCost(int someBuildingCost) {
		buildingCost = someBuildingCost;
	}
	
	public int getBuildingCost() {
		return buildingCost;
	}
	
	public void addHouseNumber() {
		houseNumber++;
	}
	
	public void reduceHouseNumber() {
		houseNumber--;
	}
	
	public int getHouseNumber() {
		return houseNumber;
	}
	
	public void addHotelNumber() {
		hotelNumber++;
	}
	
	public void reduceHotelNumber() {
		hotelNumber--;
	}
	
	public int getHotelNumber() {
		return hotelNumber;
	}
	
	public void setRents(int[] someRents) {
		rents = someRents;
	}
	
	public int[] getRents() {
		return rents;
	}
	
	public void setMortgaged(boolean whetherMortgaged) {
		mortgaged = whetherMortgaged;
	}
	
	public boolean getMortgaged() {
		return mortgaged;
	}
	
	public void setOwnerID(int anOwnerID) {
		ownerID = anOwnerID;
	}
	
	public int getOwnerID() {
		return ownerID;
	}
	
	public void setGroupOwnerID(int aLocation, int aGroupOwnerID) {
		groupOwnerIDs[getGroupID(aLocation)] = aGroupOwnerID;
	}
	
	public int getGroupOwnerID(int aLocation) {
		return groupOwnerIDs[getGroupID(aLocation)];
	}
	
	public int[] getGroupLocations(int aLocation) {
		return groupLocations[getGroupID(aLocation)];
	}
	
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
