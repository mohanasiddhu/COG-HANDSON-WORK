package day01.exercise02;

public abstract class Creator {
    public abstract Product factoryMethod(String type);
    public String doSomething(String type) {
        Product p = factoryMethod(type);
        return "Created: " + p.getName();
    }
}
