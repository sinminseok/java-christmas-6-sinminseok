package christmas.dto;

public class RewardDto {
    private final String name;
    private final Integer discountPrice;

    public RewardDto(String name, Integer discountPrice) {
        this.name = name;
        this.discountPrice = discountPrice;
    }

    public String getName() {
        return name;
    }

    public Integer getDiscountPrice() {
        return discountPrice;
    }
}
