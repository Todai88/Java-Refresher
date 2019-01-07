package main.com.kimput.b2csite.order.service.implementation;

import main.com.kimput.b2csite.common.ServiceException;
import main.com.kimput.b2csite.order.dao.OrderDao;
import main.com.kimput.b2csite.order.model.domain.OrderSummary;
import main.com.kimput.b2csite.order.model.transformer.OrderEntityToOrderSummaryTransformer;
import main.com.kimput.b2csite.order.service.OrderService;

import java.util.List;

public class OrderServiceImplementation implements OrderService {

    private OrderDao orderDao = null;
    private OrderEntityToOrderSummaryTransformer transformer = null;

    public void setOrderDao(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    public void setTransformer(OrderEntityToOrderSummaryTransformer transformer) {
        this.transformer = transformer;
    }

    @Override
    public List<OrderSummary> getOrderSummary(long customerId)
            throws ServiceException {
        return null;
    }

}
