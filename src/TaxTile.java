public class TaxTile extends Tile {
    private int tax;

    public TaxTile(String name, int tax){
        super(name);
        this.tax = tax;
    }

    public int getTax() {
        return tax;
    }

    public void setTax(int tax) {
        this.tax = tax;
    }
}