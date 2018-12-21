package main.java.com.kimput._5_dependencies.before_refactor;

import java.util.Map;
import java.util.function.Function;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summingInt;

public class SalesAnalysisService {
    private SalesRepository repo;

    public SalesAnalysisService(SalesRepository repo) {
        this.repo = repo;
    }

    public Map<String, Integer> tallyProductSales() { return tallySalesBy(Sale::getProduct);}

    public Map<String, Integer> tallyStoreSales() { return tallySalesBy(Sale::getStore);}

    public Map<String, Integer> tallySalesBy (Function<Sale, String> classifier) {
        return repo.loadSales()
                .stream()
                .collect(groupingBy(classifier,
                        summingInt(Sale::getValue)));
    }
}
