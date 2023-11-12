package christmas.domain.event;

import christmas.domain.day.CalendarDay;

import java.time.LocalDate;

public class EventConditionContext {
    private final Integer orderPrice;
    private final CalendarDay calendarDay;

    public EventConditionContext(Integer orderPrice, CalendarDay calendarDay) {
        this.orderPrice = orderPrice;
        this.calendarDay = calendarDay;
    }

    public Integer getOrderPrice() {
        return orderPrice;
    }

    public boolean isContainDay(LocalDate startDate, LocalDate endDate) {
        return !this.calendarDay.getDay().isBefore(startDate) && !this.calendarDay.getDay().isAfter(endDate);
    }

    public boolean getHasStar() {
        return calendarDay.getHasStar();
    }

    public CalendarDay getCalendarDay() {
        return calendarDay;
    }
}
