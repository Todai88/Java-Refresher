package test.java.com.kimput._6_outside_in;

import main.java.com.kimput._6_outside_in.ApplicationRunner;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertThat;

public class SalesreportSystemTest {

    @Test
    public void shouldPrintStoreReportForSampleData() {
        var runner = new ApplicationRunner();
        String report = runner.run("example-sales.csv");

        assertThat(report, containsString("- London       -    235 -"));
    }
}
