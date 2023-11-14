package christmas.dto;

import java.util.List;

public class OrderDto {
    private final List<MenuAmountDto> orderMenus;

    public OrderDto(List<MenuAmountDto> orderMenuDtos) {
        this.orderMenus = orderMenuDtos;
    }

    public List<MenuAmountDto> getOrderMenus() {
        return orderMenus;
    }
}
