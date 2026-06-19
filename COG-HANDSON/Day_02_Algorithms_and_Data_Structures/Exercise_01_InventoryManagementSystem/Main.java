package day02.exercise01;

public class Main {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        inventory.add(new Item("SKU1","Widget",100));
        inventory.add(new Item("SKU2","Gadget",50));
        System.out.println(inventory.find("SKU1"));
        inventory.find("SKU1").adjust(-5);
        System.out.println("After sale: " + inventory.find("SKU1"));
        inventory.remove("SKU2");
        System.out.println("Inventory snapshot: " + inventory.snapshot());
    }
}
