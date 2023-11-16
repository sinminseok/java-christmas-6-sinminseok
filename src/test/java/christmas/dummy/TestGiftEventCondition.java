package christmas.dummy;


import christmas.domain.event.EventConditionContext;
import christmas.domain.event.EventReward;
import christmas.domain.event.EventRewardContext;
import christmas.domain.event.EventType;
import christmas.domain.event_condition.EventCondition;
import christmas.domain.menu.Menu;
import christmas.domain.menu.MenuType;
import christmas.domain.reward.RewardMenu;

public class TestGiftEventCondition implements EventCondition {

    @Override
    public boolean canApply(EventConditionContext eventApplyParameter) {
        return true;
    }

    @Override
    public EventReward giveReward(EventRewardContext eventRewardParameter) {
        return new EventReward(new RewardMenu(Menu.of("증정메뉴", 10000, MenuType.MAIN), 1));
    }

    @Override
    public EventType checkType() {
        return EventType.GIFT;
    }
}