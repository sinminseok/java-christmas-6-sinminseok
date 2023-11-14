package christmas.domain.reward;

import java.util.Objects;

public class Reward {
    private final String name;
    private final Integer discountPrice;

    public Reward(String name, Integer discountPrice) {
        this.name = name;
        this.discountPrice = discountPrice;
    }

    public String getName() {
        return name;
    }

    public Integer getDiscountPrice() {
        return discountPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reward reward = (Reward) o;
        return Objects.equals(name, reward.name) && Objects.equals(discountPrice, reward.discountPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, discountPrice);
    }
}
