package day01.exercise01;

public class Main {
    public static void main(String[] args) {
        Singleton a = Singleton.getInstance();
        Singleton b = Singleton.getInstance();
        System.out.println("Singleton A ID: " + a.getId());
        System.out.println("Singleton B ID: " + b.getId());
        System.out.println("Same instance: " + (a == b));
    }
}
