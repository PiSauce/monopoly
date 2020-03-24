//importing necessary javafx files

import javafx.scene.paint.Color;
import javafx.scene.image.ImageView;



public class ColorGroup extends Landmark {
	//instance variables
	private int price;
	private int buildingCost;
	private int houseNumber = 0;
	private int hotelNumber = 0;
	private int[] rents;
	private boolean mortgaged = false;
	private int ownerID = -1;
	private static int[] groupOwnerIDs = {-1, -1, -1, -1, -1, -1, -1, -1};
	private final int[][] groupLocations = {{1, 3}, {6, 8, 9}, {11, 13, 14}, {16, 18, 19}, {21, 23, 24}, {26, 27, 29}, {31, 32, 34}, {37, 39}};
	
	
	//constructor
	public ColorGroup(String aDescription, Color aColor, ImageView aLandmark, int aPrice, int someBuildingCost, int[] someRents) {
		super(aDescription, aColor, aLandmark);
		setPrice(aPrice);
		setBuildingCost(someBuildingCost);
		setRents(someRents);
	}
	
	//setter for price
	public void setPrice(int aPrice) {
		price = aPrice;
	}
	
	
	//getter for price
	public int getPrice() {
		return price;
	}
	
	
	//setter for building
	public void setBuildingCost(int someBuildingCost) {
		buildingCost = someBuildingCost;
	}
	
	
	//getter for building
	public int getBuildingCost() {
		return buildingCost;
	}
	
	
	//adding houses based by number
	public void addHouseNumber() {
		houseNumber++;
	}
	
	
	//reduce house number
	public void reduceHouseNumber() {
		houseNumber--;
	}
	
	
	//getter for house number
	public int getHouseNumber() {
		return houseNumber;
	}
	
	//adding hotel number
	public void addHotelNumber() {
		hotelNumber++;
	}
	
	
	//reduced number of hotels
	public void reduceHotelNumber() {
		hotelNumber--;
	}
	
	
	//gets hotel number
	public int getHotelNumber() {
		return hotelNumber;
	}
	
	
	//sets rent prices
	public void setRents(int[] someRents) {
		rents = someRents;
	}
	
	
	//getter for rents
	public int[] getRents() {
		return rents;
	}
	
	//setter for mortgage rates
	public void setMortgaged(boolean whetherMortgaged) {
		mortgaged = whetherMortgaged;
	}
	
	//get mortgage
	public boolean getMortgaged() {
		return mortgaged;
	}
	
	//set owner 
	public void setOwnerID(int anOwnerID) {
		ownerID = anOwnerID;
	}
	
	
	//getter for ID
	public int getOwnerID() {
		return ownerID;
	}
	
	//setter for groupowner
	public void setGroupOwnerID(int aLocation, int aGroupOwnerID) {
		groupOwnerIDs[getGroupID(aLocation)] = aGroupOwnerID;
	}
	
	//getter for group owner
	public int getGroupOwnerID(int aLocation) {
		return groupOwnerIDs[getGroupID(aLocation)];
	}
	
	
	//gets group location
	public int[] getGroupLocations(int aLocation) {
		return groupLocations[getGroupID(aLocation)];
	}
	
	//getter for group ID, returns group ID
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
