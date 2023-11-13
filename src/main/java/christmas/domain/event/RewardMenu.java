package christmas.domain.event;

import christmas.domain.menu.Menu;

import java.util.Objects;

public class RewardMenu {
    private final Menu menu;
    private final Integer count;

    public RewardMenu(Menu menu, Integer count) {
        this.menu = menu;
        this.count = count;
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
        RewardMenu that = (RewardMenu) o;
        return Objects.equals(menu, that.menu) && Objects.equals(count, that.count);
    }

    @Override
    public int hashCode() {
        return Objects.hash(menu, count);
    }
}
