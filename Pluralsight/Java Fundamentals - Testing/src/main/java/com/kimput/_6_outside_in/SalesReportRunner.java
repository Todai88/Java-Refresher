package main.java.com.kimput._6_outside_in;

import java.io.PrintStream;

public class SalesReportRunner {

    private final PrintStream out;

    public SalesReportRunner(final PrintStream out) {
        this.out = out;
    }

    public static void main(String[] args) {
        String fileLocation = args[0];
        new SalesReportRunner(System.out).run(fileLocation);
    }

    public void run(String fileLocation) {
        var repo = new SalesRepository(fileLocation);
        var analyser = new SalesAnalyser(repo);
        var report = new SalesReport(analyser, out);

        report.run();
    }
}
