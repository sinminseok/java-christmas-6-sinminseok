package christmas.domain.event_condition;

import christmas.domain.event.EventApplyParameter;
import christmas.domain.event.EventReward;
import christmas.domain.event.EventRewardParameter;

public class SpecialEventCondition implements EventCondition {
    private static final Integer SPECIAL_EVENT_REWARD = 1000;

    @Override
    public boolean canApplyEvent(EventApplyParameter eventApplyParameter) {
        return eventApplyParameter.getHasStar();
    }

    @Override
    public EventReward giveReward(EventRewardParameter eventRewardParameter) {
        return new EventReward(SPECIAL_EVENT_REWARD);
    }
}
