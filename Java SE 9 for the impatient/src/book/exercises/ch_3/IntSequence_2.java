package src.book.exercises.ch_3;

public interface IntSequence_2 {
    static IntSequence_2 constant(int c) {
        return () -> c;
    }

    default boolean hasNext() {
        return true;
    }
    int next();
}
