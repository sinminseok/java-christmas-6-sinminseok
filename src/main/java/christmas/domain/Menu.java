package christmas.domain;

import java.util.Objects;

public class Menu {
    private final String name;
    private final Integer price;
    private final MenuType menuType;

    private Menu(String name, Integer price, MenuType menuType) {
        this.name = name;
        this.price = price;
        this.menuType = menuType;
    }

    public static Menu of(String name, Integer price, MenuType menuType) {
        return new Menu(name, price, menuType);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Menu menu = (Menu) o;
        return Objects.equals(name, menu.name) && Objects.equals(price, menu.price) && menuType == menu.menuType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, menuType);
    }
}
