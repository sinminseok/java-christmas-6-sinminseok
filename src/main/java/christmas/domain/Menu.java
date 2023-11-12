package christmas.domain;

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
}
