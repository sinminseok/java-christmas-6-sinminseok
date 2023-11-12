package christmas.data;

import christmas.domain.day.CalendarDay;
import christmas.domain.event.EventRewardParameter;
import christmas.domain.menu.Menu;
import christmas.domain.menu.MenuItem;
import christmas.domain.menu.MenuType;
import christmas.domain.order.Order;

import java.time.LocalDate;
import java.util.List;

public class DummyData {

    public static Order provideOrderData() {
        Menu menu1 = Menu.of("메뉴1", 50000, MenuType.MAIN);
        Menu menu2 = Menu.of("메뉴2", 50000, MenuType.MAIN);
        Menu menu3 = Menu.of("메뉴3", 50000, MenuType.DESERT);

        MenuItem menuItem = new MenuItem(menu1, 1);
        MenuItem menuItem2 = new MenuItem(menu2, 2);
        MenuItem menuItem3 = new MenuItem(menu3, 3);
        return new Order(List.of(menuItem, menuItem2, menuItem3));
    }

    public static CalendarDay provideCalendarDay() {
        return new CalendarDay(LocalDate.of(2023, 12, 25), true);
    }

    public static EventRewardParameter provideEventRewardParameterData() {
        return new EventRewardParameter(provideOrderData(), provideCalendarDayData());
    }

    public static CalendarDay provideCalendarDayData() {
        return new CalendarDay(LocalDate.of(2023, 12, 25), true);
    }
}
