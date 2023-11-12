package christmas.domain;

public interface EventCondition {
    boolean canApplyEvent(CalendarDay calendarDay);
}
