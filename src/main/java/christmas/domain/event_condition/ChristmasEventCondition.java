package christmas.domain.event_condition;

import christmas.domain.EventCondition;
import christmas.domain.EventReward;

import java.time.LocalDate;

public class ChristmasEventCondition implements EventCondition {
    private static final Integer START_DISCOUNT_PRICE = 1000;
    private static final Integer INCREASE_DISCOUNT_PRICE_PER_DAY = 100;
    private static final LocalDate START_DATE = LocalDate.of(2023,12,1);
    private static final LocalDate END_DATE = LocalDate.of(2023,12,25);

    @Override
    public boolean canApplyEvent(EventApplyParameter eventApplyParameter) {
        return eventApplyParameter.isContainDay(START_DATE, END_DATE);
    }

    @Override
    public EventReward giveReward(EventRewardParameter rewardParameter) {
        int daysFromStart = rewardParameter.calculateDaysSinceStart(START_DATE);
        int discountAmount = START_DISCOUNT_PRICE + (daysFromStart * INCREASE_DISCOUNT_PRICE_PER_DAY);
        return new EventReward(discountAmount);
    }
}