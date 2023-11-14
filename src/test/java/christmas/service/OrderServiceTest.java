package christmas.service;

import christmas.domain.order.Order;
import christmas.dto.MenuWithAmountDto;
import christmas.dto.OrderDto;
import christmas.repository.MenuRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class OrderServiceTest {
    private OrderService orderService;

    @BeforeEach
    void setInit() {
        MenuRepository menuRepository = new MenuRepository();
        orderService = new OrderService(menuRepository);
    }

    @Test
    void createOrder_메서드는_OrderDto_를_이용해_Order_를_만들어_반환한다() {
        //given
        OrderDto orderDto = provideOrderDto();
        //when
        Order order = orderService.createOrder(orderDto);
        //then
        Assertions.assertThat(order.getOrderMenus().size()).isEqualTo(2);
        Assertions.assertThat(order.getOrderPrice()).isEqualTo(35500);
    }

    private OrderDto provideOrderDto(){
        MenuWithAmountDto menuWithAmountDto1 = new MenuWithAmountDto("타파스", 1);
        MenuWithAmountDto menuWithAmountDto2 = new MenuWithAmountDto("초코케이크", 2);
        return new OrderDto(List.of(menuWithAmountDto1, menuWithAmountDto2));
    }
}
