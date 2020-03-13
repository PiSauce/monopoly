import java.util.ArrayList;

public class Game {
	private int turnNo = 0;
	private Board board;
	private ArrayList<Player> playerList = new ArrayList<Player>();
	private ArrayList<Integer> actionList = new ArrayList<Integer>();

	/*

	TODO: Add sell property action
	TODO: Add mortgage action
	TODO: Add chance and community chest actions

	*/
	
	public void newGame(int playerCount) {
		board = new Board();
		playerList.clear();
		for(int i = 0; i < playerCount; i++) {
			playerList.add(new Player(i, 0));
		}

		while(true){
			turn(board);
		}
	}
	
	public void turn(Board board) {
		int counter = 0;

		// Get current player
		Player player = playerList.get(turnNo);
		boolean doubles = false;

		System.out.println("It is player " + turnNo + "'s turn.");
		
		do {
		// Roll dice
		int[] dice = player.roll();
		doubles = dice[0] == dice[1];
		counter += doubles ? 1:0;

		System.out.println("Rolled a " + (dice[0] + dice[1]) + "! (" + dice[0] + " and " + dice[1] + ")");

		if(counter == 3){ // If player has rolled a double 3 times
			System.out.println("Rolled a double 3 times! Player " + player.getTurnNum() + " has been sent to jail!");
			player.setPosition(0/* change this to Jail position */); // Set player position to jail
			player.setJailed(true); // Change player actions to jailed actions
			break; // End turn immediately
		}
		
		// Move player
		player.move(dice[0] + dice[1]);
		Property curProp = board.getProperty(player.getPosition());
		System.out.println("Currently at " + curProp.getName()+ ".");

		if((curProp).getOwner() != player.getTurnNum()) { // If player does not own property
			doAction(3, player); // Give money to owner of property
		}
		
		// Make any transactions
		System.out.println("0: Buy property");
		System.out.println("1: Sell property");
		System.out.println("2: Mortgage property");
		System.out.println("");
		
		} while(doubles);
		
		// Increment turn
		turnNo++;
	}

	private void doAction(int action, Player player) {
		Property property = board.getProperty(player.getPosition());
		switch(action){
			case -1: // Invalid action
				break;

			// Property actions
			case 0: // Buy property
				if(property.getOwner() == -1 && player.getMoney() >= property.getPrice()){ // If unowned and player has enough money
					player.changeMoney(-property.getPrice()); // Remove money from player
					property.setOwner(player.getTurnNum()); // Set property owner to current player
				} else {
					System.out.println("Property already has an owner!");
				}
				break;
			case 1: // Sell property
				break;
			case 2: // Mortgage property
				break;
			case 3: // Change owner of money
				if(player.getTurnNum() != property.getOwner()) {
					player.changeMoney(property.getPenalty());
					playerList.get(property.getOwner()).changeMoney(property.getPenalty());
				}
				break;
			
			// Special Tile actions
			// Community chest actions
			case 10: // Draw from community chest pile
				cardAction(board.chestDeck.draw().getID(), player);
			
			// Chance actions
			case 11: // Draw from chance card pile
				cardAction(board.chanceDeck.draw().getID(), player);
			
			// Taxes
			case 12: // Remove x amount from player
				player.changeMoney(-board.getTax(player.getPosition()));
		}
	}
	
	private void cardAction(int action, Player currentPlayer) {
		switch(action) {
		case 0:
			currentPlayer.setPosition(0);
			currentPlayer.changeMoney(200);
			break;
		case 1:
			currentPlayer.setPosition(24);
			break;
		case 2:
			currentPlayer.setPosition(11);
			break;
		case 3:
			break;
		case 4:
			currentPlayer.changeMoney(0);
			break;
		case 5:
			currentPlayer.changeMoney(50);
			break;
		case 6:
			//
			break;
		case 7:
			currentPlayer.setPosition(currentPlayer.getPosition()-3);
			break;
		case 8:
			currentPlayer.setPosition(40);
			break;
		case 9:;
			currentPlayer.changeMoney(0);
			break;
		case 10:
			currentPlayer.changeMoney(-15);
			break;
		case 11:
			currentPlayer.setPosition(5);
			currentPlayer.changeMoney(200);
			break;
		case 12:;
			currentPlayer.setPosition(39);
			break;
		case 13:
			for (Player p: playerList) {
				p.changeMoney(50);
				currentPlayer.changeMoney(-50);
			}
			break;
		case 14:
			currentPlayer.changeMoney(150);
			break;
		case 15:
			currentPlayer.changeMoney(100);
			break;
		default:
			break;
		}
	}
}
