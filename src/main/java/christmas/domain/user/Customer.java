package christmas.domain.user;

import christmas.domain.day.CalendarDay;
import christmas.domain.event.EventRewardContext;
import christmas.domain.event.Events;
import christmas.domain.event.Reward;
import christmas.domain.menu.OrderMenu;
import christmas.domain.order.Order;

import java.util.List;

public class Customer {
    private final Events events;
    private final Order order;
    private final CalendarDay calendarDay;

    public Customer(Events events, Order order, CalendarDay calendarDay) {
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

    public List<OrderMenu> findMenuRewards(){
        EventRewardContext context = createRewardContext();
        return events.findMenuRewards(context);
    }

    private EventRewardContext createRewardContext() {
        return new EventRewardContext(order, calendarDay);
    }
}
