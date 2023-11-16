package christmas.domain.event;

import christmas.domain.day.CalendarDay;

import java.time.LocalDate;

/*
이벤트 참여 여부를 확인하기 위해선 총 주문금액, 선택한 캘린더 날짜 정보가 필요하다
 */
public class EventConditionContext {
    private final Integer orderPrice;
    private final CalendarDay calendarDay;

    public EventConditionContext(Integer orderPrice, CalendarDay calendarDay) {
        this.orderPrice = orderPrice;
        this.calendarDay = calendarDay;
    }

    public boolean isContainDay(LocalDate startDate, LocalDate endDate) {
        return calendarDay.isAfterOrEqual(startDate) && calendarDay.isBeforeOrEqual(endDate);
    }

    public boolean isWeekendEvent() {
        return calendarDay.isWeekend();
    }

    public boolean isWeekDayEvent() {
        return calendarDay.isWeekDay();
    }

    public Integer getOrderPrice() {
        return orderPrice;
    }

    public boolean getHasStar() {
        return calendarDay.getHasStar();
    }

    public CalendarDay getCalendarDay() {
        return calendarDay;
    }
}
