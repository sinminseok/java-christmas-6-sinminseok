package christmas.domain;

import java.util.Map;

public class Order {
    private final Map<Menu, Integer> orders;

    public Order(Map<Menu, Integer> orders) {
        this.orders = orders;
    }
}
