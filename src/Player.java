import java.util.ArrayList;
import javafx.scene.image.ImageView;

public class Player {
	
	private String username;
	private int id;
	private ImageView token;
	private static int currentPlayerIndex = 0;
	private int inJailNumber = -1;
	private boolean justOutOfJail = false;
	private int position = 0;
	private int money = 1500;
	private ArrayList<Integer> propertyIDs = new ArrayList<Integer>();
	
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
	
	public void setNextPlayerIndex(int aPlayersSize) {
		currentPlayerIndex = ++currentPlayerIndex % aPlayersSize;
	}
	
	public int getCurrentPlayerIndex() {
		return currentPlayerIndex;
	}
	
	public void setInJailNumber() {
		inJailNumber = -1;
	}
	
	public void addInJailNumber() {
		inJailNumber++;
	}
	
	public int getInJailNumber() {
		return inJailNumber;
	}
	
	public void setJustOutOfJail(boolean whetherJustOutOfJail) {
		justOutOfJail = whetherJustOutOfJail;
	}
	
	public boolean getJustOutOfJail() {
		return justOutOfJail;
	}
	
	public void setPosition(int aPosition) {
		position = aPosition;
	}
	
	public void moveForward(int steps) {
		position = (position + steps) % 40;
	}
	
	public void moveBackward(int steps) {
		position = (position - steps) % 40;
	}
	
	public int getPosition() {
		return position;
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
	
	public void addPropertyID(int aPropertyID) {
		propertyIDs.add(aPropertyID);
	}
	
	public void removePropertyID(int aPropertyID) {
		propertyIDs.remove(aPropertyID);
	}
	
	public ArrayList<Integer> getPropertyIDs() {
		ArrayList<Integer> tempPropertyIDs = new ArrayList<>(propertyIDs);
		return tempPropertyIDs;
	}

	//returns an arraylist of properties
	public ArrayList<Integer> getProperties() {
		return properties;
	}
	
	//sets arraylist of properties
	public void setProperties(ArrayList<Integer> properties) {
		this.properties = properties;
	}
}
