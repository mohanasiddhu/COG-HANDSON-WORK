package day01.exercise03;

public class Main {
    public static void main(String[] args) {
        GUIFactory factory = new WindowsFactory();
        factory.createButton().paint();
        factory.createCheckbox().paint();

        factory = new LinuxFactory();
        factory.createButton().paint();
        factory.createCheckbox().paint();
    }
}
