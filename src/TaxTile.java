//textile class
public class TaxTile extends Tile {
    private int tax; //instance variables
    
    //constructor
    public TaxTile(String name, int tax){
        super(name);
        this.tax = tax;
    }
    
    //getter and setter
    public int getTax() {
        return tax;
    }

    public void setTax(int tax) {
        this.tax = tax;
    }
}
