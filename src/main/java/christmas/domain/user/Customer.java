package christmas.domain.user;

import christmas.domain.plan.Badge;
import christmas.domain.plan.Plan;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Customer {
    private final List<Plan> plans;

    private Customer(List<Plan> plans) {
        this.plans = plans;
    }

    public static Customer from(Plan plan) {
        return new Customer(List.of(plan));
    }

    public Map<Badge, Integer> findBadge() {
        return plans.stream()
                .map(Plan::awardBadge)
                .collect(Collectors.toMap(Function.identity(), __ -> 1, Integer::sum, () -> new EnumMap<>(Badge.class)));
    }
}
