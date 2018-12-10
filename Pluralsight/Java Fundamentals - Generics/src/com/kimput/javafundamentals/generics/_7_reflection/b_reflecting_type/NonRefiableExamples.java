package com.kimput.javafundamentals.generics._7_reflection.b_reflecting_type;

import java.util.ArrayList;
import java.util.List;

public class NonRefiableExamples<T> {
    public static void main(String[] args) {
        new NonRefiableExamples<String>().main();
    }
    private void main() {
        List<String> strings = new ArrayList<>();
        List<Integer> integers = new ArrayList<>();

        System.out.println(strings.getClass()); // class java.util.ArrayList
        System.out.println(integers.getClass()); // class java.util.ArrayList
        System.out.println(strings.getClass() == integers.getClass()); // true (this could raise an exception at runtime!)

        List<? extends Number> numbers = new ArrayList<>();
        System.out.println(numbers.getClass()); // class java.util.ArrayList
        System.out.println(integers.getClass() == numbers.getClass()); // true (again, this risks raising exceptions!)
    }
}
