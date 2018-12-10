package src.book.tests.ch_3;

import org.junit.jupiter.api.Test;
import src.book.exercises.ch_3.IntSequence_2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Ch3_5 {
    @Test
    public void testConstantIntStream() {
        final var value = 1;
        var sequence = IntSequence_2.constant(value);
        for (var i = 0; i < 20; i++) {
            assertTrue(sequence.hasNext());
            assertEquals(value, sequence.next());
        }
    }
}
