package christmas.domain.plan;

import christmas.domain.day.CalendarDay;
import christmas.domain.event.EventRewardContext;
import christmas.domain.event.Events;
import christmas.domain.event.Reward;
import christmas.domain.event.RewardMenu;
import christmas.domain.order.Order;

import java.util.List;

public class Plan {
    private final Events events;
    private final Order order;
    private final CalendarDay calendarDay;

    public Plan(Events events, Order order, CalendarDay calendarDay) {
        this.events = events;
        this.order = order;
        this.calendarDay = calendarDay;
    }

    //todo 고객 기능 구현 후 해당 메서드 위치 고려
    public Integer findBeforeDiscountPrice() {
        return order.getOrderPrice();
    }

    public List<Reward> findAllReward() {
        EventRewardContext context = createRewardContext();
        return events.findRewards(context);
    }

    public List<RewardMenu> findMenuRewards() {
        EventRewardContext context = createRewardContext();
        return events.findRewardMenus(context);
    }

    public Integer calculateTotalRewardPrice() {
        List<Reward> allReward = findAllReward();
        return allReward.stream()
                .mapToInt(reward -> reward.getDiscountPrice())
                .sum();
    }

    private Integer calculateDiscountRewardPrice() {
        EventRewardContext context = createRewardContext();
        List<Reward> discountRewards = events.findRewardDiscounts(context);
        return discountRewards.stream()
                .mapToInt(rewardDiscount -> rewardDiscount.getDiscountPrice())
                .sum();
    }

    public Integer calculatePaymentPrice() {
        return findBeforeDiscountPrice() - calculateDiscountRewardPrice();
    }

    public Badge awardBadge() {
        return Badge.of(calculateTotalRewardPrice());
    }

    private EventRewardContext createRewardContext() {
        return new EventRewardContext(order, calendarDay);
    }
}
