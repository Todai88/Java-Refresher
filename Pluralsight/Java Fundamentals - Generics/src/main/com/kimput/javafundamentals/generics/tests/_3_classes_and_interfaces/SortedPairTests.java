package main.com.kimput.javafundamentals.generics.tests._3_classes_and_interfaces;

import main.com.kimput.javafundamentals.generics._3_classes_and_interfaces.after.SortedPair;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SortedPairTests {

    @Test
    public void shouldRetainOrderOfOrderedPair() {
        SortedPair<Integer> pair = new SortedPair<>(1, 2);
        assertEquals(1, pair.getFirst().intValue());
        assertEquals(2, pair.getSecond().intValue());
        assertEquals(2, pair.getSecond().intValue());
    }

    @Test
    public void shouldFlipOrderOfMisorderedPair() {
        SortedPair<Integer> pair = new SortedPair<>(2, 1);
        assertEquals(1, pair.getFirst().intValue());
        assertEquals(2, pair.getSecond().intValue());
    }
}
