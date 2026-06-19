package day01.exercise04;

public class ConcreteHouseBuilder implements HouseBuilder {
    private String foundation;
    private String structure;
    private String roof;

    @Override public HouseBuilder buildFoundation() { foundation = "Concrete foundation"; return this; }
    @Override public HouseBuilder buildStructure() { structure = "Concrete structure"; return this; }
    @Override public HouseBuilder buildRoof() { roof = "Concrete roof"; return this; }
    @Override public House build() { return new House(foundation, structure, roof); }
}
