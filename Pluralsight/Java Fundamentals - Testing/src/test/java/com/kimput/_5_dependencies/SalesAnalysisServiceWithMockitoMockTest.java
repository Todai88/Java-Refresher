package test.java.com.kimput._5_dependencies;

import main.java.com.kimput._5_dependencies.before_refactor.Sale;
import main.java.com.kimput._5_dependencies.before_refactor.SalesAnalysisService;
import main.java.com.kimput._5_dependencies.before_refactor.SalesRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SalesAnalysisServiceWithMockitoMockTest {

    private static final List<Sale> exampleSales = Arrays.asList(
            new Sale("Apples" , "Cardiff", 10, 2),
            new Sale("Oranges" , "Cardiff", 3, 5),
            new Sale("Bananas" , "Cardiff", 6, 20),
            new Sale("Oranges" , "London", 5, 7)
    );

    private static final Map<String, Integer> expectedStoreSales = new HashMap<>();

    static {
        expectedStoreSales.put("Cardiff", 155);
        expectedStoreSales.put("London", 35);
    }

    @Test
    public  void shouldAggregateStoreSales() {
        // GIVEN
        var mockRepo = Mockito.mock(SalesRepository.class);
        Mockito.when(mockRepo.loadSales()).thenReturn(exampleSales);
        var analysisService = new SalesAnalysisService(mockRepo);

        // WHEN
        var storeSales = analysisService.tallyStoreSales();

        // THEN
        assertEquals(expectedStoreSales, storeSales);
        Mockito.verify(mockRepo).loadSales();
    }
}
