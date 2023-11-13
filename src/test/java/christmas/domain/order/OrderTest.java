package christmas.domain.order;

import christmas.domain.menu.Menu;
import christmas.domain.menu.OrderMenu;
import christmas.domain.menu.MenuType;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class OrderTest {
    private static final Menu menu1 = Menu.of("메뉴1", 5000, MenuType.MAIN);
    private static final OrderMenu menu2 = new OrderMenu(Menu.of("메뉴2", 5000, MenuType.MAIN), 2);
    private static final OrderMenu menu3 = new OrderMenu(Menu.of("메뉴3", 5000, MenuType.MAIN), 3);

    @Test
    void getOrderPrice_메서드는_총_주문금액을_구한다() {
        //given
        Order order = new Order(List.of(menu2, menu3));
        //when
        Integer orderPrice = order.getOrderPrice();
        //then
        assertThat(orderPrice).isEqualTo(25000);
    }

    @ParameterizedTest
    @CsvSource(value = {"1, false", "2, true"})
    void canApplyEvent_메서드는_이벤트_적용이_가능한지_판별한다(int menuCount, boolean result) {
        //given
        Order order = new Order(List.of(new OrderMenu(menu1, menuCount)));
        //when
        boolean canApplyEvent = order.canApplyEvent();
        //then
        assertThat(canApplyEvent).isEqualTo(result);
    }

}
