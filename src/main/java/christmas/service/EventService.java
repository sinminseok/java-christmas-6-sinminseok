package christmas.service;

import christmas.domain.day.CalendarDay;
import christmas.domain.event.EventApplyParameter;
import christmas.domain.event.Events;
import christmas.domain.order.Order;
import christmas.repository.EventRepository;

public class EventService {
    private final EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public Events findApplicableEvents(Order order, CalendarDay day) {
        EventApplyParameter eventApplyParameter = new EventApplyParameter(order.getOrderPrice(), day);
        return new Events(eventRepository.findCanApplyEvents(eventApplyParameter));
    }
}
