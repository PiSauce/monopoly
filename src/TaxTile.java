public class TaxTile extends Tile {
    private int tax;

    public TaxTile(String name){
        super(name);
        if(name == "Income Tax") setTax(200);; // Remove $200
        if(name == "Luxury Tax") setTax(100);; // Remove $100
    }

    public int getTax() {
        return tax;
    }

    public void setTax(int tax) {
        this.tax = tax;
    }
}