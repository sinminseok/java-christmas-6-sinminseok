package christmas.service;

import christmas.domain.menu.Menu;
import christmas.domain.order.OrderMenu;
import christmas.domain.order.Order;
import christmas.dto.MenuWithAmountDto;
import christmas.dto.OrderDto;
import christmas.repository.MenuRepository;

import java.util.List;
import java.util.stream.Collectors;

public class OrderService {
    private final MenuRepository menuRepository;

    public OrderService(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    public Order createOrder(OrderDto orderDto) {
        List<OrderMenu> orderMenus = createOrderMenus(orderDto.getOrderMenuDtos());
        return new Order(orderMenus);
    }

    private List<OrderMenu> createOrderMenus(List<MenuWithAmountDto> menuWithAmountDtos) {
        return menuWithAmountDtos.stream()
                .map(menuItemDto -> createOrderMenu(menuItemDto))
                .collect(Collectors.toList());
    }

    private OrderMenu createOrderMenu(MenuWithAmountDto menuWithAmountDto) {
        Menu menu = findMenuByName(menuWithAmountDto.getMenuName());
        return new OrderMenu(menu, menuWithAmountDto.getAmount());
    }

    private Menu findMenuByName(String name) {
        return menuRepository.findByName(name);
    }
}
