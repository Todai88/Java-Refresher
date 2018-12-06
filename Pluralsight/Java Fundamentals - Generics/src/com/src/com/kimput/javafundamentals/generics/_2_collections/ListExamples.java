package src.com.kimput.javafundamentals.generics._2_collections;

import java.util.ArrayList;
import java.util.List;

public class ListExamples {

    public static void main(String[] args) {
        Person donDraper = new Person("Don Draper", 89);
        Person peggyOlson = new Person("Peggy Olson", 65);

        List<Person> madMen = new ArrayList<>();
        madMen.add(donDraper);
        madMen.add(peggyOlson);

        System.out.println(madMen);
        for (Person person : madMen) {
            System.out.println(person);
        }
    }
}
