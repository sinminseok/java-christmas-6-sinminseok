package christmas.domain.event;

import christmas.domain.day.CalendarDay;
import christmas.domain.event_condition.EventCondition;
import christmas.domain.menu.MenuItem;

import java.time.LocalDate;

public class Event {
    private final String name;
    private final EventPeriod period;
    private final EventCondition condition;

    private Event(String name, EventPeriod period, EventCondition condition) {
        this.name = name;
        this.period = period;
        this.condition = condition;
    }

    public static Event of(String name, LocalDate startDate, LocalDate endDate, EventCondition condition) {
        return new Event(name, new EventPeriod(startDate, endDate), condition);
    }

    public Reward findReward(EventRewardContext eventRewardContext){
        EventReward eventReward = condition.giveReward(eventRewardContext);
        return wrapReward(eventReward);
    }

    // 제네릭 타입은 EventReward 를 Reward 로 변경
    private Reward wrapReward(EventReward eventReward) {
        if (eventReward.isMenuItemType()) {
            return new Reward(name, ((MenuItem) eventReward.getRewardValue()).calculatePrice());
        }
        return new Reward(name, (Integer) eventReward.getRewardValue());
    }

    public boolean isApplicable(EventConditionContext context) {
        return containsDay(context.getCalendarDay()) && condition.canApplyEvent(context);
    }

    private boolean containsDay(CalendarDay day) {
        return period.containPeriod(day.getDay());
    }
}
