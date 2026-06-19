package day01.exercise08;

public class Main {
    public static void main(String[] args) {
        Subject subject = new Subject();
        ConcreteObserver a = new ConcreteObserver("ObserverA");
        ConcreteObserver b = new ConcreteObserver("ObserverB");
        subject.register(a); subject.register(b);
        subject.notifyObservers("Event-1");
        subject.unregister(b);
        subject.notifyObservers("Event-2");
    }
}
