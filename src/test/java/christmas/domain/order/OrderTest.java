package christmas.domain.order;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static christmas.data.DummyData.provideOrderData;

public class OrderTest {

    @Test
    void getOrderPrice_메서드는_총_주문금액을_구한다() {
        //given
        Order order = provideOrderData();
        //when
        Integer orderPrice = order.getOrderPrice();
        //then
        Assertions.assertThat(orderPrice).isEqualTo(300000);
    }
}
