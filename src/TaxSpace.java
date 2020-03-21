import javafx.scene.paint.Color;
import javafx.scene.image.ImageView;

public class TaxSpace extends Landmark {
	
	private int penalties;
	
	public TaxSpace(String aDescription, Color aColor, ImageView aLandmark, int somePenalties) {
		super(aDescription, aColor, aLandmark);
		setPenalties(somePenalties);
	}
	
	public void setPenalties(int somePenalties) {
		penalties = somePenalties;
	}
	
	public int getPenalties() {
		return penalties;
	}
}
