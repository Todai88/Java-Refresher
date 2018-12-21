package test.java.com.kimput._4_tdd;

import main.java.com.kimput._4_tdd.WordWrap;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordWrapTest {

    public static final int LINE_LENGTH = 5;
    // a method that breaks words on specified space with new line, like a word processor would

    @Test
    public void lineShouldWrapIfOverLineLength() {
        var result = WordWrap.wrap("The Sleepy", LINE_LENGTH);
        assertEquals("The S\nleepy", result);
    }

    @Test
    public void shorLinesShouldNotWrap() {
        var result = WordWrap.wrap("The", LINE_LENGTH);
        assertEquals("The", result);
    }

    @Test
    public void longerLineShouldWrapTwice() {
        var result = WordWrap.wrap("The Sleepy Brow", LINE_LENGTH);
        assertEquals("The S\nleepy\n Brow", result);
    }

    @Test
    public void evenLongerLinesShouldWrapThrice() {
        var result = WordWrap.wrap("The Sleepy Brown Fox", LINE_LENGTH);
        assertEquals("The S\nleepy\n Brow\nn Fox", result);
    }

    @Test
    public void longLinesDontHaveTobeAMultipleOfLineLength() {
        var result = WordWrap.wrap("The Sleepy Brown Fox.", LINE_LENGTH);
        assertEquals("The S\nleepy\n Brow\nn Fox\n.", result);
    }
}
