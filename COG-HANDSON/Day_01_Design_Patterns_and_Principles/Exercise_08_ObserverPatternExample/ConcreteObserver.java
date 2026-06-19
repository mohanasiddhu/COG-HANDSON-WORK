package day01.exercise08;

public class ConcreteObserver implements Observer {
    private final String name;
    public ConcreteObserver(String name) { this.name = name; }
    @Override public void update(String event) { System.out.println(name + " received: " + event); }
}
