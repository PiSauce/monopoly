import java.util.Random;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

//dice class
public class Dice {
	
	//instance variables
	private int number;
	private ImageView faceIcon;
	private static int doubleNumber;
	
	//constructor
	public Dice() {
		setNumber();
		setFaceIcon();
		setDoubleNumber();
	}
	
	//setter and getter for dice roll
	public void setNumber() {
		number = new Random().nextInt(6)+1;
	}
	
	public int getNumber() {
		return number;
	}
	
	//sets front view image of the dice
	public void setFaceIcon() {
		faceIcon = new ImageView(new Image("Dice/" + number + ".jpg"));
		faceIcon.setPreserveRatio(false);
		faceIcon.setFitWidth(100);
		faceIcon.setFitHeight(100);
	}
	
	//getter for the imageview of the dice
	public ImageView getFaceIcon() {
		return faceIcon;
	}
	
	//sets counter for double number
	public void setDoubleNumber() {
		doubleNumber = 0;
	}
	
	//adds one if a player rolls a double
	public void addDoubleNumber() {
		doubleNumber++;
	}
	
	//returns number of doubled a player rolls
	public int getDoubleNumber() {
		return doubleNumber;
	}
}
