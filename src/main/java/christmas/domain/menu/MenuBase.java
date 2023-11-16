package christmas.domain.menu;

import java.util.Objects;

public abstract class MenuBase {
    protected final Menu menu;
    protected final Integer count;

    public MenuBase(Menu menu, Integer count) {
        this.menu = menu;
        this.count = count;
    }

    public abstract Integer calculatePrice();

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
        MenuBase that = (MenuBase) o;
        return Objects.equals(menu, that.menu) && Objects.equals(count, that.count);
    }

    @Override
    public int hashCode() {
        return Objects.hash(menu, count);
    }
}
