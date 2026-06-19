package day01.exercise10;

public class ConcreteCommand implements Command {
    private final Receiver receiver;
    private final String payload;
    public ConcreteCommand(Receiver r, String payload){this.receiver=r;this.payload=payload;}
    @Override public void execute() { receiver.action(payload); }
}
