package christmas.domain.event_condition;

import christmas.domain.EventCondition;
import christmas.domain.EventReward;

public class SpecialEventCondition implements EventCondition {
    private static final Integer SPECIAL_EVENT_REWARD = 1000;

    @Override
    public boolean canApplyEvent(EventApplyParameter eventApplyParameter) {
        return eventApplyParameter.getHasStar();
    }

    @Override
    public EventReward giveReward(EventRewardParameter rewardParameter) {
        return null;
    }
}
