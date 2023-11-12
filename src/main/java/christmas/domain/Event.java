package christmas.domain;

public class Event {
    private final String name;
    private final EventPeriod period;
    private final EventCondition eventCondition;

    public Event(String name, EventPeriod period, EventCondition eventCondition) {
        this.name = name;
        this.period = period;
        this.eventCondition = eventCondition;
    }
}
