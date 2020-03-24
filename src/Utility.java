
//importing the necessary java files
import javafx.scene.paint.Color;
import javafx.scene.image.ImageView;

//utility class
public class Utility extends Landmark {
	
	//instance variables
	private final int price = 150;
	private boolean mortgaged = false;
	private int ownerID = -1;
	private static int groupOwnerID = -1;
	private final int[] groupLocations = {12, 28};
	
	//constructor
	public Utility(String aDescription, Color aColor, ImageView aLandmark) {
		super(aDescription, aColor, aLandmark);
	}
	
	//getter for price
	public int getPrice() {
		return price;
	}
	
	//sets mortgage rates
	public void setMortgaged(boolean whetherMortgaged) {
		mortgaged = whetherMortgaged;
	}
	
	//gets mortgage 
	public boolean getMortgaged() {
		return mortgaged;
	}
	
	//sets owner (player) of the utility
	public void setOwnerID(int anOwnerID) {
		ownerID = anOwnerID;
	}
	
	//gets the owner (player)
	public int getOwnerID() {
		return ownerID;
	}
	
	//sets group owner
	public void setGroupOwnerID(int aGroupOwnerID) {
		groupOwnerID = aGroupOwnerID;
	}
	//gets group owner
	public int getGroupOwnerID() {
		return groupOwnerID;
	}
	
	//getter for group location
	public int[] getGroupLocations() {
		return groupLocations;
	}
}
