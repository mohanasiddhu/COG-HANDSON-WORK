package day01.exercise05;

public class ConcretePrototype implements Prototype {
    private final String config;

    public ConcretePrototype(String config) { this.config = config; }

    @Override
    public Prototype clonePrototype() {
        return new ConcretePrototype(this.config);
    }

    @Override public String toString() { return "Prototype{config='"+config+"'}"; }
}
