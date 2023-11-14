package christmas.dto;

import java.util.List;

public class OrderDto {
    private final List<MenuWithAmountDto> orderMenuDtos;

    public OrderDto(List<MenuWithAmountDto> orderMenuDtos) {
        this.orderMenuDtos = orderMenuDtos;
    }

    public List<MenuWithAmountDto> getOrderMenuDtos() {
        return orderMenuDtos;
    }
}
