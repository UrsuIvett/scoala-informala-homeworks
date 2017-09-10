package ro.sci.carrental.service;

import ro.sci.carrental.domain.customer.Customer;

import java.util.List;

/**
 * Created by Ivett on 05-Jun-17.
 */

public interface CustomerService {

    List<Customer> findCustomerByFirstName(String FirstName);

    List<Customer> findCustomerByLastName(String LastName);
}