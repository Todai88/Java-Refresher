package com.kimput.javafundamentals.generics._5_wildcards.bounded;

public class Employee extends Person {
    public Employee(String name, int age) {
        super(name, age);
    }

    @Override
    public String toString() {
        return String.format("Employee{name='%s', age=%i}", getName(), getAge());
    }
}
