package christmas.domain.event_condition;


import christmas.domain.event.EventConditionContext;
import christmas.domain.event.EventReward;
import christmas.domain.event.EventRewardContext;
import christmas.domain.event.EventType;
import christmas.domain.menu.MenuType;

import java.time.DayOfWeek;

public class WeekendEventCondition implements EventCondition {
    private static final Integer DISCOUNT_PRICE_PER_MAIN_MENU = 2023;

    @Override
    public boolean canApplyEvent(EventConditionContext eventApplyParameter) {
        DayOfWeek dayOfWeek = eventApplyParameter.getCalendarDay().getDayOfWeek();
        return dayOfWeek == DayOfWeek.FRIDAY || dayOfWeek == DayOfWeek.SATURDAY;
    }

    @Override
    public EventReward giveReward(EventRewardContext rewardParameter) {
        int discountPrice = rewardParameter.countMenuByType(MenuType.MAIN) * DISCOUNT_PRICE_PER_MAIN_MENU;
        return new EventReward(discountPrice);
    }

    @Override
    public EventType checkEventType() {
        return EventType.DISCOUNT;
    }
}
