package christmas.domain.order;

import christmas.domain.menu.Menu;
import christmas.domain.menu.MenuType;
import christmas.domain.order.OrderMenu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class OrderMenuTest {

    private OrderMenu orderMenu;

    @BeforeEach
    void setInit() {
        orderMenu = new OrderMenu(Menu.of("메인", 10000, MenuType.MAIN), 2);
    }

    @ParameterizedTest
    @CsvSource(value = {"MAIN, true", "APPETIZER, false", "DESERT, false", "DRINKING, false"})
    void compareMenuType_메서드는_메뉴타입을_비교해_동일성을_판별한다(MenuType menuType, boolean result) {
        //when
        boolean sameMenuType = orderMenu.compareMenuType(menuType);
        //then
        assertThat(sameMenuType).isEqualTo(result);
    }

    @Test
    void calculatePrice_메서드는_메뉴의_가격과_수량을_곱한다() {
        //when
        Integer price = orderMenu.calculatePrice();
        //then
        assertThat(price).isEqualTo(20000);
    }
}
