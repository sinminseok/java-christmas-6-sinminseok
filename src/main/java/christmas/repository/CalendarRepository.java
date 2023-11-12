package christmas.repository;

import christmas.domain.CalendarDay;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CalendarRepository {
    private static final LocalDate START_DATE = LocalDate.of(2023, 12, 1);
    private static List<CalendarDay> DAYS;

    static {
        DAYS = IntStream.rangeClosed(1, 31)
                .mapToObj(i -> START_DATE.withDayOfMonth(i))
                .map(date -> new CalendarDay(date, isStarDay(date)))
                .collect(Collectors.toList());
    }

    private static boolean isStarDay(LocalDate date) {
        return date.getDayOfWeek() == DayOfWeek.SUNDAY || date.getDayOfMonth() == 25;
    }
}
