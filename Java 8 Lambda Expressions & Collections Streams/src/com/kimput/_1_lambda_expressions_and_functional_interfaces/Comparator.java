package com.kimput._1_lambda_expressions_and_functional_interfaces;

import java.util.function.Function;

@FunctionalInterface
public interface Comparator<T> {
    public int compare(T t1, T t2);

    public default Comparator<T> thenComparing(Comparator<T> cmp) {
        return (p1, p2) -> compare(p1, p2) == 0 ? cmp.compare(p1, p2) : compare(p1, p2);
    }

    public static Comparator<Person> comparing (Function<Person, Comparable> f) {
        return (p1, p2) -> f.apply(p1).compareTo(f.apply(p2));
    }
}
