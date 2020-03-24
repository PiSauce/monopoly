//import java fx
import javafx.scene.paint.Color;
import javafx.scene.image.ImageView;

//railroad class (is a type of property)
public class Railroad extends Landmark {
	
	//instance variables
	private final int price = 200;
	private final int[] rents = {25, 50, 100, 200};
	private boolean mortgaged = false;
	private int ownerID = -1;
	private static int groupOwnerID = -1;
	private final int[] groupLocations = {5, 15, 25, 35};
	
	//constructor
	public Railroad(String aDescription, Color aColor, ImageView aLandmark) {
		super(aDescription, aColor, aLandmark);
	}
	//gets prices of railroads
	public int getPrice() {
		return price;
	}
	//gets rent paid by railroad
	public int[] getRents() {
		return rents;
	}
	//sets mortgage value for railroads
	public void setMortgaged(boolean whetherMortgaged) {
		mortgaged = whetherMortgaged;
	}
	//gets mortgage value for railroads
	public boolean getMortgaged() {
		return mortgaged;
	}
	//sets owner (player) of railroads
	public void setOwnerID(int anOwnerID) {
		ownerID = anOwnerID;
	}
	//gets owner of the railroad
	public int getOwnerID() {
		return ownerID;
	}
	//sets group owner (sets if a player has more than one railroad)
	public void setGroupOwnerID(int aGroupOwnerID) {
		groupOwnerID = aGroupOwnerID;
	}
	//gets ID of grouped railroads
	public int getGroupOwnerID() {
		return groupOwnerID;
	}
	//gets the placements of the group of railroads
	public int[] getGroupLocations() {
		return groupLocations;
	}
}
