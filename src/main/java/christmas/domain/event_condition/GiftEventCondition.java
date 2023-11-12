package christmas.domain.event_condition;

import christmas.domain.*;

public class GiftEventCondition implements EventCondition {
    private static final Integer GIFT_EVENT_TOTAL_PRICE_STANDARD = 120000;
    private static final Integer REWARD_AMOUNT = 1;
    private static final Menu CHAMPAGNE = Menu.of("샴페인", 25000, MenuType.DRINKING);
    private static final MenuItem GIFT_EVENT_REWARD = new MenuItem(CHAMPAGNE, REWARD_AMOUNT);
    @Override
    public boolean canApplyEvent(EventApplyParameter eventApplyParameter) {
        return GIFT_EVENT_TOTAL_PRICE_STANDARD <= eventApplyParameter.getOrderPrice();
    }

    @Override
    public EventReward giveReward(EventRewardParameter eventRewardParameter) {
        return new EventReward(GIFT_EVENT_REWARD);
    }
}
