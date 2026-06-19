package day01.exercise02;

public class ConcreteCreator extends Creator {
    @Override
    public Product factoryMethod(String type) {
        if ("A".equalsIgnoreCase(type)) return new ConcreteProductA();
        return new ConcreteProductB();
    }
}
