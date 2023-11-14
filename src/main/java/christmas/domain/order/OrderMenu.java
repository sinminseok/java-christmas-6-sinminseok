package christmas.domain.order;

import christmas.domain.menu.Menu;
import christmas.domain.menu.MenuBase;
import christmas.domain.menu.MenuType;

public class OrderMenu extends MenuBase {

    public OrderMenu(Menu menu, Integer count) {
        super(menu, count);
    }

    public boolean compareMenuType(MenuType menuType) {
        return menu.isSameMenuType(menuType);
    }

    @Override
    public Integer calculatePrice() {
        return menu.getPrice() * count;
    }
}
