package christmas.domain.order;

import christmas.domain.menu.MenuItem;

import java.util.List;

public class Order {
    private final List<MenuItem> menuItems;

    public Order(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    public Integer getOrderPrice() {
        return menuItems.stream()
                .mapToInt(MenuItem::getMenuItemPrice)
                .sum();
    }

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }
}
