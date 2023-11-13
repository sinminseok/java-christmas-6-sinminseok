package christmas.domain.menu;

public class OrderMenu extends MenuBase{

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
