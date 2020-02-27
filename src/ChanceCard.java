import java.util.ArrayList;

public class ChanceCard extends Card {
	
	private String description;
	private int label;
	
	public void action(Player currentPlayer, ArrayList<Player> playerList, Bank theBank, Board theBoard, int i) {
		
		switch(i) {
			case 0:
				setDescription("Advance to Go, Collect $200");
				currentPlayer.setPosition(0);
				currentPlayer.changeMoney(200);
				theBank.changeMoney(-200);
				break;
			case 1:
				setDescription("Advance to Illinois Avenue");
				currentPlayer.setPosition(24);
				// need to check theBoard
				break;
			case 2:
				setDescription("Advance to St. Charles Place");
				currentPlayer.setPosition(11);
				// need to check theBoard
				break;
			case 3:
				setDescription("Advance token to nearest utility. If unowned, you may buy it from the bank; If owned, throw the dice and pay owner a total of 10 times the amount thrown.");
				currentPlayer.setPosition();
				// need to check theBoard
				break;
			case 4:
				setDescription("Advance token to the nearest Railroad and pay owner twice the rental to which he/she is otherwise entitled. If Railroad is unowned, you may buy it from the Bank.");
				currentPlayer.setPosition();
				// need to check theBoard
				currentPlayer.changeMoney();
				theBank.changeMoney();
				break;
			case 5:
				setDescription("Bank pays you dividend of $50");
				currentPlayer.changeMoney(50);
				theBank.changeMoney(-50);
				break;
			case 6:
				setDescription("Get out of Jail Free");
				//
				break;
			case 7:
				setDescription("Go Back Three Spaces");
				currentPlayer.setPosition(currentPlayer.getPosition()-3);
				// need to check theBoard
				break;
			case 8:
				setDescription("Go to Jail. Go directly to Jail. Do not pass GO, do not collect $200.");
				currentPlayer.setPosition(40);
				break;
			case 9:
				setDescription("Make general repairs on all your property: For each house pay $25, For each hotel $100.");
				currentPlayer.getProperty();
				currentPlayer.changeMoney();
				theBank.changeMoney();
				break;
			case 10:
				setDescription("Pay poor tax of $15");
				currentPlayer.changeMoney(-15);
				theBank.changeMoney(15);
				break;
			case 11:
				setDescription("Take a trip to Reading Railroad. If you pass Go, collect $200.");
				currentPlayer.setPosition(5);
				// need to check theBoard
				currentPlayer.changeMoney(200);
				theBank.changeMoney(-200);
				break;
			case 12:
				setDescription("Take a walk on the Boardwalk. Advance token to Boardwalk.");
				currentPlayer.setPosition(39);
				// need to check theBoard
				break;
			case 13:
				setDescription("You have been elected Chairman of the Board. Pay each player $50.");
				for (Player p: playerList) {
					p.changeMoney(50);
					currentPlayer.changeMoney(-50);
				}
				break;
			case 14:
				setDescription("Your building loan matures. Receive $150.");
				currentPlayer.changeMoney(150);
				theBank.changeMoney(-150);
				break;
			case 15:
				setDescription("You have won a crossword competition. Collect $100.");
				currentPlayer.changeMoney(100);
				theBank.changeMoney(-100);
				break;
			default:
				break;
		}
		
	}
}
