package christmas.repository;

import christmas.domain.user.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerRepository {
    private static final List<Customer> customers = new ArrayList<>();

    public static void save(Customer customer) {
        customers.add(customer);
    }
}
