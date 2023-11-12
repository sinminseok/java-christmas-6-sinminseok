package christmas.domain.event_condition;

import christmas.domain.event.EventApplyParameter;
import christmas.domain.event.EventReward;
import christmas.domain.event.EventRewardParameter;

public interface EventCondition {
    boolean canApplyEvent(EventApplyParameter eventApplyParameter);

    EventReward giveReward(EventRewardParameter eventRewardParameter);
}
