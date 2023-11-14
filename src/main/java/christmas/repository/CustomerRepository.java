package christmas.repository;

import christmas.domain.user.Customer;

import java.util.ArrayList;
import java.util.List;

/*
1 월 새해 이벤트에 사용될 고객 정보를 관리하는 저장소
*/
public class CustomerRepository {
    private static final List<Customer> customers = new ArrayList<>();

    public static void save(Customer customer) {
        customers.add(customer);
    }
}
