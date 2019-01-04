package test.java.com.kimput._6_outside_in;

import main.java.com.kimput._6_outside_in.Sale;
import main.java.com.kimput._6_outside_in.SalesAnalyser;
import main.java.com.kimput._6_outside_in.SalesRepository;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.mockito.Mockito.*;
import static org.mockito.internal.verification.VerificationModeFactory.times;
import static org.testng.AssertJUnit.assertEquals;

public class SalesAnalyserTest {
    private static final List<Sale> exampleSales = Arrays.asList(
            new Sale("Cardiff", 10, 2),
            new Sale("Cardiff", 3, 5),
            new Sale("Cardiff", 6, 20),
            new Sale("London", 5, 7)
    );

    private static final Map<String, Integer> expectedStoreSales = new HashMap<>();
    static {
        expectedStoreSales.put("Cardiff", 155);
        expectedStoreSales.put("London", 35);
    }

    @Test
    public void shouldAggregateStoreSales() {
        // GIVEN
        var mockRepository = mock(SalesRepository.class);
        when(mockRepository.loadSales()).thenReturn(exampleSales);

        var analyser = new SalesAnalyser(mockRepository);
        // WHEN
        Map<String, Integer> storeSales = analyser.tallyCitySales();

        // THEN
        assertEquals("Calculated wrong store sales", expectedStoreSales, storeSales);
        verify(mockRepository, times(1)).loadSales();
    }
}
