package christmas.domain.event;

public class EventReward<T> {
    private T rewardValue;

    public EventReward(T rewardValue) {
        this.rewardValue = rewardValue;
    }

    public boolean isRewardMenuType() {
        return rewardValue instanceof RewardMenu;
    }

    public T getRewardValue() {
        return rewardValue;
    }
}