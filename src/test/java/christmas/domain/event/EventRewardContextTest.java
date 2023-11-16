package christmas.domain.event;

import christmas.domain.day.CalendarDay;
import christmas.domain.menu.Menu;
import christmas.domain.menu.MenuType;
import christmas.domain.order.OrderMenu;
import christmas.domain.order.Order;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class EventRewardContextTest {
    private EventRewardContext eventRewardContext;

    @BeforeEach
    void setInit() {
        Menu menu1 = Menu.of("메뉴1", 50000, MenuType.MAIN);
        Menu menu2 = Menu.of("메뉴2", 50000, MenuType.MAIN);
        Menu menu3 = Menu.of("메뉴3", 50000, MenuType.DESERT);

        OrderMenu menuItem = new OrderMenu(menu1, 1);
        OrderMenu menuItem2 = new OrderMenu(menu2, 1);
        OrderMenu menuItem3 = new OrderMenu(menu3, 1);

        Order order = new Order(List.of(menuItem, menuItem2, menuItem3));
        CalendarDay calendarDay = new CalendarDay(LocalDate.of(2023, 12, 25), true);
        eventRewardContext = new EventRewardContext(order, calendarDay);
    }

    @ParameterizedTest
    @CsvSource(value = {"MAIN, 2", "DESERT, 1"})
    void countMenuByType_메서드는_메뉴타입을_전달받아_주문에_있는_메뉴와_비교해_일치_갯수를_계산한다(MenuType menuType, int result) {
        //when
        int count = eventRewardContext.countMenuByMenuType(menuType);
        //then
        assertThat(count).isEqualTo(result);
    }

    @Test
    void calculateDaysSinceStart_메서드는_전달받은_시작날짜와_선택한_날짜_사이의_일수를_계산한다() {
        // given
        LocalDate startDate = LocalDate.of(2023, 12, 20);
        // when
        int daysSinceStart = eventRewardContext.calculateDaysBetweenStartAndGivenDate(startDate);
        // then
        assertThat(daysSinceStart).isEqualTo(5);
    }
}
