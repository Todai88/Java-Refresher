package main.java.com.kimput.javafundamentals.generics._7_reflection.a_class_literals;

public class Main {
    public static void main(String[] args) {
        Injector injector = new Injector().with("Hello World");

        Logger logger = (Logger) injector.newInstance(Logger.class);
        logger.log();
    }
}
