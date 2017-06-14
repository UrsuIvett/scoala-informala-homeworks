package main.java.ro.sci.carrental.repository;

import main.java.ro.sci.carrental.domain.customer.Customer;

import java.util.List;

/**
 * Created by Ivett on 28-May-17.
 */
public interface CustomerRepository {

    List<Customer> getAll();

    void add(Customer customer);

    void delete(Customer customer);

}
