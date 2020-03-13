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

    public void addAction(int action) {
        this.actions.add(action);
    }

    public void clearActions() {
        this.actions.clear();
    }
}