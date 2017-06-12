package ro.sci.carrental.repository;

import ro.sci.carrental.domain.Customer;

import java.util.List;

/**
 * Created by Ivett on 28-May-17.
 */
public interface CustomerRepository {

    List<Customer> getAll();

    void add(Customer customer);

    void delete(Customer customer);

}
