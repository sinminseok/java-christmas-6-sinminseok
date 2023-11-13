package christmas.domain.menu;

import java.util.Objects;

public class OrderMenu {
    private final Menu menu;
    private final Integer count;

    public OrderMenu(Menu menu, Integer count) {
        this.menu = menu;
        this.count = count;
    }

    public boolean compareMenuType(MenuType menuType) {
        return menu.isSameMenuType(menuType);
    }

    public Integer calculatePrice() {
        return menu.getPrice() * count;
    }

    public String getMenuName() {
        return menu.getName();
    }

    public Integer getCount() {
        return count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderMenu menuItem = (OrderMenu) o;
        return Objects.equals(menu, menuItem.menu) && Objects.equals(count, menuItem.count);
    }

    @Override
    public int hashCode() {
        return Objects.hash(menu, count);
    }
}
