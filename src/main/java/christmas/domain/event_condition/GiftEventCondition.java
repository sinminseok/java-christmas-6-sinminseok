package christmas.domain.event_condition;

import christmas.domain.event.EventConditionContext;
import christmas.domain.event.EventRewardContext;
import christmas.domain.event.EventType;
import christmas.domain.event.RewardMenu;
import christmas.domain.event.EventReward;
import christmas.domain.menu.Menu;
import christmas.domain.menu.MenuType;

public class GiftEventCondition implements EventCondition {
    private static final Integer GIFT_EVENT_TOTAL_PRICE_STANDARD = 120000;
    private static final Integer REWARD_AMOUNT = 1;
    private static final Menu CHAMPAGNE = Menu.of("샴페인", 25000, MenuType.DRINKING);
    private static final RewardMenu GIFT_EVENT_REWARD = new RewardMenu(CHAMPAGNE, REWARD_AMOUNT);

    @Override
    public boolean canApply(EventConditionContext context) {
        return GIFT_EVENT_TOTAL_PRICE_STANDARD <= context.getOrderPrice();
    }

    @Override
    public EventReward giveReward(EventRewardContext context) {
        return new EventReward(GIFT_EVENT_REWARD);
    }

    @Override
    public EventType checkType() {
        return EventType.GIFT;
    }
}
