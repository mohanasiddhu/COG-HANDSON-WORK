package day01.exercise05;

public class Main {
    public static void main(String[] args) {
        ConcretePrototype original = new ConcretePrototype("base-config");
        Prototype copy = original.clonePrototype();
        System.out.println(original);
        System.out.println(copy);
    }
}
