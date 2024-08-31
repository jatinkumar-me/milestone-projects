package com.jatin.customer_sorting;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * <h1>
 * Task preview - Customer Sorting
 * </h1>
 * 
 * The customer data of a departmental store is being analyzed.
 * Help sort the data by alphabetical order of customer names. The details of a
 * customer like a customer ID, name, gender, city, and senior citizen status,
 * will be captured in a class Customer.
 * <ul>
 * <li>Define the Customer class with customer ID, name, gender, city, is the
 * customer a senior citizen or not.</li>
 * <li>Define a parameterized constructor.</li>
 * <li>Declare getter and setter methods for all the variables.</li>
 * <li>Generate a toString method as shown below.</li>
 * 
 * <pre>
 *      "Customer{" "customerId=" + customerId + ", customerName='" + customerName + ''' + ", customerGender='" + customerGender + ''' + ", isSeniorCitizen=" + isSeniorCitizen + ", city='" + city + ''' + '}';
 * </pre>
 * 
 * <li>The Customer class must implement the Comparable interface.</li>
 * <li>Define the CustomerService class that sorts the customer objects by
 * name.</li>
 * <li>Define a method</li>
 * </ul>
 * 
 * <pre>
 * public List getListOfCustomersSortedByName(List customerList) {
 *     return list;
 * }
 * </pre>
 *
 * <h2>Sample Input:</h2>
 * 
 * <pre>
 * List customerList = Arrays.asList(new Customer(333, "Janani", "Female", false, "Kolkata"),
 *         new Customer(666, "Thrisha", "Female", true, "Delhi"),
 *         new Customer(222, "Kishan", "Male", false, "Mumbai"),
 *         new Customer(111, "Anitha", "Female", false, "Bangalore"));
 * </pre>
 *
 * <h2>Expected Output:</h2>
 * [Anitha, Janani, Kishan, Thrisha]
 *
 */
public class App {

    public static void main(String[] args) {

        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer(2323, "Jatin", Gender.MALE, false, "Kanpur"));
        customers.add(new Customer(2324, "JOfe", Gender.FEMALE, true, "Bangalore"));
        customers.add(new Customer(2325, "Mallika", Gender.MALE, false, "Mumbai"));
        customers.add(new Customer(2326, "Anitha", Gender.FEMALE, false, "Kanpur"));

        System.out.println(customers);

        CustomerService customerService = new CustomerService();

        System.out.println("\nSorting by name:");
        customerService.sortCustomersByName(customers);
        System.out.println(customerService.getCustomerNames(customers));

        System.out.println("\nSorting by city:");
        customerService.sortCustomersByCity(customers);
        System.out.println(customerService.getCustomerCities(customers));
    }
}
