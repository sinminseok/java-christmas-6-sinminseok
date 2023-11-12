package christmas.domain.event_condition;

import christmas.domain.CalendarDay;

import java.time.LocalDate;

public class EventApplyParameter {
    private final Integer orderPrice;
    private final CalendarDay calendarDay;

    public EventApplyParameter(Integer orderPrice, CalendarDay calendarDay) {
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
