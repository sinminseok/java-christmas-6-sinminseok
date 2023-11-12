package christmas.domain.menu;

import java.util.Objects;

public class MenuItem {
    private final Menu menu;
    private final Integer count;

    public MenuItem(Menu menu, Integer count) {
        this.menu = menu;
        this.count = count;
    }

    public boolean compareMenuType(MenuType menuType) {
        return menu.isSameMenuType(menuType);
    }

    public Integer getMenuItemPrice() {
        return menu.getPrice();
    }

    public Integer getCount() {
        return count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MenuItem menuItem = (MenuItem) o;
        return Objects.equals(menu, menuItem.menu) && Objects.equals(count, menuItem.count);
    }

    @Override
    public int hashCode() {
        return Objects.hash(menu, count);
    }
}
