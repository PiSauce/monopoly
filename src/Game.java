import java.util.ArrayList;

public class Game {
	private int turnNo = 0;
	private Board board;
	private ArrayList<Player> playerList = new ArrayList<Player>();
	
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
		// Get current player
		Player player = playerList.get(turnNo);
		boolean doubles = false;
		
		do {
		// Roll dice
		int[] dice = player.roll();
		doubles = dice[0] == dice[1];
		
		// Move player
		player.move(dice[0] + dice[1]);
		System.out.println("Player " + turnNo + "\'s position: " + player.getPosition());
		
		// Make any transactions
		board.getProperty(player.getPosition()).getAction();
		} while(doubles);
		
		// Increment turn
		turnNo++;
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
