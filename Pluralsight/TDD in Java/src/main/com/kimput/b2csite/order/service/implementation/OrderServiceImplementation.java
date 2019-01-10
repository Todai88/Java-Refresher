package main.com.kimput.b2csite.order.service.implementation;

import main.com.kimput.b2csite.common.DataAccessException;
import main.com.kimput.b2csite.common.ServiceException;
import main.com.kimput.b2csite.order.dao.OrderDao;
import main.com.kimput.b2csite.order.model.domain.OrderSummary;
import main.com.kimput.b2csite.order.model.entity.OrderEntity;
import main.com.kimput.b2csite.order.model.transformer.OrderEntityToOrderSummaryTransformer;
import main.com.kimput.b2csite.order.service.OrderService;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

public class OrderServiceImplementation implements OrderService {

    private OrderDao orderDao = null;
    private OrderEntityToOrderSummaryTransformer transformer = null;
    private final int MAX_INSERT_ATTEMPT = 10;

    public void setOrderDao(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    public void setTransformer(OrderEntityToOrderSummaryTransformer transformer) {
        this.transformer = transformer;
    }

    @Override
    public List<OrderSummary> getOrderSummary(long customerId)
            throws ServiceException {
        // Goal - interact with the dao to gather entities and
        // Create summary domain objects
        var resultList = new LinkedList<OrderSummary>();
        try {
            var orderEntityList = this.orderDao
                    .findOrdersByCustomer(customerId);
            for (OrderEntity currentEntity : orderEntityList) {
                var orderSummary = this.transformer
                        .transform(currentEntity);
                resultList.add(orderSummary);
            }
        } catch  (DataAccessException e ) {
            throw new ServiceException("Data access error occurred", e);
        }
        return resultList;
    }

    @Override
    public String openNewOrder(long customerId) throws ServiceException {
        var newOrderEntity = new OrderEntity();
        newOrderEntity.setCustomerId(customerId);
        newOrderEntity.setOrderNumber(UUID.randomUUID().toString());

        boolean insertSuccessful = false;
        int insertAttempt = 1;
        while (!insertSuccessful && insertAttempt <= MAX_INSERT_ATTEMPT) {
            try {
                int resultValue = orderDao.insert(newOrderEntity);
                if (resultValue == 1) {
                    insertSuccessful = true;
                } else {
                    ++insertAttempt;
                }
            } catch (DataAccessException e) {
                // Log error
                ++insertAttempt;
            }
        }
        if (!insertSuccessful) {
            throw new ServiceException("Data access error prevented creation of order");
        }
        return newOrderEntity.getOrderNumber();
    }

}
