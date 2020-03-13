public class TaxTile extends Tile {
    public TaxTile(String name){
        super(name);
        if(name == "Income Tax") setAction(10); // Remove $200
        if(name == "Luxury Tax") setAction(11); // Remove $100
    }
}