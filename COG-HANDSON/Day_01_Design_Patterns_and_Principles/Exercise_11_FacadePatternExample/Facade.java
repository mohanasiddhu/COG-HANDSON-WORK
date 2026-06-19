package day01.exercise11;

public class Facade {
    private final SubsystemA a = new SubsystemA();
    private final SubsystemB b = new SubsystemB();
    public void doWork(){ System.out.println("Facade coordinating..."); a.opA(); b.opB(); }
}
