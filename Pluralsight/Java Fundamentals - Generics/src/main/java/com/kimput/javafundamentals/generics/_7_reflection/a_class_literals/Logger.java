package main.java.com.kimput.javafundamentals.generics._7_reflection.a_class_literals;

public class Logger {
    private String value;

    public Logger(String value) {
        this.value = value;
    }

    public  void log() { System.out.println(this.value); }
}
