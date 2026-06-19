package day01.exercise07;

public class Main {
    public static void main(String[] args) {
        Component base = new ConcreteComponent();
        Component decorated = new ConcreteDecorator(base);
        System.out.println(decorated.operation());
    }
}
