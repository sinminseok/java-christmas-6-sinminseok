package christmas.domain.event_condition;

import christmas.domain.EventCondition;

import java.time.DayOfWeek;

public class WeekDayEventCondition implements EventCondition {
    @Override
    public boolean canApplyEvent(EventApplyParameter eventApplyParameter) {
        DayOfWeek dayOfWeek = eventApplyParameter.getCalendarDay().getDayOfWeek();
        return dayOfWeek != DayOfWeek.FRIDAY && dayOfWeek != DayOfWeek.SATURDAY;
    }
}
