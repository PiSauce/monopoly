import java.util.ArrayList;

public class Jail extends Tile{
    private ArrayList<Integer> jList = new ArrayList<Integer>();

    public Jail(){
        super("Jail");
    }

    public ArrayList<Integer> getjList() {
        return jList;
    }

    public void setjList(ArrayList<Integer> jList) {
        this.jList = jList;
    }

    public void addPlayer(int player){
        this.jList.add(player);
    }

    public void removePlayer(int player) {
        for (int i = 0; i < jList.size(); i++) {
            if(jList.get(i) == player) jList.remove(i);
        }
    }
}