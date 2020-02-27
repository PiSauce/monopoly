import java.util.ArrayList;

public class Game {
	private int turnNo = 0;
	private Board board;
	private ArrayList<Player> playerList = new ArrayList<Player>();
	
	private void Main(String[] args) {
		while(true) {
			turn(board);
		}
	}
	
	private void setup(int playerCount) {
		board = new Board();
		playerList.clear();
		for(int i = 0; i < playerCount; i++) {
			playerList.add(new Player(i, 0));
		}
	}
	
	private void turn(Board board) {
		Player player = playerList.get(turnNo); // Get current player
		int[] dice = player.roll(); // Get dice roll
		player.setPosition(player.getPosition() + dice[0] + dice[1]); // Change player position
		
		Property prop = board.getProperty(player.getPosition());
		board.getProperty(player.getPosition()).getAction());
	}
	
	private void chanceCard(int action, Player currentPlayer) {
		switch(action) {
		case 0:
			currentPlayer.setPosition(0);
			currentPlayer.changeMoney(200);
			break;
		case 1:
			currentPlayer.setPosition(24);
			// need to check theBoard
			break;
		case 2:
			currentPlayer.setPosition(11);
			// need to check theBoard
			break;
		case 3:
			// need to check theBoard
			break;
		case 4:
			// need to check theBoard
			currentPlayer.changeMoney();
			break;
		case 5:
			currentPlayer.changeMoney(50);
			break;
		case 6:
			//
			break;
		case 7:
			currentPlayer.setPosition(currentPlayer.getPosition()-3);
			// need to check theBoard
			break;
		case 8:
			currentPlayer.setPosition(40);
			break;
		case 9:);
			currentPlayer.getProperty();
			currentPlayer.changeMoney();
			break;
		case 10:
			currentPlayer.changeMoney(-15);
			break;
		case 11:
			currentPlayer.setPosition(5);
			// need to check theBoard
			currentPlayer.changeMoney(200);
			break;
		case 12:;
			currentPlayer.setPosition(39);
			// need to check theBoard
			break;
		case 13:
			for (Player p: playerList) {
				p.changeMoney(50);
				currentPlayer.changeMoney(-50);
			}
			break;
		case 14:);
			currentPlayer.changeMoney(150);
			theBank.changeMoney(-150);
			break;
		case 15:
			currentPlayer.changeMoney(100);
			theBank.changeMoney(-100);
			break;
		default:
			break;
		}
	}
}
