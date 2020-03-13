import java.util.ArrayList;

public abstract class Tile {
    // Instance variables
    private String name;
    private ArrayList<Integer> actions;

    public Tile(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Integer> getActions() {
        return actions;
    }

    public void setAction(ArrayList<Integer> actions) {
        this.actions.clear();
        for (Integer i : actions) {
            this.actions.add(i);
        }
    }
}