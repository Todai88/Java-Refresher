package main.com.kimput.b2csite.order.model.message;

public class ItemMessage {
    private String sku;
    private int quantity;

    public void setItemNumber(String sku) {
        this.sku = sku;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
