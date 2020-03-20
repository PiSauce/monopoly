import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Game {
	private int turnNo = 0;
	private Board board;
	private ArrayList<Player> playerList = new ArrayList<Player>();
	
	public void newGame(int playerCount) {
		board = new Board();
		board.initTiles();
		board.initChanceDeck();
		board.initChestDeck();
		playerList.clear();

		Scanner in = new Scanner(System.in);

		for(int i = 0; i < playerCount; i++) {
			playerList.add(new Player(i, 0));
		}

		while(playerList.size() > 1){
			turn(board, in);
		}

		in.close();
	}
	
// Turns ------------------------------------------------------
// TODO: Add actions for Go tile
// TODO: Add actions for GoToJail tile
// TODO: Finish actions for Railroad tiles
// TODO: Add trading (?)
// TODO: Add actions for if player is jailed
	public void turn(Board board, Scanner in) {
		HashMap<Integer, String> validActions = new HashMap<Integer, String>();
		int counter = 0;

		// Get current player
		Player player = playerList.get(turnNo);
		boolean doubles = false;

		System.out.println("It is player " + (turnNo + 1) + "'s turn.");
		
		do {
		// Roll dice
		int[] dice = player.roll();
		doubles = dice[0] == dice[1];
		counter += doubles ? 1:0;

		System.out.println("Rolled a " + (dice[0] + dice[1]) + "! (" + dice[0] + " and " + dice[1] + ")");
		if(doubles) System.out.println("Doubles!");;

		// TODO: Add jail position here
		if(counter == 3){ // If player has rolled a double 3 times
			System.out.println("Rolled a double 3 times! Player " + player.getTurnNum() + " has been sent to jail!");
			player.setPosition(0/* change this to Jail position */); // Set player position to jail
			player.setJailed(true); // Change player actions to jailed actions
			break; // End turn immediately
		}
		
		// Move player
		player.move(dice[0] + dice[1]);
		Tile curTile = board.getTile(player.getPosition());
		System.out.println("Currently at " + curTile.getName()+ ".");
		
		// Make any transactions
		if(curTile instanceof Property){ // If current tile is a property
			Property tile = (Property) curTile;

			// Print out valid actions
			if(tile.getOwner() == -1) { // If property is unowned
				System.out.println("0: Buy " + tile.getName() + "? $" + tile.getPrice());
				validActions.put(0, "Buy Property");
			} else { // If property is owned
				if(tile.getOwner() != player.getTurnNum()) { // If player does not own property
					doAction(-1, player, tile); // Give money to owner of property
				}
			}
			if(player.getProperties().size() >= 0){ // If player owns a property
				if(tile.getHouses() != 0 && tile.getHotels() == 0){
					System.out.println("1: Mortgage Property");
					validActions.put(1, "Mortgage Property");
				}
				if(tile.getHouses() != 0){
					System.out.println("2: Sell Houses");
					validActions.put(2, "Sell Houses");
				}
				if(tile.getHotels() != 0){
					System.out.println("3: Sell Hotels");
					validActions.put(3, "Sell Hotels");
				}
			}

			int input = checkInput(validActions, in);
			doAction(input, player, tile);
		}

		if(curTile instanceof Railroad){ // If current tile is a railroad
			Railroad tile = (Railroad) curTile;

			// Print out valid actions
			if(tile.getOwner() == -1) { // If property is unowned
				System.out.println("0: Buy " + tile.getName() + "? $" + tile.getPrice());
				validActions.add(0);
			} else { // If property is owned
				if(tile.getOwner() != player.getTurnNum()) { // If player does not own property
					doAction(-1, player, tile); // Give money to owner of property
				} else { // If player does own peoperty
					
				}
			}
		}

		if(curTile instanceof TaxTile){ // If current tile is a tax tile
			TaxTile tile = (TaxTile) curTile;
			doAction(player, tile);
		}

		if(curTile instanceof Community){ // If current tile is a community chest
			Community chest = (Community) curTile;
			doAction(player, chest);
		}

		if(curTile instanceof Chance){ // If current tile is a chance card
			Chance chance = (Chance) curTile;
			doAction(player, chance);
		}
		
		} while(doubles);

		// Increment turn
		if(++turnNo % playerList.size() == 0) turnNo--;
	}

	private int checkInput(HashMap<Integer, String> validActions, Scanner in) {
		boolean valid = false;
		int input = -1;

		while (!valid) {
			System.out.print("Type an action: ");
			try {
				input = Integer.parseInt(in.nextLine());
			} catch (NumberFormatException e) {
				continue;
			}
			
			for (int i : validActions.keySet()) {
				if(i == input) valid = true;
			}
		}
		return input;
	}

// Actions for each tile type added below
// - Tax tile
// - Community and Chance card
// - Railroad
// 		- TODO: Proper penalties for railroads
// 			- Needs to be 25 * 2^(Number of railroads owned)
//		- TODO: Mortgaging railroads
// - Property
// 		- TODO: Mortgage prices
// 		- TODO: Buying and selling houses and hotels
// - Card
// 		- TODO: Proper actions for each card
// 		- TODO: Adding print statemets to clarify to player
	// Tax tile actions
	private void doAction(Player player, TaxTile tile){
		player.changeMoney(-tile.getTax()); // Only one action for taxes
	}

	// Community chest actions
	private void doAction(Player player, Community chest){
		Card card = board.drawChest();
		cardAction(card.getID(), player);
	}

	// Chance card actions
	private void doAction(Player player, Chance chance){
		Card card = board.drawChance();
		cardAction(card.getID(), player);
	}

// Railroad actions ------------------------------------------------------
	private void doAction(int action, Player player, Railroad property) {
		switch(action){
			case 0: // Buy property
				if(property.getOwner() == -1 && player.getMoney() >= property.getPrice()){ // If unowned and player has enough money
					player.changeMoney(-property.getPrice()); // Remove money from player
					property.setOwner(player.getTurnNum()); // Set property owner to current player
					System.out.println("Bought " + property.getName() + "!");
					System.out.println("Currently have $" + player.getMoney() + ".");
					System.out.println("");
				} else {
					System.out.println("Property already has an owner!"); // Should not happen
				}
				break;
			case 1: // Mortgage property
				
			case -1: // Change owner of money
				if(player.getTurnNum() != property.getOwner()) {
					player.changeMoney(property.getPenalty());
					playerList.get(property.getOwner()).changeMoney(property.getPenalty());
				}
				break;
		}
	}

// Property actions ------------------------------------------------------
	private void doAction(int action, Player player, Property property) {
		switch(action){
			case 0: // Buy property
				if(property.getOwner() == -1 && player.getMoney() >= property.getPrice()){ // If unowned and player has enough money
					player.changeMoney(-property.getPrice()); // Remove money from player
					property.setOwner(player.getTurnNum()); // Set property owner to current player
					System.out.println("Bought " + property.getName() + "!");
					System.out.println("Currently have $" + player.getMoney() + ".");
					System.out.println("");
				} else {
					System.out.println("Property already has an owner!"); // Should not happen
				}
				break;
			case 1: // Mortgage property
				break;
			case 2: // Sell houses
				break;
			case 3: // Sell hotels
				break;
			case -1: // Change owner of money
				if(player.getTurnNum() != property.getOwner()) {
					player.changeMoney(property.getPenalty());
					playerList.get(property.getOwner()).changeMoney(property.getPenalty());
				}
				break;
		}
	}
	
// Card actions ------------------------------------------------------
	private void cardAction(int action, Player currentPlayer) {
		// 0 - 15 => Chance cards
		// 16 - 31 => Community chest
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
