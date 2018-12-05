package com.kimput.javafundamentals.generics._2_collections;

import java.util.Objects;

public final class Person {

    private final String name;
    private final int age;

    public Person(String name, int age) {
        Objects.requireNonNull(name);

        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Person person = (Person) o;

        return age == person.age && name.equals(person.name);
    }

    @Override
    public int hashCode(){
        int result = this.name.hashCode();
        result = 31 * result + this.age;
        return result;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + this.name + '\'' +
                ", age=" + this.age +
                '}';
    }
}
