package main.java.com.kimput._5_dependencies.guice;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class GuiceSalesReportRunner {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.err.println("You must provide a commandline argument specifying the file to analyse");
            System.exit(-1);
        }

        Injector injector = Guice.createInjector(new SalesModule(args[0]));
        var report = injector.getInstance(SalesReport.class);
        report.report();
    }
}
