package christmas.domain.plan;

import java.util.Arrays;
import java.util.function.Function;

public enum Badge {
    NONE("없음",(price) -> price < 5000),
    STAR("별",(price) -> 5000 <= price && price < 10000),
    TREE("트리",(price) -> 10000 <= price && price < 20000),
    SANTA("산타",(price) -> 20000 <= price);

    private final String name;
    private final Function<Integer, Boolean> isBadgeState;

    Badge(String name, Function<Integer, Boolean> isBadgeState) {
        this.name = name;
        this.isBadgeState = isBadgeState;
    }

    public static Badge of(int price) {
        return Arrays.stream(Badge.values())
                .filter(badge -> badge.isMatch(price))
                .findFirst()
                .orElse(NONE);
    }

    private boolean isMatch(int count) {
        return isBadgeState.apply(count);
    }

    public String getName() {
        return name;
    }
}
