package christmas.domain.event_condition;

import christmas.domain.event.EventConditionContext;
import christmas.domain.event.EventReward;
import christmas.domain.event.EventRewardContext;
import christmas.domain.event.EventType;

public class SpecialEventCondition implements EventCondition {
    private static final Integer SPECIAL_EVENT_REWARD = 1000;

    @Override
    public boolean canApply(EventConditionContext context) {
        return context.getHasStar();
    }

    @Override
    public EventReward giveReward(EventRewardContext context) {
        return new EventReward(SPECIAL_EVENT_REWARD);
    }

    @Override
    public EventType checkType() {
        return EventType.DISCOUNT;
    }
}
