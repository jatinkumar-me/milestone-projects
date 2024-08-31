package com.jatin.customer_sorting;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * CustomerService
 */
public class CustomerService {

    /**
     * BONUS: I've added a city sortCustomersByCity method.
     */
    private static final Comparator<Customer> cityComparator = new Comparator<Customer>() {
        @Override
        public int compare(Customer c1, Customer c2) {
            return c1.getCity().compareTo(c2.getCity());
        };
    };

    public void sortCustomersByName(List<Customer> customers) {
        Collections.sort(customers);
    }

    public void sortCustomersByCity(List<Customer> customers) {
        Collections.sort(customers, cityComparator);
    }

    public List<String> getCustomerNames(List<Customer> customers) {
        return customers.stream()
                .map(Customer::getCustomerName)
                .collect(Collectors.toList());
    }

    public List<String> getCustomerCities(List<Customer> customers) {
        return customers.stream()
                .map(Customer::getCity)
                .collect(Collectors.toList());
    }
}
