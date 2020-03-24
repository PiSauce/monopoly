
//importing java fx
import javafx.scene.paint.Color;
import javafx.scene.image.ImageView;

//tax space class
public class TaxSpace extends Landmark {
	//instance variable
	private int penalties;
	
	//constructor
	public TaxSpace(String aDescription, Color aColor, ImageView aLandmark, int somePenalties) {
		super(aDescription, aColor, aLandmark);
		setPenalties(somePenalties);
	}
	//setter for penalities
	public void setPenalties(int somePenalties) {
		penalties = somePenalties;
	}
	//gets the penalty
	public int getPenalties() {
		return penalties;
	}
}
