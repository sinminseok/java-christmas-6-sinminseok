package christmas.domain.event_condition;

import christmas.domain.event.EventApplyParameter;
import christmas.domain.event.EventReward;
import christmas.domain.event.EventRewardParameter;
import christmas.domain.menu.Menu;
import christmas.domain.menu.MenuItem;
import christmas.domain.menu.MenuType;

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
