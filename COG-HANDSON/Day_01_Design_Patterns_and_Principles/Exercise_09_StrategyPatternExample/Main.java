package day01.exercise09;

public class Main {
    public static void main(String[] args) {
        Context ctx = new Context(new AddStrategy());
        System.out.println("Add: " + ctx.executeStrategy(3,4));
        ctx.setStrategy(new MultiplyStrategy());
        System.out.println("Multiply: " + ctx.executeStrategy(3,4));
    }
}
