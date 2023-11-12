package christmas.domain;

import java.util.List;

public class Order {
    private final List<MenuItem> menuItems;

    public Order(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }
}
