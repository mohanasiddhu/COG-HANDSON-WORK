package day01.exercise04;

public class Main {
    public static void main(String[] args) {
        HouseBuilder builder = new ConcreteHouseBuilder();
        Director director = new Director(builder);
        House house = director.construct();
        System.out.println(house);
    }
}
