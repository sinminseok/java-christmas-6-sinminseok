package christmas.domain.event_condition;

import christmas.domain.CalendarDay;
import christmas.domain.EventCondition;

import java.time.LocalDate;

public class ChristmasEventCondition implements EventCondition {
    private static final LocalDate START_DATE = LocalDate.of(2023,12,1);
    private static final LocalDate END_DATE = LocalDate.of(2023,12,25);

    @Override
    public boolean canApplyEvent(CalendarDay day) {
        return !day.getDay().isBefore(START_DATE) && !day.getDay().isAfter(END_DATE);
    }
}
