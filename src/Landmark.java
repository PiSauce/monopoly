import javafx.scene.paint.Color;
import javafx.scene.image.ImageView;

public class Landmark {
	
	private String description;
	private Color color;
	private ImageView landmark;
	
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
		landmark.setFitWidth(250);
		landmark.setFitHeight(500);
	}
	
	public ImageView getLandmark() {
		return landmark;
	}
}
