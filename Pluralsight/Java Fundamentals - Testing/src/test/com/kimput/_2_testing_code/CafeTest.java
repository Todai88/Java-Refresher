package test.com.kimput._2_testing_code;

import main.com.kimput.testing._2_testing_code.Cafe;
import main.com.kimput.testing._2_testing_code.Coffee;
import main.com.kimput.testing._2_testing_code.CoffeeType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static main.com.kimput.testing._2_testing_code.CoffeeType.Espresso;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasProperty;

public class CafeTest {

    private final int ESPRESSO_BEANS = 7;
    private final int NO_MILK = 0;

    private Cafe cafe;

    @BeforeEach
    public void before() {
        cafe = new Cafe();
    }

    @Test
    public void canBrewEspress() {
        // GIVEN
        cafe.restockBeans(ESPRESSO_BEANS);
        // WHEN
        Coffee coffee = cafe.brew(Espresso);
        // THEN

        assertThat(coffee, hasProperty("beans", equalTo(ESPRESSO_BEANS)));
        Assertions.assertEquals(ESPRESSO_BEANS, coffee.getBeans(),"Wrong number of beans");
        Assertions.assertEquals(NO_MILK, coffee.getMilk(), "Wrong amount of milk");
        Assertions.assertEquals(Espresso, coffee.getType(), "Wrong type of coffee");

    }

    @Test
    public void brewingEspressoConsumesBeans() {
        // GIVEN
        cafe.restockBeans(ESPRESSO_BEANS);
        // WHEN
        Coffee coffee = cafe.brew(Espresso);
        // THEN
        Assertions.assertEquals(NO_MILK, cafe.getBeansInstock());
    }


    @Test
    public void brewingLatteRequiresMilk() {
        // GIVEN
        cafe.restockBeans(ESPRESSO_BEANS);

        // THEN
        Assertions.assertThrows(IllegalStateException.class, () -> {
            cafe.brew(CoffeeType.Latte); // when
        });
    }
}
