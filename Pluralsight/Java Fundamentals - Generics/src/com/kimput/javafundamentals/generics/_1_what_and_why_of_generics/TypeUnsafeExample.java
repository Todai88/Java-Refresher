package com.kimput.javafundamentals.generics._1_what_and_why_of_generics;

/*
    Uses a type-specific (non-generic) CircularBuffer, which will break if anything but strings are used.
 */
public class TypeUnsafeExample {
    public static void main(String[] args) {
        CircularBuffer<String> buffer = new CircularBuffer(10);

        buffer.offer("a");
        buffer.offer("bc");
        buffer.offer("d");
        String value = concatenate(buffer);
    }

    private static String concatenate(CircularBuffer<String> buffer) {
        StringBuilder result = new StringBuilder();

        String value;

        while ((value = buffer.poll()) != null) {
            result.append(value);
        }

        return result.toString();
    }
}
