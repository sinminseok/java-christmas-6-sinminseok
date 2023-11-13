package christmas.domain.order;

import christmas.domain.menu.OrderMenu;

import java.util.List;

public class Order {
    private static final Integer MIN_TOTAL_PRICE = 10000;

    private final List<OrderMenu> menuItems;

    public Order(List<OrderMenu> menuItems) {
        this.menuItems = menuItems;
    }

    public Integer getOrderPrice() {
        return menuItems.stream()
                .mapToInt(OrderMenu::calculatePrice)
                .sum();
    }

    public boolean canApplyEvent() {
        return getOrderPrice() >= MIN_TOTAL_PRICE;
    }

    public List<OrderMenu> getMenuItems() {
        return menuItems;
    }
}
