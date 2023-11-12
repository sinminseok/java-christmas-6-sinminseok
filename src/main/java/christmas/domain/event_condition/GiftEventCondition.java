package christmas.domain.event_condition;

import christmas.domain.EventCondition;

public class GiftEventCondition implements EventCondition {
    private static final Integer GIFT_EVENT_TOTAL_PRICE_STANDARD = 120000;

    @Override
    public boolean canApplyEvent(EventApplyParameter eventApplyParameter) {
        return GIFT_EVENT_TOTAL_PRICE_STANDARD <= eventApplyParameter.getOrderPrice();
    }
}
