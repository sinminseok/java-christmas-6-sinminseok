package christmas.domain.day;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class CalendarDay {
    private final LocalDate day;
    private final DayOfWeek dayOfWeek;
    private final Boolean hasStar;

    public CalendarDay(LocalDate day, Boolean hasStar) {
        this.day = day;
        this.dayOfWeek = day.getDayOfWeek();
        this.hasStar = hasStar;
    }

    public LocalDate getDay() {
        return day;
    }

    public boolean isSameDay(LocalDate day) {
        return this.day.equals(day);
    }

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    public Boolean getHasStar() {
        return hasStar;
    }
}
