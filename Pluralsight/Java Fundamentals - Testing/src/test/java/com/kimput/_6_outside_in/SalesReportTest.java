package test.java.com.kimput._6_outside_in;

import main.java.com.kimput._6_outside_in.SalesAnalyser;
import main.java.com.kimput._6_outside_in.SalesReport;
import org.junit.jupiter.api.Test;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class SalesReportTest {
    private static final int TALLY = 235;
    private static final String CITY = "LONDON";
    private PrintStream mockOut = mock(PrintStream.class);
    private SalesAnalyser mockAnalyser = mock(SalesAnalyser.class);

    SalesReport report = new SalesReport(mockAnalyser, mockOut);

    @Test
    public void shouldPrintCityTallies() {
        // GIVEN
        Map<String, Integer> cityTallies = new HashMap<>();
        cityTallies.put(CITY, TALLY);
        when(mockAnalyser.tallyCitySales()).thenReturn(cityTallies);
        // WHEN

        report.run();

        // THEN
        verify(mockOut).printf(anyString(), eq(CITY), eq(TALLY));
    }
}
