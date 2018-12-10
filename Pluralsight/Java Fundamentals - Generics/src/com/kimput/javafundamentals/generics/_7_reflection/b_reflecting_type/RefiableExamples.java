package com.kimput.javafundamentals.generics._7_reflection.b_reflecting_type;

import java.util.ArrayList;
import java.util.List;

public class RefiableExamples {
    public static void main(String[] args) {
        System.out.println(int.class); // int
        System.out.println(String.class); // class java.lang.String

        List<?> wildcards = new ArrayList<>();
        System.out.println(wildcards.getClass()); // class java.util.ArrayList

        List raw = new ArrayList();
        System.out.println(raw.getClass()); // class java.util.ArrayList

        System.out.println(raw.getClass() == wildcards.getClass()); // true

        System.out.println(int[].class); // class [I
        System.out.println(List[].class); // class [Ljava.util.List;
    }
}
