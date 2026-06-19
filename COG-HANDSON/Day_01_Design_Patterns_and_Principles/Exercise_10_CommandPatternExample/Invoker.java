package day01.exercise10;

import java.util.ArrayList;
import java.util.List;

public class Invoker {
    private final List<Command> history = new ArrayList<>();
    public void invoke(Command cmd) { cmd.execute(); history.add(cmd); }
}
