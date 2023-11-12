package christmas.domain.event_condition;

import christmas.domain.CalendarDay;
import christmas.domain.Order;

import java.time.LocalDate;

public class EventRewardParameter {
    private final Order order;
    private final CalendarDay day;

    public EventRewardParameter(Order order, CalendarDay day) {
        this.order = order;
        this.day = day;
    }

    public int calculateDaysSinceStart(LocalDate startDate) {
        return (int) startDate.until(day.getDay(), java.time.temporal.ChronoUnit.DAYS);
    }
}
