package christmas.domain.event_condition;

import christmas.domain.event.EventConditionContext;
import christmas.domain.event.EventReward;
import christmas.domain.event.EventRewardParameter;

public interface EventCondition {
    boolean canApplyEvent(EventConditionContext eventApplyParameter);

    EventReward giveReward(EventRewardParameter eventRewardParameter);
}
