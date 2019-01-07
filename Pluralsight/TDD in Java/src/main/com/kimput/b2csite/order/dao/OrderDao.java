package main.com.kimput.b2csite.order.dao;

import main.com.kimput.b2csite.common.DataAccessException;
import main.com.kimput.b2csite.order.model.entity.OrderEntity;

import java.util.List;

public interface OrderDao {

    OrderEntity findById(long Id) throws DataAccessException;
    int insert(OrderEntity order) throws DataAccessException;

    List<OrderEntity> findOrdersByCustomer(long customerId) throws DataAccessException;
}
