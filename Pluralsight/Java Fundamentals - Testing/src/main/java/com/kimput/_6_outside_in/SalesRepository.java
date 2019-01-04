package main.java.com.kimput._6_outside_in;

import au.com.bytecode.opencsv.CSVReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class SalesRepository {

    private final String fileLocation;
    private List<Sale> sales;

    public SalesRepository(String fileLocation) {
        this.fileLocation = fileLocation;
    }

    private int parseInt(String value) { return Integer.parseInt(value.trim()); }

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
                    sales.add(new Sale(store, number, pricePerItem));
                }
                return sales;
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }
        return sales;
    }
}
