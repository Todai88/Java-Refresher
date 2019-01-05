package main.com.kimput.b2csite.order.model.transformer;

import main.com.kimput.b2csite.order.model.domain.OrderSummary;
import main.com.kimput.b2csite.order.model.entity.OrderEntity;

import java.math.BigDecimal;

public class OrderEntityToOrderSummaryTransformer {

    public OrderSummary transform(OrderEntity entity) {
        if (entity == null) {
            throw new IllegalArgumentException("entity cannot be null");
        }
        var orderSummaryResult = new OrderSummary();
        orderSummaryResult.setOrderNumber(entity.getOrderNumber());

        int itemCount = 0;
        var totalAmount = new BigDecimal(0);

        for (var orderItem : entity.getOrderItemList()) {
            itemCount += orderItem.getQuantity();
            var quantityBD = new BigDecimal(orderItem.getQuantity());
            var itemTotal = orderItem.getSellingPrice().multiply(quantityBD);
            totalAmount = totalAmount.add(itemTotal);
        }
        orderSummaryResult.setItemcount(itemCount);
        orderSummaryResult.setTotalAmount(totalAmount);
        return orderSummaryResult;
    }
}
