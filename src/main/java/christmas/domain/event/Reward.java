package christmas.domain.event;

public class Reward {
    private final String name;
    private final Integer discountPrice;

    public Reward(String name, Integer discountPrice) {
        this.name = name;
        this.discountPrice = discountPrice;
    }
}
