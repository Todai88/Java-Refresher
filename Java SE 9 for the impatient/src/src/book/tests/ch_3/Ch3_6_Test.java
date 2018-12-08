package src.book.tests.ch_3;

import org.testng.annotations.Test;
import src.book.exercises.ch_3.Ch3_6;

import static org.junit.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Ch3_6_Test {
    @Test
    public void testSquareSequence(){
    var sequence = new Ch3_6.SquareSequence();
    for (var i = 1; i <= 100; i++) {
            assertTrue(sequence.hasNext());
            assertEquals(Integer.toString(i * i), sequence.next().toString());
        }
    assertTrue(sequence.hasNext());
    }
}
