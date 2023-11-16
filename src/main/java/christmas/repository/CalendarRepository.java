package christmas.repository;

import christmas.domain.day.CalendarDay;
import christmas.utils.ErrorMessage;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static christmas.utils.ErrorConstants.VISIT_DAY_ERROR;

public class CalendarRepository {
    private static final Integer MONTH_START_DAY = 1;
    private static final Integer MONTH_END_DAY = 31;
    private static final Integer CHRISTMAS_DAY = 25;
    private static final LocalDate START_DATE = LocalDate.of(2023, 12, 1);
    private static List<CalendarDay> DAYS;

    static {
        DAYS = IntStream.rangeClosed(MONTH_START_DAY, MONTH_END_DAY)
                .mapToObj(i -> START_DATE.withDayOfMonth(i))
                .map(date -> new CalendarDay(date, isStarDay(date)))
                .collect(Collectors.toList());
    }

    private static boolean isStarDay(LocalDate date) {
        return date.getDayOfWeek() == DayOfWeek.SUNDAY || date.getDayOfMonth() == CHRISTMAS_DAY;
    }

    public static CalendarDay findByDay(int day) {
        return DAYS.stream()
                .filter(calendarDay -> calendarDay.isSameDay(START_DATE.withDayOfMonth(day)))
                .findFirst()
                .orElseThrow(() -> new ErrorMessage(VISIT_DAY_ERROR));
    }
}
