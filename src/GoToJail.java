//the class for sending a player to jail, just calls the construtor from tile
//child class of tile and only extends parent when a player lands on the jail index on the board
public class GoToJail extends Tile{
    public GoToJail(){
        super("Go to Jail");
    }
}
