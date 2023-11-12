package christmas.domain.event_condition;

import christmas.domain.CalendarDay;
import christmas.domain.MenuItem;
import christmas.domain.MenuType;
import christmas.domain.Order;

import java.time.LocalDate;

public class EventRewardParameter {
    private final Order order;
    private final CalendarDay day;

    public EventRewardParameter(Order order, CalendarDay day) {
        this.order = order;
        this.day = day;
    }

    public int countMenuByType(MenuType menuType) {
        return order.getMenuItems().stream()
                .filter(menuItem -> menuItem.compareMenuType(menuType))
                .mapToInt(MenuItem::getCount)
                .sum();
    }

    public int calculateDaysSinceStart(LocalDate startDate) {
        return (int) startDate.until(day.getDay(), java.time.temporal.ChronoUnit.DAYS);
    }
}
