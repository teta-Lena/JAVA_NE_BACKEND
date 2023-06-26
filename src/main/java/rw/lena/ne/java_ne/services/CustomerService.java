package rw.lena.ne.java_ne.services;

import rw.lena.ne.java_ne.models.Customer;


public interface CustomerService {

    Customer create(Customer user);

    boolean isNotUnique(Customer user);

    void validateNewRegistration(Customer user);

    Customer getLoggedInCustomer();

}