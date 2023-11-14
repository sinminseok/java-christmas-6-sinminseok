package christmas.domain.user;

import christmas.domain.plan.Plan;

import java.util.List;

public class Customer {
    private final List<Plan> plans;

    private Customer(List<Plan> plans) {
        this.plans = plans;
    }

    public static Customer from(Plan plan) {
        return new Customer(List.of(plan));
    }
}
