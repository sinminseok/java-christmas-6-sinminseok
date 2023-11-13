package christmas.service;

import christmas.domain.day.CalendarDay;
import christmas.domain.event.Events;
import christmas.domain.event.Reward;
import christmas.domain.event.RewardMenu;
import christmas.domain.order.Order;
import christmas.domain.plan.Badge;
import christmas.domain.plan.Plan;
import christmas.dto.MenuItemDto;
import christmas.dto.RewardDto;

import java.util.List;
import java.util.stream.Collectors;

public class PlanService {

    public Plan createPlanner(Events events, Order order, CalendarDay calendarDay) {
        return new Plan(events, order, calendarDay);
    }

    public Integer findBeforeDiscountPrice(Plan customer) {
        return customer.findBeforeDiscountPrice();
    }

    public List<MenuItemDto> findGiftReward(Plan planner) {
        List<RewardMenu> giftRewards = planner.findMenuRewards();
        return giftRewards.stream()
                .map(menuReward -> new MenuItemDto(menuReward.getMenuName(), menuReward.getCount()))
                .collect(Collectors.toList());
    }

    public List<RewardDto> findRewards(Plan customer) {
        List<Reward> discountRewards = customer.findAllReward();
        return discountRewards.stream()
                .map(reward -> new RewardDto(reward.getName(), reward.getDiscountPrice()))
                .collect(Collectors.toList());
    }

    public Integer findTotalRewardPrice(Plan customer) {
        return customer.calculateTotalRewardPrice();
    }

    public Integer findPayPrice(Plan customer) {
        return customer.calculatePaymentPrice();
    }

    public Badge findBadge(Plan customer) {
        return customer.awardBadge();
    }

}
