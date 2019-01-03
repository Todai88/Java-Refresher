package main.java.com.kimput._5_dependencies.guice;

import au.com.bytecode.opencsv.CSVReader;
import com.google.inject.Inject;
import com.google.inject.name.Named;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class CsvSalesRepository implements SalesRepository {

    private final String fileLocation;
    private PrintStream error;
    private List<Sale> sales;

    @Inject
    public CsvSalesRepository(@Named("fileLocation") String fileLocation) {
        this.fileLocation = fileLocation;
        error = System.out;
    }

    public void setError(PrintStream error) {
        this.error = error;
    }

    private int parseInt(String value) { return Integer.parseInt(value.trim()); }

    @Override
    public List<Sale> loadSales() {
        if (sales == null) {
            sales = new ArrayList<>();
            try (CSVReader reader = new CSVReader(new InputStreamReader(this.getClass().getResourceAsStream(fileLocation)))) {
                String[] nextLine;
                while ((nextLine = reader.readNext()) != null) {
                    String product = nextLine[0].trim();
                    String store = nextLine[1].trim();
                    int number = parseInt(nextLine[2]);
                    int pricePerItem = parseInt(nextLine[3]);
                    sales.add(new Sale(product, store, number, pricePerItem));
                }
                return sales;
            } catch (IOException e) {
                e.printStackTrace(error);
                return null;
            }
        }
        return sales;
    }
}
