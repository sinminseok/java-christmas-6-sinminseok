package christmas.domain;

public class EventReward<T> {
    private T rewardValue;

    public EventReward(T rewardValue) {
        this.rewardValue = rewardValue;
    }

    public T getRewardValue() {
        return rewardValue;
    }
}