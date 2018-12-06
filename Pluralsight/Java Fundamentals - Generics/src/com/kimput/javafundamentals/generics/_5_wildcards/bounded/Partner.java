package com.kimput.javafundamentals.generics._5_wildcards.bounded;

public class Partner extends Person {

    public Partner(String name, int age) {
        super(name, age);
    }

    @Override
    public String toString() {
        return String.format("Partner{name='%s', age=%i}", getName(), getAge());
    }
}
