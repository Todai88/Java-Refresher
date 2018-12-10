package src.book.tests.ch_3;

import org.junit.jupiter.api.Test;
import src.book.exercises.ch_3.IntSequence;

import static org.junit.jupiter.api.Assertions.*;

public class Ch3_4 {

    @Test
    public void testIntStream() {
        var data = new int[]{9, 8, 7, 5, 5, 1, 3, 5};
        var seq = IntSequence.of(data);
        for (var val : data) {
            assertTrue(seq.hasNext());
            assertEquals(val, seq.next());
        }
    }

    @Test
    public void testExceedIntStream() {
        var seq = IntSequence.of();
        assertFalse(seq.hasNext());
        assertEquals(0, seq.next());
        assertEquals(0, seq.next());
    }
}
