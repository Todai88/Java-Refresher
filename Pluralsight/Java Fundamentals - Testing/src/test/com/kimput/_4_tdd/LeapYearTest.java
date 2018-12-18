package test.com.kimput._4_tdd;

import main.com.kimput.testing._4_tdd.LeapYear;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LeapYearTest {

    @Test
    public void leapYearsAreDivisibleByFour() {
        Assertions.assertTrue(LeapYear.isLeapYear(2016));
    }

    @Test
    public void normalYearsAreNotDivisibleByFour() {
        Assertions.assertFalse(LeapYear.isLeapYear(3));
    }

    @Test
    public void leapYearsAreNotDivisibleByOneHundred() {
        Assertions.assertFalse(LeapYear.isLeapYear(1900));
    }

    @Test
    public void leapYearsAreDivisibleByFourHundred() {
        Assertions.assertTrue(LeapYear.isLeapYear(1600));
    }
}
