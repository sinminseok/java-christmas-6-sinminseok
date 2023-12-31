package christmas.service;

import christmas.domain.day.CalendarDay;
import christmas.domain.event.Events;
import christmas.domain.reward.Reward;
import christmas.domain.reward.RewardMenu;
import christmas.domain.order.Order;
import christmas.domain.plan.Badge;
import christmas.domain.plan.Plan;
import christmas.dto.MenuAmountDto;
import christmas.dto.RewardDto;

import java.util.List;
import java.util.stream.Collectors;

public class PlanService {

    public Plan createPlan(Events events, Order order, CalendarDay calendarDay) {
        return new Plan(events, order, calendarDay);
    }

    public Integer findBeforeDiscountPrice(Plan plan) {
        return plan.findBeforeDiscountPrice();
    }

    public List<MenuAmountDto> findGiftReward(Plan plan) {
        List<RewardMenu> giftRewards = plan.findMenuRewards();
        return giftRewards.stream()
                .map(menuReward -> createMenuAmountDto(menuReward))
                .collect(Collectors.toList());
    }

    public List<RewardDto> findRewards(Plan plan) {
        List<Reward> discountRewards = plan.findAllReward();
        return discountRewards.stream()
                .map(reward -> createRewardDto(reward))
                .collect(Collectors.toList());
    }

    public Integer findTotalRewardPrice(Plan plan) {
        return plan.calculateTotalRewardPrice();
    }

    public Integer findPayPrice(Plan plan) {
        return plan.calculatePaymentPrice();
    }

    public Badge findBadge(Plan plan) {
        return plan.awardBadge();
    }

    private MenuAmountDto createMenuAmountDto(RewardMenu rewardMenu) {
        return new MenuAmountDto(rewardMenu.getMenuName(), rewardMenu.getCount());
    }

    private RewardDto createRewardDto(Reward reward) {
        return new RewardDto(reward.getName(), reward.getDiscountPrice());
    }
}
