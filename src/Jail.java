import java.util.ArrayList;

public class Jail extends Tile{
    private ArrayList<Integer> jList = new ArrayList<Integer>();
    
    //constructor
    public Jail(){
        super("Jail");
    }
    
    //returns an integer list 
    public ArrayList<Integer> getjList() {
        return jList;
    }
    
    //setter for jlist
    public void setjList(ArrayList<Integer> jList) {
        this.jList = jList;
    }
    
    //adds player to the list
    public void addPlayer(int player){
        this.jList.add(player);
    }
    
    //removes a player from the jlist
    public void removePlayer(int player) {
        for (int i = 0; i < jList.size(); i++) {
            if(jList.get(i) == player) jList.remove(i);
        }
    }
}
