public class Railroad extends Tile{
    private int price;
    private int penalty;
    private int owner = -1;
    
    public Railroad(String name){
        super(name + " Railroad");
        setPrice(200); // Default railroad price
        setPenalty(25); // Starts at 25, doubles for each owned railroad
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPenalty() {
        return penalty;
    }

    public void setPenalty(int penalty) {
        this.penalty = penalty;
    }

    public int getOwner() {
        return owner;
    }

    public void setOwner(int owner) {
        this.owner = owner;
    }
}