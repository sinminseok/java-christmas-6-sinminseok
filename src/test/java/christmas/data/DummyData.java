package christmas.data;

import christmas.domain.CalendarDay;
import christmas.domain.Menu;
import christmas.domain.MenuType;
import christmas.domain.Order;
import christmas.domain.event_condition.EventRewardParameter;

import java.time.LocalDate;
import java.util.Map;

public class DummyData {

    public static Order provideOrderData() {
        Menu menu1 = Menu.of("메뉴1", 50000, MenuType.MAIN);
        Menu menu2 = Menu.of("메뉴2", 50000, MenuType.MAIN);
        Menu menu3 = Menu.of("메뉴3", 50000, MenuType.DESERT);
        return new Order(Map.of(menu1, 1, menu2, 2, menu3, 3));
    }

    public static CalendarDay provideCalendarDay() {
        return new CalendarDay(LocalDate.of(2023,12,25),true);
    }

    public static EventRewardParameter provideRewardStandardData() {
        return new EventRewardParameter(provideOrderData(), provideCalendarDayData());
    }

    public static CalendarDay provideCalendarDayData() {
        return new CalendarDay(LocalDate.of(2023, 12, 25), true);
    }
}
