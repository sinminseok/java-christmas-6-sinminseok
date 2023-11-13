package christmas.domain.event;

import christmas.domain.menu.Menu;
import christmas.domain.menu.MenuBase;

public class RewardMenu extends MenuBase {

    public RewardMenu(Menu menu, Integer count) {
        super(menu, count);
    }

    @Override
    public Integer calculatePrice() {
        return menu.getPrice() * count;
    }
}
