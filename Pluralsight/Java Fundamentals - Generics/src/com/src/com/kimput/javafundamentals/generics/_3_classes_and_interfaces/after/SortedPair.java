package src.com.kimput.javafundamentals.generics._3_classes_and_interfaces.after;

public class SortedPair<T extends Comparable<T>> {
    private final T first;
    private final T second;

    public T getFirst() {
        return first;
    }

    public T getSecond() {
        return second;
    }

    public SortedPair(T first, T second) {
        if(first.compareTo(second) < 0)
        {
            this.first = first;
            this.second = second;
        } else {
            this.first = second;
            this.second = first;
        }
    }
}
