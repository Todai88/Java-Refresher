package test.java.com.kimput._6_outside_in;

import main.java.com.kimput._6_outside_in.Sale;
import main.java.com.kimput._6_outside_in.SalesRepository;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;


public class SalesRepositoryTest {

    @Test
    public void shouldLoadSampleData() {
        var repository = new SalesRepository("/example-sales.csv");
        final List<Sale> sales = repository.loadSales();
        // London, 2, 30
        assertThat(sales, hasItem(allOf(
                hasProperty("store", equalTo("London")),
                hasProperty("number", equalTo(2)),
                hasProperty("pricePerItem", equalTo(30))
        )));
    }
}
