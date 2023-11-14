package christmas.domain.day;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class CalendarDay {
    private final LocalDate day;
    private final Boolean hasStar;

    public CalendarDay(LocalDate day, Boolean hasStar) {
        this.day = day;
        this.hasStar = hasStar;
    }

    public LocalDate getDay() {
        return day;
    }

    public boolean isSameDay(LocalDate day) {
        return this.day.equals(day);
    }

    public boolean isWeekend() {
        DayOfWeek dayOfWeek = getDayOfWeek();
        return dayOfWeek == DayOfWeek.FRIDAY || dayOfWeek == DayOfWeek.SATURDAY;
    }

    public boolean isWeekDay() {
        DayOfWeek dayOfWeek = getDayOfWeek();
        return dayOfWeek != DayOfWeek.FRIDAY && dayOfWeek != DayOfWeek.SATURDAY;
    }

    private DayOfWeek getDayOfWeek(){
        return day.getDayOfWeek();
    }

    public Boolean getHasStar() {
        return hasStar;
    }
}
