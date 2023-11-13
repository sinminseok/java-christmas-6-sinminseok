package christmas.domain.event_condition;

import christmas.domain.event.EventConditionContext;
import christmas.domain.event.EventReward;
import christmas.domain.event.EventRewardContext;
import christmas.domain.event.EventType;

public class SpecialEventCondition implements EventCondition {
    private static final Integer SPECIAL_EVENT_REWARD = 1000;

    @Override
    public boolean canApplyEvent(EventConditionContext eventApplyParameter) {
        return eventApplyParameter.getHasStar();
    }

    @Override
    public EventReward giveReward(EventRewardContext eventRewardParameter) {
        return new EventReward(SPECIAL_EVENT_REWARD);
    }

    @Override
    public EventType checkEventType() {
        return EventType.DISCOUNT;
    }
}
