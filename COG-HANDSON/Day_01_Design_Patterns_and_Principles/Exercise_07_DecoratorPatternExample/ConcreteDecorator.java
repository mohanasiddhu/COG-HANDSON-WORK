package day01.exercise07;

public class ConcreteDecorator extends Decorator {
    public ConcreteDecorator(Component component) { super(component); }
    @Override public String operation() { return component.operation() + "+Decorated"; }
}
