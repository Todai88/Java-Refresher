package main.com.kimput.b2csite.order.service;

import main.com.kimput.b2csite.common.ServiceException;
import main.com.kimput.b2csite.order.model.domain.OrderSummary;

import java.util.List;

public interface OrderService {
    List<OrderSummary> getOrderSummary(long customerId) throws ServiceException;
    String openNewOrder(long customerId) throws ServiceException;
}
