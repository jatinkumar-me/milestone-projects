package com.jatin.customer_sorting;

public class Customer implements Comparable<Customer> {

    private int customerId;
    private String customerName;
    private Gender gender;
    private boolean isSeniorCitizen;
    private String city;

    public Customer(int customerId, String customerName, Gender gender, boolean isSeniorCitizen, String city) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.gender = gender;
        this.isSeniorCitizen = isSeniorCitizen;
        this.city = city;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public boolean isSeniorCitizen() {
        return isSeniorCitizen;
    }

    public void setSeniorCitizen(boolean isSeniorCitizen) {
        this.isSeniorCitizen = isSeniorCitizen;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", gender=" + gender
                + ", isSeniorCitizen=" + isSeniorCitizen + ", city=" + city + "]";
    }

    @Override
    public int compareTo(Customer other) {
        return this.customerName.compareTo(other.customerName);
    }

}
