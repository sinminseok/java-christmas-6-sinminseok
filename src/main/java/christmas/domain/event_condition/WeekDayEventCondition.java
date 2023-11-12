package christmas.domain.event_condition;

import christmas.domain.EventCondition;
import christmas.domain.EventReward;

import java.time.DayOfWeek;

public class WeekDayEventCondition implements EventCondition {
    @Override
    public boolean canApplyEvent(EventApplyParameter eventApplyParameter) {
        DayOfWeek dayOfWeek = eventApplyParameter.getCalendarDay().getDayOfWeek();
        return dayOfWeek != DayOfWeek.FRIDAY && dayOfWeek != DayOfWeek.SATURDAY;
    }

    @Override
    public EventReward giveReward() {
        return null;
    }
}
