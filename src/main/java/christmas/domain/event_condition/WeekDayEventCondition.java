package christmas.domain.event_condition;

import christmas.domain.event.EventConditionContext;
import christmas.domain.event.EventReward;
import christmas.domain.event.EventRewardContext;
import christmas.domain.event.EventType;
import christmas.domain.menu.MenuType;

public class WeekDayEventCondition implements EventCondition {
    private static final Integer DISCOUNT_PRICE_PER_DESERT_MENU = 2023;

    @Override
    public boolean canApply(EventConditionContext eventApplyParameter) {
        return eventApplyParameter.isWeekDayEvent();
    }

    @Override
    public EventReward giveReward(EventRewardContext rewardParameter) {
        int discountPrice = rewardParameter.countMenuByType(MenuType.DESERT) * DISCOUNT_PRICE_PER_DESERT_MENU;
        return new EventReward(discountPrice);
    }

    @Override
    public EventType checkType() {
        return EventType.DISCOUNT;
    }
}
