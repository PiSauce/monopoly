import java.util.Random;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Dice {
	
	private int number;
	private ImageView faceIcon;
	private static int doubleNumber;
	
	public Dice() {
		setNumber();
		setFaceIcon();
		setDoubleNumber();
	}
	
	public void setNumber() {
		number = new Random().nextInt(6)+1;
	}
	
	public int getNumber() {
		return number;
	}
	
	public void setFaceIcon() {
		faceIcon = new ImageView(new Image("Dice/" + number + ".jpg"));
		faceIcon.setPreserveRatio(false);
		faceIcon.setFitWidth(100);
		faceIcon.setFitHeight(100);
	}
	
	public ImageView getFaceIcon() {
		return faceIcon;
	}
	
	public void setDoubleNumber() {
		doubleNumber = 0;
	}
	
	public void addDoubleNumber() {
		doubleNumber++;
	}
	
	public int getDoubleNumber() {
		return doubleNumber;
	}
}
