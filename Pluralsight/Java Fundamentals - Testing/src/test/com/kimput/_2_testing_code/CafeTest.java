package test.com.kimput._2_testing_code;

import main.com.kimput.testing._2_testing_code.Cafe;
import main.com.kimput.testing._2_testing_code.Coffee;
import main.com.kimput.testing._2_testing_code.CoffeeType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CafeTest {

    @Test
    public void canBrewEspress() {
        Cafe cafe = new Cafe();
        cafe.restockBeans(7);
        Coffee coffee = cafe.brew(CoffeeType.Espresso);
        // it is an espresso
        // no milk
        // enough coffe
        Assertions.assertEquals(CoffeeType.Espresso, coffee.getType());
        Assertions.assertEquals(0, coffee.getMilk());
        Assertions.assertEquals(7, coffee.getBeans());
    }
}
