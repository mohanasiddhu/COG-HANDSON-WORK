package day02.exercise01;

public class Item {
    private final String sku;
    private final String name;
    private int quantity;

    public Item(String sku, String name, int quantity){this.sku=sku;this.name=name;this.quantity=quantity;}
    public String getSku(){return sku;} public String getName(){return name;} public int getQuantity(){return quantity;}
    public void adjust(int delta){ this.quantity += delta; }
    @Override public String toString(){ return "Item{"+sku+";"+name+";qty="+quantity+"}"; }
}
