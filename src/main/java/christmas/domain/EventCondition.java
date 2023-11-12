package christmas.domain;

import christmas.domain.event_condition.EventApplyParameter;
import christmas.domain.event_condition.EventRewardParameter;

public interface EventCondition {
    boolean canApplyEvent(EventApplyParameter eventApplyParameter);

    EventReward giveReward(EventRewardParameter eventRewardParameter);
}
