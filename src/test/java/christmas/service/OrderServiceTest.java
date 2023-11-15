package christmas.service;

import christmas.domain.menu.Menu;
import christmas.domain.menu.MenuType;
import christmas.domain.order.Order;
import christmas.domain.order.OrderMenu;
import christmas.dto.MenuAmountDto;
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

    @Test
    void convertToMenuAmountDtos_메서드는_Order_정보를_주문정보를_출력하기_위한_여러개의_MenuAmountDto_로_변환한다() {
        //given
        OrderMenu orderMenu = new OrderMenu(Menu.of("타파스", 10000, MenuType.MAIN), 1);
        Order order = new Order(List.of(orderMenu));
        //when
        List<MenuAmountDto> menuAmountDtos = orderService.convertToMenuAmountDtos(order);
        //then
        Assertions.assertThat(menuAmountDtos).hasSize(1);

        MenuAmountDto menuAmountDto1 = menuAmountDtos.get(0);
        Assertions.assertThat(menuAmountDto1.getMenuName()).isEqualTo("타파스");
        Assertions.assertThat(menuAmountDto1.getAmount()).isEqualTo(1);
    }

    private OrderDto provideOrderDto() {
        MenuAmountDto menuWithAmountDto1 = new MenuAmountDto("타파스", 1);
        MenuAmountDto menuWithAmountDto2 = new MenuAmountDto("초코케이크", 2);
        return new OrderDto(List.of(menuWithAmountDto1, menuWithAmountDto2));
    }
}
