package christmas.service;

import christmas.domain.day.CalendarDay;
import christmas.domain.event.Events;
import christmas.domain.event.Reward;
import christmas.domain.event.RewardMenu;
import christmas.domain.order.Order;
import christmas.domain.user.Badge;
import christmas.domain.user.Customer;
import christmas.dto.MenuItemDto;
import christmas.dto.RewardDto;

import java.util.List;
import java.util.stream.Collectors;

public class CustomerService {

    public Customer createPlanner(Events events, Order order, CalendarDay calendarDay) {
        return new Customer(events, order, calendarDay);
    }

    public Integer findBeforeDiscountPrice(Customer customer) {
        return customer.findBeforeDiscountPrice();
    }

    public List<MenuItemDto> findGiftReward(Customer planner) {
        List<RewardMenu> giftRewards = planner.findMenuRewards();
        return giftRewards.stream()
                .map(menuReward -> new MenuItemDto(menuReward.getMenuName(), menuReward.getCount()))
                .collect(Collectors.toList());
    }

    public List<RewardDto> findRewards(Customer customer) {
        List<Reward> discountRewards = customer.findAllReward();
        return discountRewards.stream()
                .map(reward -> new RewardDto(reward.getName(), reward.getDiscountPrice()))
                .collect(Collectors.toList());
    }

    public Integer findTotalRewardPrice(Customer customer) {
        return customer.calculateTotalRewardPrice();
    }

    public Integer findPayPrice(Customer customer) {
        return customer.calculatePaymentPrice();
    }

    public Badge findBadge(Customer customer) {
        return customer.awardBadge();
    }

}
