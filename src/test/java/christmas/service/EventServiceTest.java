package christmas.service;


import christmas.domain.day.CalendarDay;
import christmas.domain.event.Events;
import christmas.domain.menu.Menu;
import christmas.domain.menu.MenuType;
import christmas.domain.order.Order;
import christmas.domain.order.OrderMenu;
import christmas.repository.EventRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

class EventServiceTest {
    private EventService eventService;

    @BeforeEach
    void setInit() {
        EventRepository eventRepository = new EventRepository();
        eventService = new EventService(eventRepository);
    }

    @Test
    void findEvents_메서드는_적용가능한_이벤트를_찾아_Events_를_만들어_반환한다() {
        //given
        Order order = provideOrder();
        CalendarDay calendarDay = provideCalendarDay();
        //when
        Events applicableEvents = eventService.findEvents(order, calendarDay);
        //then
        Assertions.assertThat(applicableEvents).isNotNull();
    }

    private Order provideOrder() {
        Menu menu = Menu.of("테스트 메뉴", 50000, MenuType.MAIN);

        OrderMenu menuItem = new OrderMenu(menu, 1);

        return new Order(List.of(menuItem));
    }

    private CalendarDay provideCalendarDay() {
        return new CalendarDay(LocalDate.of(2023, 12, 25), true);
    }
}
