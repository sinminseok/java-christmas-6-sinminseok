package christmas.dto;

import java.util.List;

public class OrderDto {
    private final List<MenuItemDto> orderMenuDtos;

    public OrderDto(List<MenuItemDto> orderMenuDtos) {
        this.orderMenuDtos = orderMenuDtos;
    }

    public List<MenuItemDto> getOrderMenuDtos() {
        return orderMenuDtos;
    }
}
