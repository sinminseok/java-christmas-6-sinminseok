package christmas.domain.order;

import christmas.domain.menu.OrderMenu;
import christmas.utils.ErrorMessage;

import java.util.List;

import static christmas.utils.ErrorConstants.ORDER_ERROR;

public class Order {
    private static final Integer MIN_TOTAL_PRICE = 10000;
    private static final Integer MIN_MENU_RANGE = 1;
    private static final Integer MAX_MENU_RANGE = 20;

    private final List<OrderMenu> menuItems;

    public Order(List<OrderMenu> menuItems) {
        validateMenuSize(menuItems);
        this.menuItems = menuItems;
    }

    private void validateMenuSize(List<OrderMenu> menuItems) {
        if(menuItems.size() < MIN_MENU_RANGE || menuItems.size() > MAX_MENU_RANGE){
            throw new ErrorMessage(ORDER_ERROR);
        }
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
