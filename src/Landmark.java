import javafx.scene.paint.Color;
import javafx.scene.image.ImageView;

public class Landmark {
	
	//instance variables
	private String description;
	private Color color;
	private ImageView landmark;
	private int ownerID = -1;
	private int groupOwnerID = -1;
	
	//constructor (takes a description, color and landmark)
	public Landmark(String aDescription, Color aColor, ImageView aLandmark) {
		setDescription(aDescription);
		setColor(aColor);
		setLandmark(aLandmark);
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
	
	//sets the image of the landmark on the board with heightxwidth to fit a square icon
	public void setLandmark(ImageView aLandmark) {
		landmark = aLandmark;
		landmark.setPreserveRatio(false);
		landmark.setFitWidth(300);
		landmark.setFitHeight(300);
	}
	
	//gets the image of the landmark
	public ImageView getLandmark() {
		return landmark;
	}
	
	//getter for price
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
