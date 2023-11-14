package christmas.domain.order;

import christmas.domain.menu.MenuType;
import christmas.dto.MenuAmountDto;
import christmas.dto.OrderDto;
import christmas.utils.ErrorMessage;

import java.util.List;
import java.util.stream.Collectors;

import static christmas.utils.ErrorConstants.ORDER_ERROR;

public class Order {
    private static final Integer MIN_TOTAL_PRICE = 10000;
    private static final Integer MIN_MENU_RANGE = 1;
    private static final Integer MAX_MENU_RANGE = 20;

    private final List<OrderMenu> orderMenus;

    public Order(List<OrderMenu> orderMenus) {
        validateMenuSize(orderMenus);
        validateDuplicateMenu(orderMenus);
        validateMenuAllDrinking(orderMenus);
        this.orderMenus = orderMenus;
    }

    private void validateDuplicateMenu(List<OrderMenu> orderMenus) {
        if (orderMenus.stream().map(OrderMenu::getMenuName).distinct().count() != orderMenus.size()) {
            throw new ErrorMessage(ORDER_ERROR);
        }
    }

    private void validateMenuSize(List<OrderMenu> orderMenus) {
        if (orderMenus.size() < MIN_MENU_RANGE || orderMenus.size() > MAX_MENU_RANGE) {
            throw new ErrorMessage(ORDER_ERROR);
        }
    }

    private void validateMenuAllDrinking(List<OrderMenu> orderMenus) {
        if (orderMenus.stream().allMatch(orderMenu -> orderMenu.compareMenuType(MenuType.DRINKING))) {
            throw new ErrorMessage(ORDER_ERROR);
        }
    }

    public Integer getOrderPrice() {
        return orderMenus.stream()
                .mapToInt(OrderMenu::calculatePrice)
                .sum();
    }

    public boolean canApplyEvent() {
        return getOrderPrice() >= MIN_TOTAL_PRICE;
    }

    public List<OrderMenu> getOrderMenus() {
        return orderMenus;
    }

    public OrderDto toDto() {
        List<MenuAmountDto> collect = orderMenus.stream()
                .map(orderMenu -> new MenuAmountDto(orderMenu.getMenuName(), orderMenu.getCount()))
                .collect(Collectors.toList());
        return new OrderDto(collect);
    }
}
