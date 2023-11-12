package christmas.domain.event;

import christmas.domain.day.CalendarDay;
import christmas.domain.menu.MenuItem;
import christmas.domain.menu.MenuType;
import christmas.domain.order.Order;

import java.time.LocalDate;

public class EventRewardContext {
    private final Order order;
    private final CalendarDay day;

    public EventRewardContext(Order order, CalendarDay day) {
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
