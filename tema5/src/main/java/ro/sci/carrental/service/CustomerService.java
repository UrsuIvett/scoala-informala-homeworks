package ro.sci.carrental.service;

import ro.sci.carrental.domain.customer.Customer;
import ro.sci.carrental.repository.CustomerRepository;

import java.util.List;

/**
 * Created by Ivett on 05-Jun-17.
 */

public interface CustomerService<T extends Customer> {
    void setCustomerRepository(CustomerRepository<Customer> customerRepository);
    List<T> getAll();
    void add (T t);
    void delete (T t);
    void update (T t);
    List<Customer> findCustomerByMobile(String mobile);
    List<Customer> findCustomerByLastName(String lastName);
}