import java.util.ArrayList;
import javafx.scene.image.ImageView;

public class Player {
	
	private String username;
	private int id;
	private ImageView token;
	private int money = 1500;
	private int position = 0;
	private ArrayList<Landmark> properties = new ArrayList<Landmark>();
	
	public Player(String aUsername, int aID, ImageView aToken) {
		setUsername(aUsername);
		setID(aID);
		setToken(aToken);		
	}
	
	public void setUsername(String aUsername) {
		username = aUsername;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setID(int aID) {
		id = aID;
	}
	
	public int getID() {
		return id;
	}
	
	public void setToken(ImageView aToken) {
		token = aToken;
		token.setPreserveRatio(false);
		token.setFitWidth(30);
		token.setFitHeight(30);
	}
	
	public ImageView getToken() {
		return token;
	}
	
	public void addMoney(int someMoney) {
		money += someMoney;
	}
	
	public void reduceMoney(int someMoney) {
		money -= someMoney;
	}
	
	public int getMoney() {
		return money;
	}
	
	public void setPosition(int aPosition) {
		position = aPosition;
	}
	
	public void moveForward(int steps) {
		position += steps;
	}
	
	public void moveBackward(int steps) {
		position -= steps;
	}
	
	public int getPosition() {
		return position;
	}
	
	public void addProperty(Landmark aProperty) {
		properties.add(aProperty);
	}
	
	public void removeProperty(Landmark aProperty) {
		properties.remove(aProperty);
	}
	
	public ArrayList<String> getPropertyDescriptions() {
		ArrayList<String> propertyDescriptions = new ArrayList<String>();
		for(Landmark aProperty: properties) {
			propertyDescriptions.add(aProperty.getDescription());
		}
		return propertyDescriptions;
	}
}
