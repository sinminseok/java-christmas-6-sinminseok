package christmas.service;

import christmas.domain.menu.Menu;
import christmas.domain.menu.MenuItem;
import christmas.domain.order.Order;
import christmas.dto.OrderDto;
import christmas.repository.MenuRepository;

import java.util.stream.Collectors;

public class OrderService {
    private final MenuRepository menuRepository;

    public OrderService(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    public Order createOrder(OrderDto orderDto) {
        return new Order(orderDto.getOrderMenuDtos().stream()
                .map(menuItemDto -> new MenuItem(
                        menuRepository.findByName(menuItemDto.getMenuName()),
                        menuItemDto.getAmount()
                ))
                .collect(Collectors.toList()));
    }

}
