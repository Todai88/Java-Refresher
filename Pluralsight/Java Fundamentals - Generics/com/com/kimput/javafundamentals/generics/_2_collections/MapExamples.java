package com.kimput.javafundamentals.generics._2_collections;

import java.util.HashMap;
import java.util.Map;

public class MapExamples {
    public static void main(String[] args) {
        com.kimput.javafundamentals.generics._2_collections.Person donDraper = new com.kimput.javafundamentals.generics._2_collections.Person("Don Draper", 89);
        com.kimput.javafundamentals.generics._2_collections.Person peggyOlson = new com.kimput.javafundamentals.generics._2_collections.Person("Peggy Olson", 65);
        com.kimput.javafundamentals.generics._2_collections.Person bertCooper = new com.kimput.javafundamentals.generics._2_collections.Person("Bert Cooper", 100);

        Map<String, com.kimput.javafundamentals.generics._2_collections.Person> madMen = new HashMap<>();

        madMen.put(donDraper.getName(), donDraper);
        madMen.put(peggyOlson.getName(), peggyOlson);
        madMen.put(bertCooper.getName(), bertCooper);

        for (Map.Entry<String, com.kimput.javafundamentals.generics._2_collections.Person> entry: madMen.entrySet()) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
    }
}
