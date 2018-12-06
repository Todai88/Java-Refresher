package src.com.kimput.javafundamentals.generics._3_classes_and_interfaces.after;


import src.com.kimput.javafundamentals.generics._3_classes_and_interfaces.before.Person;

import java.util.Comparator;

public class AgeComparator implements Comparator<Person> {

    @Override
    public int compare(final Person left, final Person right) {
        return Integer.compare(left.getAge(), right.getAge());
    }
}
