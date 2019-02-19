package main.com.kimput.b2csite.order.model.message;

import java.util.LinkedList;

public class OrderMessage {
    private String orderNumber;
    private LinkedList<ItemMessage> itemMessages;


    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public void setItems(LinkedList<ItemMessage> itemMessages) {
        this.itemMessages = itemMessages;
    }

    public LinkedList<ItemMessage> getItems() {
        return this.itemMessages;
    }
}
