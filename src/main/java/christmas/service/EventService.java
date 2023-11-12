package christmas.service;

import christmas.domain.day.CalendarDay;
import christmas.domain.event.EventApplyParameter;
import christmas.domain.event.Events;
import christmas.domain.order.Order;
import christmas.repository.EventRepository;

import java.util.ArrayList;

public class EventService {
    private final EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public Events findApplicableEvents(Order order, CalendarDay day) {
        if(order.canApplyEvent()){
            EventApplyParameter eventApplyParameter = new EventApplyParameter(order.getOrderPrice(), day);
            return new Events(eventRepository.findCanApplyEvents(eventApplyParameter));
        }
        return new Events(new ArrayList<>());
    }
}
