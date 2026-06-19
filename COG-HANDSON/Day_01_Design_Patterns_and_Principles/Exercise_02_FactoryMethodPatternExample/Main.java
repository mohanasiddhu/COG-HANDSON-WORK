package day01.exercise02;

public class Main {
    public static void main(String[] args) {
        Creator creator = new ConcreteCreator();
        System.out.println(creator.doSomething("A"));
        System.out.println(creator.doSomething("B"));
    }
}
