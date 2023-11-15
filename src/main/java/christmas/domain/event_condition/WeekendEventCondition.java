package christmas.domain.event_condition;


import christmas.domain.event.EventConditionContext;
import christmas.domain.event.EventReward;
import christmas.domain.event.EventRewardContext;
import christmas.domain.event.EventType;
import christmas.domain.menu.MenuType;

public class WeekendEventCondition implements EventCondition {
    private static final Integer DISCOUNT_PRICE_PER_MAIN_MENU = 2023;

    @Override
    public boolean canApply(EventConditionContext context) {
        return context.isWeekendEvent();
    }

    @Override
    public EventReward giveReward(EventRewardContext context) {
        int discountPrice = context.countMenuByMenuType(MenuType.MAIN) * DISCOUNT_PRICE_PER_MAIN_MENU;
        return new EventReward(discountPrice);
    }

    @Override
    public EventType checkType() {
        return EventType.DISCOUNT;
    }
}
