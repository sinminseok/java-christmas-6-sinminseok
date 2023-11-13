package christmas.domain.menu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class MenuItemTest {

    private OrderMenu menuItem;

    @BeforeEach
    void setInit() {
        menuItem = new OrderMenu(Menu.of("메인", 10000, MenuType.MAIN), 1);
    }


    @ParameterizedTest
    @CsvSource(value = {"MAIN, true", "APPETIZER, false", "DESERT, false", "DRINKING, false"})
    void compareMenuType_메서드는_메뉴타입을_비교해_동일성을_판별한다(MenuType menuType, boolean result) {
        //when
        boolean sameMenuType = menuItem.compareMenuType(menuType);
        //then
        assertThat(sameMenuType).isEqualTo(result);
    }

    @Test
    void calculatePrice_메서드는_메뉴의_가격과_수량을_곱한다() {
        //when
        Integer price = menuItem.calculatePrice();
        //then
        assertThat(price).isEqualTo(20000);
    }
}
