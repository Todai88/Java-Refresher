package main.java.com.kimput._6_outside_in;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

public class ApplicationRunner {
    public String run(final String inputFile) {
        ByteArrayOutputStream dummyOutput = new ByteArrayOutputStream();
        var app = new SalesReportRunner(new PrintStream(dummyOutput));
        app.run(inputFile);

        try {
            return dummyOutput.toString("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }

    }
}
