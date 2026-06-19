package day01.exercise06;

public class Main {
    public static void main(String[] args) {
        Target target = new Adapter(new Adaptee());
        System.out.println(target.request());
    }
}
