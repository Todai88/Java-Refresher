package main.java.com.kimput._6_outside_in;

import java.util.Map;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summingInt;

public class SalesAnalyser {
    private final SalesRepository repo;

    public SalesAnalyser(SalesRepository repo) {
        this.repo = repo;
    }

    public Map<String, Integer> tallyCitySales() {
        return repo.loadSales()
                .stream()
                .collect(groupingBy(Sale::getStore,
                         summingInt(Sale::getValue)));
    }
}
