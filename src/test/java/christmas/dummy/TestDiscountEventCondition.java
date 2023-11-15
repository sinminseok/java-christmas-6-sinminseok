package christmas.dummy;

import christmas.domain.event.EventConditionContext;
import christmas.domain.event.EventReward;
import christmas.domain.event.EventRewardContext;
import christmas.domain.event.EventType;
import christmas.domain.event_condition.EventCondition;

public class TestDiscountEventCondition implements EventCondition {

    @Override
    public boolean canApply(EventConditionContext eventApplyParameter) {
        return true;
    }

    @Override
    public EventReward giveReward(EventRewardContext eventRewardParameter) {
        return new EventReward(1000);
    }

    @Override
    public EventType checkType() {
        return EventType.DISCOUNT;
    }
}