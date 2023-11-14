package christmas.domain.event;

/*
다양한 유형의 보상을 반환하기 위해 제네릭 타입으로 선언
 */
public class EventReward<T> {
    private T rewardValue;

    public EventReward(T rewardValue) {
        this.rewardValue = rewardValue;
    }

    public Reward wrapReward(String eventName) {
        if (isRewardMenuType()) {
            return new Reward(eventName, ((RewardMenu) rewardValue).calculatePrice());
        }
        return new Reward(eventName, (Integer) rewardValue);
    }

    public RewardMenu wrapRewardMenu() {
        return (RewardMenu) rewardValue;
    }

    public boolean isRewardMenuType() {
        return rewardValue instanceof RewardMenu;
    }

    public T getRewardValue() {
        return rewardValue;
    }
}