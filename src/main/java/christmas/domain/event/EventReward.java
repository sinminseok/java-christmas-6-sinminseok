package christmas.domain.event;

import christmas.domain.menu.OrderMenu;

public class EventReward<T> {
    private T rewardValue;

    public EventReward(T rewardValue) {
        this.rewardValue = rewardValue;
    }

    public boolean isMenuItemType() {
        return rewardValue instanceof OrderMenu;
    }

    public T getRewardValue() {
        return rewardValue;
    }
}