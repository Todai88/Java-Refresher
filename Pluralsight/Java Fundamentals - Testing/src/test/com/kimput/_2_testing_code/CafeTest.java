package test.com.kimput._2_testing_code;

import main.com.kimput.testing._2_testing_code.Cafe;
import main.com.kimput.testing._2_testing_code.Coffee;
import main.com.kimput.testing._2_testing_code.CoffeeType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CafeTest {

    @Test
    public void canBrewEspress() {
        // GIVEN
        Cafe cafe = new Cafe();
        cafe.restockBeans(7);
        // WHEN
        Coffee coffee = cafe.brew(CoffeeType.Espresso);
        // THEN
        Assertions.assertEquals(CoffeeType.Espresso, coffee.getType());
        Assertions.assertEquals(0, coffee.getMilk());
        Assertions.assertEquals(7, coffee.getBeans());
    }

    @Test
    public void brewingEspressoConsumesBeans() {
        // GIVEN
        Cafe cafe = new Cafe();
        cafe.restockBeans(7);
        // WHEN
        Coffee coffee = cafe.brew(CoffeeType.Espresso);
        // THEN
        Assertions.assertEquals(0, cafe.getBeansInstock());
    }


    @Test
    public void brewingLatteRequiresMilk() {
        // GIVEN
        Cafe cafe = new Cafe();
        cafe.restockBeans(7);

        // THEN
        Assertions.assertThrows(IllegalStateException.class, () -> {
            cafe.brew(CoffeeType.Latte); // when
        });
    }
}
