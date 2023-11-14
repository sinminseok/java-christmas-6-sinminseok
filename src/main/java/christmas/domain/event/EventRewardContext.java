package christmas.domain.event;

import christmas.domain.day.CalendarDay;
import christmas.domain.order.OrderMenu;
import christmas.domain.menu.MenuType;
import christmas.domain.order.Order;

import java.time.LocalDate;

/*
이벤트 보상을 구하기 위해선 주문 정보와, 선택한 캘린더 날짜 정보가 필요하다
 */
public class EventRewardContext {
    private final Order order;
    private final CalendarDay day;

    public EventRewardContext(Order order, CalendarDay day) {
        this.order = order;
        this.day = day;
    }

    public int countMenuByType(MenuType menuType) {
        return order.getOrderMenus().stream()
                .filter(menuItem -> menuItem.compareMenuType(menuType))
                .mapToInt(OrderMenu::getCount)
                .sum();
    }

    public int calculateDaysBetweenStartAndGivenDate(LocalDate startDate) {
        return (int) startDate.until(day.getDay(), java.time.temporal.ChronoUnit.DAYS);
    }
}
