package ro.sci.carrental.service;

import ro.sci.carrental.domain.customer.Customer;

import java.util.List;

/**
 * Created by Ivett on 05-Jun-17.
 */

public interface CustomerService<T extends Customer> {

    void add (T t);
    void delete (T t);
    void update (T t);
    List<Customer> findCustomerByFirstName(String FirstName);
    List<Customer> findCustomerByLastName(String LastName);
}