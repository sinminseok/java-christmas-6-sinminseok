package christmas.domain.event;

import christmas.domain.event_condition.EventCondition;

import java.time.LocalDate;

public class Event {
    private final String name;
    private final EventPeriod period;
    private final EventCondition condition;

    private Event(String name, EventPeriod period, EventCondition condition) {
        this.name = name;
        this.period = period;
        this.condition = condition;
    }

    public static Event of(String name, LocalDate startDate, LocalDate endDate, EventCondition condition) {
        return new Event(name, new EventPeriod(startDate, endDate), condition);
    }
}
