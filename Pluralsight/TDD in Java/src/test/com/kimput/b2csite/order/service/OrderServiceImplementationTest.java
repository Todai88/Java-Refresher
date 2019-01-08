package test.com.kimput.b2csite.order.service;

import main.com.kimput.b2csite.order.dao.OrderDao;
import main.com.kimput.b2csite.order.model.domain.OrderSummary;
import main.com.kimput.b2csite.order.model.entity.OrderEntity;
import main.com.kimput.b2csite.order.model.transformer.OrderEntityToOrderSummaryTransformer;
import main.com.kimput.b2csite.order.service.implementation.OrderServiceImplementation;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsSame.sameInstance;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class OrderServiceImplementationTest {

    private OrderServiceImplementation serviceImplementation;
    private final static int CUSTOMER_ID = 1;
    private OrderDao mockOrderDao;
    private OrderEntityToOrderSummaryTransformer mockTransformer;
    @Before
    public void init() {
            serviceImplementation = new OrderServiceImplementation();
            mockOrderDao = mock(OrderDao.class);
            mockTransformer = mock(OrderEntityToOrderSummaryTransformer.class);
    }

    @Test
    public void givenNewOrderServiceImplementation_whenTestingSize_shouldReturnOneOrderSummary() throws Exception {
        // GIVEN
        var entityFixture = new OrderEntity();
        List<OrderEntity> entityListFixture = new LinkedList<>();
        entityListFixture.add(entityFixture);

        serviceImplementation.setOrderDao(mockOrderDao);
        serviceImplementation.setTransformer(mockTransformer);

        when(mockOrderDao.findOrdersByCustomer(CUSTOMER_ID))
                .thenReturn(entityListFixture);

        var orderSummaryFixture = new OrderSummary();
        when(mockTransformer.transform(entityFixture))
                .thenReturn(orderSummaryFixture);

        // WHEN
        var actual = serviceImplementation.getOrderSummary(CUSTOMER_ID);

        // THEN
        assertNotNull(actual);
        assertThat(1, is(actual.size()));
        assertThat(orderSummaryFixture, sameInstance(actual.get(0)));
    }
}
