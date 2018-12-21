package main.java.com.kimput.testing._2_testing_code;

public final class Cafe {
    private int beansInstock = 0;
    private int milkInStock = 0;

    public Coffee brew (CoffeeType coffeeType) { return brew(coffeeType, 1); }

    public Coffee brew (CoffeeType coffeeType, int quantity) {
        requirePositive(quantity);
        int requiredBeans = coffeeType.getRequiredBeans() * quantity;
        int requiredMilk = coffeeType.getRequiredMilk() * quantity;
        if ( requiredBeans > this.beansInstock || requiredMilk > this.milkInStock) {
            throw new IllegalStateException("Insufficient beans or milk");
        }
        this.beansInstock -= requiredBeans;
        this.milkInStock  -= requiredMilk;

        return new Coffee(coffeeType, requiredBeans, requiredMilk);
    }

    public void restockBeans(int weightInGrams) {
        requirePositive(weightInGrams);
        this.beansInstock += weightInGrams;
    }

    private void restockMilk(int weightInGrams) {
        requirePositive(weightInGrams);
        this.milkInStock += weightInGrams;
    }

    private void requirePositive(int value) {
        if (value < 1) {
            throw new IllegalArgumentException();
        }
    }

    public int getBeansInstock() {
        return this.beansInstock;
    }

    public int getMilkInStock() {
        return this.milkInStock;
    }
}
