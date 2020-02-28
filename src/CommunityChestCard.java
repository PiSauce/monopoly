import java.util.ArrayList;

public class CommunityChestCard extends Card {
	
	private String description;
	private int label;
	
	public void action(Player currentPlayer, ArrayList<Player> playerList int i) {
		
		switch(i) {
			case 0:
				setDescription("Advance to Go, Collect $200");
				currentPlayer.setPosition(0);
				currentPlayer.changeMoney(200);
				theBank.changeMoney(-200);
				break;
			case 1:
				setDescription("Bank error in your favor. Collect $200.");
				currentPlayer.changeMoney(200);
				theBank.changeMoney(-200);
				break;
			case 2:
				setDescription("Doctor's fees. Pay $50.");
				currentPlayer.changeMoney(-50);
				theBank.changeMoney(50);
				break;
			case 3:
				setDescription("From sale of stock you get $50.");
				currentPlayer.changeMoney(50);
				theBank.changeMoney(-50);
				break;
			case 4:
				setDescription("Get out of Jail Free");
				//
				break;
			case 5:
				setDescription("Go to Jail. Go directly to Jail. Do not pass GO, do not collect $200.");
				currentPlayer.setPosition(40);
				break;
			case 6:
				setDescription("Grand Opera Night. Collect $50 from every player for opening night seats.");
				for (Player p: playerList) {
					p.changeMoney(-50);
					currentPlayer.changeMoney(50);
				}
				break;
			case 7:
				setDescription("Holiday Fund matures. Receive $100.");
				currentPlayer.changeMoney(100);
				theBank.changeMoney(-100);
				break;
			case 8:
				setDescription("Income tax refund. Collect $20.");
				currentPlayer.changeMoney(20);
				theBank.changeMoney(-20);
				break;
			case 9:
				setDescription("Life insurance matures �C Collect $100");
				currentPlayer.changeMoney(100);
				theBank.changeMoney(-100);
				break;
			case 10:
				setDescription("Hospital Fees. Pay $50.");
				currentPlayer.changeMoney(-50);
				theBank.changeMoney(50);
				break;
			case 11:
				setDescription("School fees. Pay $50.");
				currentPlayer.changeMoney(-50);
				theBank.changeMoney(50);
				break;
			case 12:
				setDescription("Receive $25 consultancy fee.");
				currentPlayer.changeMoney(25);
				theBank.changeMoney(-25);
				break;
			case 13:
				setDescription("You are assessed for street repairs: Pay $40 per house and $115 per hotel you own.");
				currentPlayer.getProperty();
				currentPlayer.changeMoney();
				theBank.changeMoney();
				break;
			case 14:
				setDescription("You have won second prize in a beauty contest. Collect $10.");
				currentPlayer.changeMoney(10);
				theBank.changeMoney(-10);
				break;
			case 15:
				setDescription("You inherit $100.");
				currentPlayer.changeMoney(100);
				theBank.changeMoney(-100);
				break;
			default:
				break;
		}
		
	}
}
