package day01.exercise04;

public class House {
    private final String foundation;
    private final String structure;
    private final String roof;

    public House(String foundation, String structure, String roof) {
        this.foundation = foundation;
        this.structure = structure;
        this.roof = roof;
    }

    @Override
    public String toString() {
        return "House{foundation='"+foundation+"', structure='"+structure+"', roof='"+roof+"'}";
    }
}
