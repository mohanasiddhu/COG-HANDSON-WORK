package day01.exercise10;

public class Main {
    public static void main(String[] args) {
        Receiver r = new Receiver();
        Invoker inv = new Invoker();
        inv.invoke(new ConcreteCommand(r, "Task-1"));
        inv.invoke(new ConcreteCommand(r, "Task-2"));
    }
}
