package test.com.kimput.b2csite.order.model.transformer;

import main.com.kimput.b2csite.order.model.entity.OrderEntity;
import main.com.kimput.b2csite.order.model.entity.OrderItemEntity;
import main.com.kimput.b2csite.order.model.transformer.OrderEntityToOrderSummaryTransformer;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.UUID;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.core.IsNull.nullValue;

public class OrderEntityToOrderSummaryTransformerTest {
    private OrderEntityToOrderSummaryTransformer target = null;
    private String orderNumberfixture;
    private OrderEntity orderEntityFixture;
    private OrderItemEntity itemFixture_1;

    @Before
    public void setup() {
        orderNumberfixture = UUID.randomUUID().toString();
        orderEntityFixture = new OrderEntity();
        itemFixture_1 = new OrderItemEntity();
        orderEntityFixture.setOrderItemList(new LinkedList<OrderItemEntity>());
        orderEntityFixture.setOrderNumber(orderNumberfixture);
        target = new OrderEntityToOrderSummaryTransformer();
    }

    @Test
    public void givenCorrectOrderEntity_whenTestingTransform_shouldBeSuccessful() {
        // Given
        itemFixture_1.setSellingPrice(new BigDecimal(10));
        itemFixture_1.setQuantity(3);

        orderEntityFixture.getOrderItemList().add(itemFixture_1);

        // When
        var actual = target.transform(orderEntityFixture);

        // Then
        assertThat(actual, is(not(nullValue())));
        assertThat(actual.getOrderNumber(), is(orderNumberfixture));
        assertThat(actual.getItemcount(), is(3));
        assertThat(actual.getTotalAmount(), equalTo(new BigDecimal(30)));
    }

    @Test(expected=IllegalArgumentException.class)
    public void givenNullInput_whenTestingTransform_shouldBeUnsuccessful() {
        target.transform(null);
    }

    @Test
    public void givenAnOrderEntityWithNoOrderItems_whenTestingTransform_shouldReturnEmptyOrderEntity() {
        // Given just the fixtures

        // When
        var actual = target.transform(orderEntityFixture);
        // Then
        assertThat(actual, is(not(nullValue())));
        assertThat(actual.getOrderNumber(), is(orderNumberfixture));
        assertThat(actual.getItemcount(), is(0));
        assertThat(actual.getTotalAmount(), equalTo(new BigDecimal(0)));
    }
}
