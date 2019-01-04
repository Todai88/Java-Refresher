package main.java.com.kimput._6_outside_in;

import java.io.PrintStream;

public class SalesReport {
    private final SalesAnalyser analyser;
    private final PrintStream out;

    public SalesReport(SalesAnalyser analyser, PrintStream out) {
        this.analyser = analyser;
        this.out = out;
    }

    public void run() {
        // TODO: Print things out
       analyser.tallyCitySales()
               .forEach((String city, Integer tally) ->
                       out.printf("- %-15s - %6.6s -%n", city, tally));
    }
}
