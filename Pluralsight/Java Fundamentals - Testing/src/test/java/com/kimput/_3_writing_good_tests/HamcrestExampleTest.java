package test.com.kimput._3_writing_good_tests;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;

public class HamcrestExampleTest {

    @Test
    public void mapShouldContainValue() {
        Map<String, Integer> values = getValues();

        assertThat(values, Matchers.hasKey("B"));
    }

    private Map<String, Integer> getValues() {
        final HashMap<String, Integer> map = new HashMap<>();
        map.put("A", 1);
        map.put("b", 2);
        return map;
    }

    @Test
    public void listOrderingIsIrrelevant() {
        List<Integer> numbers = getNumbers();
        assertThat(numbers, Matchers.containsInAnyOrder(1, 2, 3, 4, 5));
    }

    private List<Integer> getNumbers() {
        return Arrays.asList(1, 2, 3, 5, 4);
    }
}
