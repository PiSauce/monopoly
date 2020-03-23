public class Utility extends Tile{
    private int price;
    private int owner = -1;
    private boolean mortgaged;
    // Penalty for Utilities is 4x dice roll or 10x dice roll
    // - Implement in Game.java

    public Utility(String name){
        super(name);
        setPrice(150); // Price for both utilities is $150
        setMortgaged(false);
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getOwner() {
        return owner;
    }

    public void setOwner(int owner) {
        this.owner = owner;
    }

    public boolean isMortgaged() {
        return mortgaged;
    }

    public void setMortgaged(boolean mortgaged) {
        this.mortgaged = mortgaged;
    }
}