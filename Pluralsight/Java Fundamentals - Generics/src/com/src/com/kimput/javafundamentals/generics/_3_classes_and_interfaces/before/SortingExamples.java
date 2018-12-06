package src.com.kimput.javafundamentals.generics._3_classes_and_interfaces.before;

import src.com.kimput.javafundamentals.generics._3_classes_and_interfaces.after.AgeComparator;
import src.com.kimput.javafundamentals.generics._3_classes_and_interfaces.after.ReverseComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortingExamples {

    public static void main(String[] args) {
        Person donDraper = new Person("Don Draper", 89);
        Person peggyOlson = new Person("Peggy Olson", 65);
        Person bertCooper = new Person("Bert Cooper", 100);

        List<Person> madMen = new ArrayList<>();
        madMen.add(donDraper);
        madMen.add(peggyOlson);
        madMen.add(bertCooper);
        System.out.println(madMen);
        Collections.sort(madMen, new ReverseComparator<>(new AgeComparator()));
        System.out.println(madMen);
    }

    public static <T> Object min(List<T> values, Comparator<T> comparator) {
        if (values.isEmpty()) {
            throw new IllegalArgumentException("List is empty, cannot find minimum");
        }
        T lowestElement = values.get(0);
        for (int i = 1; i < values.size(); i++) {
            final T element = values.get(i);
            if (comparator.compare(element, lowestElement) < 0) {
                lowestElement = element;
            }
        }
        return lowestElement;
    }
}
