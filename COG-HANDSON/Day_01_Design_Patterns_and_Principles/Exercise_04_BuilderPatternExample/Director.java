package day01.exercise04;

public class Director {
    private final HouseBuilder builder;
    public Director(HouseBuilder builder) { this.builder = builder; }
    public House construct() { return builder.buildFoundation().buildStructure().buildRoof().build(); }
}
