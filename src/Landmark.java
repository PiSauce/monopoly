import javafx.scene.paint.Color;

public class Landmark {
	
	//instance variables
	private String description;
	private Color color;
	private int ownerID = -1;
	private int groupOwnerID = -1;
	
	public Landmark(String aDescription, Color aColor) {
		setDescription(aDescription);
		setColor(aColor);
	}
	
	//setter for description
	public void setDescription(String aDescription) {
		description = aDescription;
	}
	
	//getter for description
	public String getDescription() {
		return description;
	}
	
	//setter for color
	public void setColor(Color aColor) {
		color = aColor;
	}
	
	//getter for color
	public Color getColor() {
		return color;
	}
	
	public int getPrice() {
		return -1;
	}
	
	//gets mortgage (checks if property is on mortgage or not)
	public boolean getMortgaged() {
		return false;
	}
	
	//setter owner ID
	public void setOwnerID(int anOwnerID) {
		ownerID = anOwnerID;
	}
	
	//getter for owner ID
	public int getOwnerID() {
		return ownerID;
	}
	
	//setter for group ID
	public void setGroupOwnerID(int aLocation, int aGroupOwnerID) {
		groupOwnerID = aGroupOwnerID;
	}
	
	//getGroupLocations takes a location as a parameter and returns a new integer list 
	public int[] getGroupLocations(int aLocation) {
		return new int[] {-1};
	}
}
