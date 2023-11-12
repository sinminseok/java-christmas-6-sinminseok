package christmas.domain.user;

import christmas.domain.day.CalendarDay;
import christmas.domain.event.Events;
import christmas.domain.order.Order;

public class Customer {
    private final Events events;
    private final Order order;
    private final CalendarDay calendarDay;

    public Customer(Events events, Order order, CalendarDay calendarDay) {
        this.events = events;
        this.order = order;
        this.calendarDay = calendarDay;
    }
}
