package christmas.domain.event_condition;

import christmas.domain.event.EventConditionContext;
import christmas.domain.event.EventReward;
import christmas.domain.event.EventRewardContext;
import christmas.domain.event.EventType;

public interface EventCondition {
    boolean canApply(EventConditionContext context);

    EventReward giveReward(EventRewardContext context);

    EventType checkType();
}
