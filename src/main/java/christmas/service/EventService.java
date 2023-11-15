package christmas.service;

import christmas.domain.day.CalendarDay;
import christmas.domain.event.Event;
import christmas.domain.event.EventConditionContext;
import christmas.domain.event.EventRewardContext;
import christmas.domain.event.Events;
import christmas.domain.order.Order;
import christmas.repository.EventRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class EventService {
    private final EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public Events findEvents(Order order, CalendarDay day) {
        if (order.canApplyEvent()) {
            return findApplicableEvents(order, day);
        }
        return new Events(Collections.emptyList());
    }

    private Events findApplicableEvents(Order order, CalendarDay day){
        EventConditionContext eventApplyParameter = new EventConditionContext(order.getOrderPrice(), day);
        List<Event> findEvents = findAll().stream()
                .filter(event -> event.isApplicable(eventApplyParameter))
                .collect(Collectors.toList());
        return new Events(findEvents);
    }

    private List<Event> findAll() {
        return eventRepository.findAll();
    }
}
