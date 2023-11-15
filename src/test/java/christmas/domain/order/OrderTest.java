package christmas.domain.order;

import christmas.domain.menu.Menu;
import christmas.domain.menu.MenuType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class OrderTest {

    private Menu menu1;
    private OrderMenu menu2;
    private OrderMenu menu3;

    @BeforeEach
    void setInit() {
        menu1 = Menu.of("메뉴1", 5000, MenuType.MAIN);
        menu2 = new OrderMenu(Menu.of("메뉴2", 5000, MenuType.MAIN), 2);
        menu3 = new OrderMenu(Menu.of("메뉴3", 5000, MenuType.MAIN), 3);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 21})
    void 주문생성시_주문메뉴_갯수가_1부터_20_사이가_아닌경우_예외를_발생한다(int size) {
        //given
        OrderMenu orderMenu = new OrderMenu(Menu.of("메뉴", 5000, MenuType.MAIN), size);
        //when, then
        assertThatThrownBy(() -> new Order(List.of(orderMenu)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 주문생성시_주문메뉴가_모두_음료수인_경우_예외를_발생한다() {
        //given
        OrderMenu drinking = new OrderMenu(Menu.of("음료", 5000, MenuType.DRINKING), 1);
        List<OrderMenu> orderMenus = List.of(drinking);
        //when, then
        assertThatThrownBy(() -> new Order(orderMenus))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 주문생성시_주문메뉴_이름이_중복되는_경우_예외를_발생한다() {
        //given
        OrderMenu drinking = new OrderMenu(Menu.of("메뉴", 5000, MenuType.MAIN), 1);
        List<OrderMenu> orderMenus = List.of(drinking, drinking, drinking);
        assertThatThrownBy(() -> new Order(orderMenus))
                .isInstanceOf(IllegalArgumentException.class);
    }

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
