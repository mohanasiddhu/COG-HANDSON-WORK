package day01.exercise07;

public abstract class Decorator implements Component {
    protected final Component component;
    protected Decorator(Component component) { this.component = component; }
}
