package christmas.domain.event_condition;

import christmas.domain.event.EventConditionContext;
import christmas.domain.event.EventReward;
import christmas.domain.event.EventRewardContext;

public interface EventCondition {
    boolean canApplyEvent(EventConditionContext eventApplyParameter);

    EventReward giveReward(EventRewardContext eventRewardParameter);
}
