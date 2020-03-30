import javafx.scene.paint.Color;
import javafx.scene.image.ImageView;

public class Landmark {
	
	private String description;
	private Color color;
	private ImageView landmark;
	private int ownerID = -1;
	private int groupOwnerID = -1;
	
	public Landmark(String aDescription, Color aColor, ImageView aLandmark) {
		setDescription(aDescription);
		setColor(aColor);
		setLandmark(aLandmark);
	}
	
	public void setDescription(String aDescription) {
		description = aDescription;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setColor(Color aColor) {
		color = aColor;
	}
	
	public Color getColor() {
		return color;
	}
	
	public void setLandmark(ImageView aLandmark) {
		landmark = aLandmark;
		landmark.setPreserveRatio(false);
		landmark.setFitWidth(300);
		landmark.setFitHeight(300);
	}
	
	public ImageView getLandmark() {
		return landmark;
	}
	
	public int getPrice() {
		return -1;
	}
	
	public boolean getMortgaged() {
		return false;
	}
	
	public void setOwnerID(int anOwnerID) {
		ownerID = anOwnerID;
	}
	
	public int getOwnerID() {
		return ownerID;
	}
	
	public void setGroupOwnerID(int aLocation, int aGroupOwnerID) {
		groupOwnerID = aGroupOwnerID;
	}
	
	public int[] getGroupLocations(int aLocation) {
		return new int[] {-1};
	}
}
