package christmas.service;

import christmas.domain.menu.Menu;
import christmas.domain.order.OrderMenu;
import christmas.domain.order.Order;
import christmas.dto.MenuAmountDto;
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
        List<OrderMenu> orderMenus = createOrderMenus(orderDto.getOrderMenus());
        return new Order(orderMenus);
    }

    public List<MenuAmountDto> convertToMenuAmountDtos(Order order) {
        return order.getOrderMenus().stream()
                .map(orderMenu -> new MenuAmountDto(orderMenu.getMenuName(), orderMenu.getCount()))
                .collect(Collectors.toList());
    }

    private List<OrderMenu> createOrderMenus(List<MenuAmountDto> menuAmountDtos) {
        return menuAmountDtos.stream()
                .map(menuAmountDto -> createOrderMenu(menuAmountDto))
                .collect(Collectors.toList());
    }

    private OrderMenu createOrderMenu(MenuAmountDto menuAmountDto) {
        Menu menu = findMenuByName(menuAmountDto.getMenuName());
        return new OrderMenu(menu, menuAmountDto.getAmount());
    }

    private Menu findMenuByName(String name) {
        return menuRepository.findByName(name);
    }
}
