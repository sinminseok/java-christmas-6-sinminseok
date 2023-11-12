package christmas.domain.order;

import christmas.domain.menu.MenuItem;

import java.util.List;

public class Order {
    private static final Integer MIN_TOTAL_PRICE = 10000;

    private final List<MenuItem> menuItems;

    public Order(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    public Integer getOrderPrice() {
        return menuItems.stream()
                .mapToInt(MenuItem::calculatePrice)
                .sum();
    }

    public boolean canApplyEvent() {
        return getOrderPrice() >= MIN_TOTAL_PRICE;
    }

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }
}
