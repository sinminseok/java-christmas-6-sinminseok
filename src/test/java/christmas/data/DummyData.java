package christmas.data;

import christmas.domain.day.CalendarDay;
import christmas.domain.event.Event;
import christmas.domain.event.EventRewardContext;
import christmas.domain.event.Events;
import christmas.domain.event_condition.*;
import christmas.domain.menu.Menu;
import christmas.domain.menu.MenuItem;
import christmas.domain.menu.MenuType;
import christmas.domain.order.Order;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DummyData {

    public static Events provideEventsData() {
        List<Event> events = new ArrayList<>();

        events.add(Event.of("크리스마스 디데이 할인", LocalDate.of(2023, 12, 1), LocalDate.of(2023, 12, 25), new ChristmasEventCondition()));
        events.add(Event.of("평일 할인", LocalDate.of(2023, 12, 1), LocalDate.of(2023, 12, 31), new WeekDayEventCondition()));
        events.add(Event.of("주말 할인", LocalDate.of(2023, 12, 1), LocalDate.of(2023, 12, 31), new WeekendEventCondition()));
        events.add(Event.of("특별 할인", LocalDate.of(2023, 12, 1), LocalDate.of(2023, 12, 31), new SpecialEventCondition()));
        events.add(Event.of("증정 이벤트", LocalDate.of(2023, 12, 1), LocalDate.of(2023, 12, 31), new GiftEventCondition()));

        return new Events(events);
    }

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

    public static EventRewardContext provideEventRewardParameterData() {
        return new EventRewardContext(provideOrderData(), provideCalendarDayData());
    }

    public static CalendarDay provideCalendarDayData() {
        return new CalendarDay(LocalDate.of(2023, 12, 25), true);
    }
}
