package test.com.kimput.b2csite.order.service;

import main.com.kimput.b2csite.common.DataAccessException;
import main.com.kimput.b2csite.common.ServiceException;
import main.com.kimput.b2csite.order.dao.OrderDao;
import main.com.kimput.b2csite.order.model.domain.OrderSummary;
import main.com.kimput.b2csite.order.model.entity.OrderEntity;
import main.com.kimput.b2csite.order.model.transformer.OrderEntityToOrderSummaryTransformer;
import main.com.kimput.b2csite.order.service.implementation.OrderServiceImplementation;
import org.hamcrest.Matcher;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.LinkedList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsSame.sameInstance;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;

public class OrderServiceImplementationTest {

    private final static long CUSTOMER_ID = 1;

    private OrderServiceImplementation serviceImplementation;
    private @Mock OrderDao mockOrderDao;
    private @Mock OrderEntityToOrderSummaryTransformer mockTransformer;

    @Before
    public void init() {
            MockitoAnnotations.initMocks(this);

            this.serviceImplementation = new OrderServiceImplementation();
            this.serviceImplementation.setOrderDao(mockOrderDao);
            this.serviceImplementation.setTransformer(mockTransformer);
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

        // VERIFICATION
        verify(mockOrderDao).findOrdersByCustomer(CUSTOMER_ID);
        verify(mockTransformer).transform(entityFixture);

        // THEN
        assertNotNull(actual);
        assertThat(1, is(actual.size()));
        assertThat(orderSummaryFixture, sameInstance(actual.get(0)));
    }

    @Test
    public void givenACustomerId_whenTestingOpenNewOrder_ThenShouldReturnSuccessfulOrderNumber() throws Exception{
        // GIVEN
        when(mockOrderDao.insert(any(OrderEntity.class)))
            .thenThrow(new DataAccessException("First Ex")).thenReturn(1);

        // WHEN
        this.serviceImplementation.openNewOrder(CUSTOMER_ID);

        // THEN

        // VERIFY
        verify(mockOrderDao, times(2)).insert(any(OrderEntity.class));
    }

    @Test(expected= ServiceException.class)
    public void givenACustomerId_whenTestingOpenNewOrder_thenVerifyCalledTwiceAndReturnsExceptions () throws Exception{
        // GIVEN
        when(mockOrderDao.insert(any(OrderEntity.class)))
                .thenThrow(new DataAccessException("First Ex"))
                .thenThrow(new DataAccessException("Second Ex"));

        // WHEN
        try {
            this.serviceImplementation.openNewOrder(CUSTOMER_ID);
        } finally {
            // VERIFY
            verify(mockOrderDao, times(2))
                    .insert(any(OrderEntity.class));
        }
    }

    @Test
    public void givenACustomerId_whenTestingOpenNewOrder_thenAssertThatEntityIsNotNullAndFieldsAreCorrect() throws Exception {
        // SETUP
        when(mockOrderDao.insert(any(OrderEntity.class)))
                .thenReturn(1);

        // WHEN
        var orderNumber = this.serviceImplementation.openNewOrder(CUSTOMER_ID);

        // VERIFICATION
        var orderEntityCaptor = ArgumentCaptor.forClass(OrderEntity.class);
        verify(mockOrderDao).insert(orderEntityCaptor.capture());
        var capturedOrderEntity = orderEntityCaptor.getValue();

        // THEN
        assertNotNull(capturedOrderEntity);
        assertThat(CUSTOMER_ID, is(capturedOrderEntity.getCustomerId()));
        assertEquals(orderNumber, capturedOrderEntity.getOrderNumber());
    }

    public static Matcher<Long> is(long value) {
        return org.hamcrest.core.Is.is(Long.valueOf(value));
    }

    public static Matcher<Integer> is(int value) {
        return is(Integer.valueOf(value));
    }
}
