package christmas.service;

import christmas.domain.day.CalendarDay;
import christmas.domain.event.Events;
import christmas.domain.order.Order;
import christmas.domain.user.Customer;

public class CustomerService {

    public Customer createPlanner(Events events, Order order, CalendarDay calendarDay) {
        return new Customer(events, order, calendarDay);
    }

}
