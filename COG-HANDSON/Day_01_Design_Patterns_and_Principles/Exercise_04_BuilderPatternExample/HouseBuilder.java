package day01.exercise04;

public interface HouseBuilder {
    HouseBuilder buildFoundation();
    HouseBuilder buildStructure();
    HouseBuilder buildRoof();
    House build();
}
