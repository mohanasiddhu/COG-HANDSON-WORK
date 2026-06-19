package day01.exercise03;

public class LinuxFactory implements GUIFactory {
    @Override public Button createButton() { return new LinuxButton(); }
    @Override public Checkbox createCheckbox() { return new LinuxCheckbox(); }
}
