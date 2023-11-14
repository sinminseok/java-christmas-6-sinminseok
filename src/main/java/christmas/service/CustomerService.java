package christmas.service;

import christmas.domain.plan.Plan;
import christmas.domain.user.Customer;
import christmas.repository.CustomerRepository;

public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void save(Plan plan) {
        customerRepository.save(Customer.from(plan));
    }
}
