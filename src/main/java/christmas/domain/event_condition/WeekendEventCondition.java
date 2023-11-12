package christmas.domain.event_condition;


import christmas.domain.event.EventApplyParameter;
import christmas.domain.event.EventReward;
import christmas.domain.event.EventRewardParameter;
import christmas.domain.menu.MenuType;

import java.time.DayOfWeek;

public class WeekendEventCondition implements EventCondition {
    private static final Integer DISCOUNT_PRICE_PER_MAIN_MENU = 2023;

    @Override
    public boolean canApplyEvent(EventApplyParameter eventApplyParameter) {
        DayOfWeek dayOfWeek = eventApplyParameter.getCalendarDay().getDayOfWeek();
        return dayOfWeek == DayOfWeek.FRIDAY || dayOfWeek == DayOfWeek.SATURDAY;
    }

    @Override
    public EventReward giveReward(EventRewardParameter rewardParameter) {
        int discountPrice = rewardParameter.countMenuByType(MenuType.MAIN) * DISCOUNT_PRICE_PER_MAIN_MENU;
        return new EventReward(discountPrice);
    }
}
