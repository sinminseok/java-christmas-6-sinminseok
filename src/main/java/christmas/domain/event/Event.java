package christmas.domain.event;

import christmas.domain.day.CalendarDay;
import christmas.domain.event_condition.EventCondition;

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

    public Reward findReward(EventRewardContext context) {
        return wrapReward(findEventReward(context));
    }

    public RewardMenu findRewardMenu(EventRewardContext context) {
        return (RewardMenu) findEventReward(context).getRewardValue();
    }

    private EventReward findEventReward(EventRewardContext context) {
        return condition.giveReward(context);
    }

    private Reward wrapReward(EventReward eventReward) {
        if (eventReward.isRewardMenuType()) {
            return new Reward(name, ((RewardMenu) eventReward.getRewardValue()).calculatePrice());
        }
        return new Reward(name, (Integer) eventReward.getRewardValue());
    }

    public boolean isApplicable(EventConditionContext context) {
        return containsDay(context.getCalendarDay()) && condition.canApply(context);
    }

    public boolean isGiftEvent() {
        return condition.checkType().equals(EventType.GIFT);
    }

    public boolean isDiscountEvent() {
        return condition.checkType().equals(EventType.DISCOUNT);
    }

    private boolean containsDay(CalendarDay day) {
        return period.containPeriod(day.getDay());
    }
}
